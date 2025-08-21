package com.fleet.vehicle_service_csm.mapper;

import com.fleet.vehicle_service_csm.dto.VehicleDTO;
import com.fleet.vehicle_service_csm.model.Vehicle;

public class VehicleMapper {

    /**
     * Konvertiert ein Vehicle-Entity in ein DTO
     */
    public static VehicleDTO toDTO(Vehicle vehicle) {
        if (vehicle == null) {
            return null;
        }
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

    /**
     * Konvertiert ein DTO in ein Vehicle-Entity
     */
    public static Vehicle toEntity(VehicleDTO dto) {
        if (dto == null) {
            return null;
        }
        Vehicle vehicle = new Vehicle();
        vehicle.setId(dto.getId());
        vehicle.setLicensePlate(dto.getLicensePlate());
        vehicle.setManufacturer(dto.getManufacturer());
        vehicle.setModel(dto.getModel());
        vehicle.setYear(dto.getYear());
        vehicle.setStatus(dto.getStatus());
        vehicle.setLastMaintenance(dto.getLastMaintenance());
        vehicle.setNextMaintenance(dto.getNextMaintenance());
        return vehicle;
    }
}
