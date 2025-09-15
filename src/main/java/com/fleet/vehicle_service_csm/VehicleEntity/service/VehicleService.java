package com.fleet.vehicle_service_csm.VehicleEntity.service;

import com.fleet.vehicle_service_csm.VehicleEntity.dto.VehicleDTO;
import com.fleet.vehicle_service_csm.VehicleEntity.mapper.VehicleMapper;
import com.fleet.vehicle_service_csm.VehicleEntity.model.Vehicle;
import com.fleet.vehicle_service_csm.VehicleEntity.ENUM.VehicleStatus;
import com.fleet.vehicle_service_csm.VehicleEntity.repository.VehicleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VehicleService {

    private final VehicleRepository repository;

    public VehicleService(VehicleRepository repository) {
        this.repository = repository;
    }

    /**
     * Alle Fahrzeuge abrufen
     */
    public List<VehicleDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(VehicleMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Fahrzeug anhand der ID abrufen
     */
    public VehicleDTO findById(Long id) {
        Vehicle vehicle = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle mit ID " + id + " nicht gefunden"));
        return VehicleMapper.toDTO(vehicle);
    }

    /**
     * Neues Fahrzeug anlegen
     */
    public VehicleDTO create(VehicleDTO dto) {
        Vehicle vehicle = VehicleMapper.toEntity(dto);
        Vehicle saved = repository.save(vehicle);
        return VehicleMapper.toDTO(saved);
    }

    /**
     * Fahrzeug aktualisieren
     */
    public VehicleDTO update(Long id, VehicleDTO dto) {
        Vehicle existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle mit ID " + id + " nicht gefunden"));

        existing.setLicensePlate(dto.getLicensePlate());
        existing.setManufacturer(dto.getManufacturer());
        existing.setModel(dto.getModel());
        existing.setYear(dto.getYear());
        existing.setStatus(dto.getStatus());
        existing.setLastMaintenance(dto.getLastMaintenance());
        existing.setNextMaintenance(dto.getNextMaintenance());

        Vehicle updated = repository.save(existing);
        return VehicleMapper.toDTO(updated);
    }

    /**
     * Fahrzeug löschen
     */
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Vehicle mit ID " + id + " nicht gefunden");
        }
        repository.deleteById(id);
    }

    /**
     * Mehrfachfilter-Suche
     */
    public List<VehicleDTO> filter(String licensePlate, String manufacturer, VehicleStatus status, Integer year) {
        return repository.findAll().stream()
                .filter(v -> licensePlate == null || v.getLicensePlate().equalsIgnoreCase(licensePlate))
                .filter(v -> manufacturer == null || v.getManufacturer().equalsIgnoreCase(manufacturer))
                .filter(v -> status == null || v.getStatus() == status)
                .filter(v -> year == null || v.getYear() == year)
                .map(VehicleMapper::toDTO)
                .toList();
    }


}
