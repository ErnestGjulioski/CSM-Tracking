package com.fleet.vehicle_service_csm.service;

import com.fleet.vehicle_service_csm.model.Vehicle;
import com.fleet.vehicle_service_csm.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }

    public Vehicle create(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    public Vehicle update(Vehicle vehicle) {
        Vehicle v = findById(vehicle.getId());
        v.setLicensePlate(vehicle.getLicensePlate());
        v.setStatus(vehicle.getStatus());
        return repository.save(v);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


}
