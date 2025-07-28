package com.fleet.vehicle_service_csm.service;

import com.fleet.vehicle_service_csm.model.Vehicle;
import com.fleet.vehicle_service_csm.dto.VehicleDTO;
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

    private void applyDtoToEntity(VehicleDTO dto, Vehicle vehicle) {
        vehicle.setLicensePlate(dto.getLicensePlate());
        vehicle.setModel(dto.getModel());
        vehicle.setStatus(dto.getStatus());
        vehicle.setLastMaintenance(dto.getLastMaintenance());
        vehicle.setNextMaintenance(dto.getNextMaintenanceDue());
    }


    public Vehicle createFromDto(VehicleDTO dto) {
        Vehicle vehicle = new Vehicle();
        applyDtoToEntity(dto,vehicle);
        return repository.save(vehicle);
   }

   public Vehicle updateFromDto(Long id, VehicleDTO dto) {
        Vehicle vehicle = findById(id);
        applyDtoToEntity(dto, vehicle);
        return repository.save(vehicle);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }
}
