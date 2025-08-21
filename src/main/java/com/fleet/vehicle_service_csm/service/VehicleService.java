package com.fleet.vehicle_service_csm.service;

import com.fleet.vehicle_service_csm.dto.VehicleDTO;
import com.fleet.vehicle_service_csm.mapper.VehicleMapper;
import com.fleet.vehicle_service_csm.model.Vehicle;
import com.fleet.vehicle_service_csm.ENUM.VehicleStatus;
import com.fleet.vehicle_service_csm.repository.VehicleRepository;
import com.fleet.vehicle_service_csm.specification.VehicleSpecification;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
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
                .orElseThrow(() -> new RuntimeException("Vehicle not found with ID: " + id));
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
                .orElseThrow(() -> new RuntimeException("Vehicle not found with ID: " + id));

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
        Vehicle vehicle = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with ID: " + id));
        repository.delete(vehicle);
    }

    /**
     * Mehrfachfilter-Suche
     */
    public List<VehicleDTO> search(String licensePlate, String manufacturer, VehicleStatus status, Integer year) {
        Specification<Vehicle> spec = VehicleSpecification.hasLicensePlate(licensePlate)
                .and(VehicleSpecification.hasManufacturer(manufacturer))
                .and(VehicleSpecification.hasStatus(String.valueOf(status)))
                .and(VehicleSpecification.hasYear(year));

        return repository.findAll((Sort) spec)
                .stream()
                .map(VehicleMapper::toDTO)
                .collect(Collectors.toList());
    }

}
