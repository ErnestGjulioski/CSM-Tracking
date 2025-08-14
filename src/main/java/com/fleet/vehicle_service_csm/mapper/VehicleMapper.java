package com.fleet.vehicle_service_csm.mapper;

import com.fleet.vehicle_service_csm.dto.VehicleDTO;
import com.fleet.vehicle_service_csm.model.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    public VehicleDTO toDTO(Vehicle vehicle) {
        if (vehicle == null) return null;
        VehicleDTO dto = new VehicleDTO();
        dto.setId(vehicle.getId());
        dto.setLicensePlate(vehicle.getLicensePlate());
        dto.setManufacturer(vehicle.getManufacturer());
        dto.setModel(vehicle.getModel());
        dto.setYear(vehicle.getYear());
        dto.setStatus(vehicle.getStatus());
        dto.setLastMaintenance(vehicle.getLastMaintenance());
        dto.setNextMaintenance(vehicle.getNextMaintenance());
        return dto;
    }

    public Vehicle toEntity(VehicleDTO dto) {
        if (dto == null) return null;
        Vehicle v = new Vehicle();
        v.setId(dto.getId());
        v.setLicensePlate(dto.getLicensePlate());
        v.setManufacturer(dto.getManufacturer());
        v.setModel(dto.getModel());
        v.setYear(dto.getYear());
        v.setStatus(dto.getStatus());
        v.setLastMaintenance(dto.getLastMaintenance());
        v.setNextMaintenance(dto.getNextMaintenance());
        return v;
    }
}