package com.fleet.vehicle_service_csm.MaintanceEntity.service;

import com.fleet.vehicle_service_csm.MaintanceEntity.dto.MaintenanceRecordDTO;
import com.fleet.vehicle_service_csm.MaintanceEntity.mapper.MaintenanceRecordMapper;
import com.fleet.vehicle_service_csm.MaintanceEntity.model.MaintenanceRecord;
import com.fleet.vehicle_service_csm.MaintanceEntity.repository.MaintenanceRecordRepository;
import com.fleet.vehicle_service_csm.VehicleEntity.model.Vehicle;
import com.fleet.vehicle_service_csm.VehicleEntity.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaintenanceRecordService {

    private final MaintenanceRecordRepository repository;
    private final VehicleRepository vehicleRepository;

    public MaintenanceRecordService(MaintenanceRecordRepository repository, VehicleRepository vehicleRepository) {
        this.repository = repository;
        this.vehicleRepository = vehicleRepository;
    }

    public MaintenanceRecordDTO create(MaintenanceRecordDTO dto) {
        Vehicle vehicle = vehicleRepository.findById(dto.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        MaintenanceRecord entity = MaintenanceRecordMapper.toEntity(dto);
        entity.setVehicle(vehicle);

        MaintenanceRecord saved = repository.save(entity);

        recalculateMaintenanceDates(vehicle);

        return MaintenanceRecordMapper.toDTO(saved);
    }

    public List<MaintenanceRecordDTO> findAll() {
        return repository.findAll().stream()
                .map(MaintenanceRecordMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<MaintenanceRecordDTO> findById(Long id) {
        return repository.findById(id).map(MaintenanceRecordMapper::toDTO);
    }

    public MaintenanceRecordDTO update(Long id, MaintenanceRecordDTO dto) {
        MaintenanceRecord record = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        record.setTitle(dto.getTitle());
        record.setDueAtKm(dto.getDueAtKm());
        record.setDueAtDate(dto.getDueAtDate());
        record.setStatus(dto.getStatus());
        record.setNotes(dto.getNotes());

        if (dto.getVehicleId() != null) {
            Vehicle vehicle = vehicleRepository.findById(dto.getVehicleId())
                    .orElseThrow(() -> new RuntimeException("Vehicle not found"));
            record.setVehicle(vehicle);
        }

        MaintenanceRecord saved = repository.save(record);

        recalculateMaintenanceDates(saved.getVehicle());

        return MaintenanceRecordMapper.toDTO(saved);
    }

    public boolean delete(Long id) {
        Optional<MaintenanceRecord> record = repository.findById(id);
        if (record.isPresent()) {
            Vehicle vehicle = record.get().getVehicle();
            repository.deleteById(id);
            recalculateMaintenanceDates(vehicle);
            return true;
        }
        return false;
    }

    public List<MaintenanceRecordDTO> filterByVehicle(Long vehicleId) {
        return repository.findByVehicle_Id(vehicleId).stream()
                .map(MaintenanceRecordMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<MaintenanceRecordDTO> filterByDateRange(LocalDate start, LocalDate end) {
        return repository.findByDueAtDateBetween(start, end).stream()
                .map(MaintenanceRecordMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Hilfsfunktion: synchronisiert lastMaintenance & nextMaintenance im Vehicle
     */
    private void recalculateMaintenanceDates(Vehicle vehicle) {
        List<MaintenanceRecord> records = repository.findByVehicle_Id(vehicle.getId());

        vehicle.setLastMaintenance(
                records.stream()
                        .filter(r -> "DONE".equalsIgnoreCase(r.getStatus()))
                        .map(r -> r.getDueAtDate().atStartOfDay())
                        .max(java.time.LocalDateTime::compareTo)
                        .orElse(null)
        );

        vehicle.setNextMaintenance(
                records.stream()
                        .filter(r -> "OPEN".equalsIgnoreCase(r.getStatus()))
                        .map(r -> r.getDueAtDate().atStartOfDay())
                        .min(java.time.LocalDateTime::compareTo)
                        .orElse(null)
        );

        vehicleRepository.save(vehicle);
    }
}
