package com.fleet.vehicle_service_csm.service;

import com.fleet.vehicle_service_csm.model.Vehicle;
import com.fleet.vehicle_service_csm.repository.VehicleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository repository;

    public VehicleService(VehicleRepository repository) {
        this.repository = repository;
    }

    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    public Vehicle findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Fahrzeug mit ID " + id + " nicht gefunden"));
    }

    public Vehicle save(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    public Vehicle update(Long id, Vehicle newData) {
        return repository.findById(id)
                .map(vehicle -> {
                    vehicle.setLicensePlate(newData.getLicensePlate());
                    vehicle.setManufacturer(newData.getManufacturer());
                    vehicle.setModel(newData.getModel());
                    vehicle.setYear(newData.getYear());
                    vehicle.setStatus(newData.getStatus());
                    vehicle.setLastMaintenance(newData.getLastMaintenance());
                    vehicle.setNextMaintenance(newData.getNextMaintenance());
                    return repository.save(vehicle);
                })
                .orElseThrow(() -> new EntityNotFoundException("Fahrzeug mit ID " + id + " nicht gefunden"));
    }

    public void delete(Long id) {
        Vehicle vehicle = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Fahrzeug mit ID " + id + " nicht gefunden"));
        repository.delete(vehicle);
    }
}
