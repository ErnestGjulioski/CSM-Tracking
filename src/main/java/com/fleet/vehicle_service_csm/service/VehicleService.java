package com.fleet.vehicle_service_csm.service;

import com.fleet.vehicle_service_csm.dto.VehicleDTO;
import com.fleet.vehicle_service_csm.mapper.VehicleMapper;
import com.fleet.vehicle_service_csm.model.Vehicle;
import com.fleet.vehicle_service_csm.repository.VehicleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private final VehicleRepository repository;
    private final VehicleMapper mapper;

    public VehicleService(VehicleRepository repository, VehicleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<VehicleDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public VehicleDTO findById(Long id) {
        Vehicle v = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Fahrzeug mit ID " + id + " nicht gefunden"));
        return mapper.toDTO(v);
    }

    public VehicleDTO create(VehicleDTO dto) {
        Vehicle saved = repository.save(mapper.toEntity(dto));
        return mapper.toDTO(saved);
    }

    public VehicleDTO update(Long id, VehicleDTO dto) {
        Vehicle v = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Fahrzeug mit ID " + id + " nicht gefunden"));
        v.setLicensePlate(dto.getLicensePlate());
        v.setManufacturer(dto.getManufacturer());
        v.setModel(dto.getModel());
        v.setYear(dto.getYear());
        v.setStatus(dto.getStatus());
        v.setLastMaintenance(dto.getLastMaintenance());
        v.setNextMaintenance(dto.getNextMaintenance());
        Vehicle updated = repository.save(v);
        return mapper.toDTO(updated);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Fahrzeug mit ID " + id + " nicht gefunden");
        }
        repository.deleteById(id);
    }
}
