package com.fleet.vehicle_service_csm.VehicleEntity.mapper;

import com.fleet.vehicle_service_csm.VehicleEntity.dto.VehicleDTO;
import com.fleet.vehicle_service_csm.VehicleEntity.model.Vehicle;
import com.fleet.vehicle_service_csm.MaintanceEntity.mapper.MaintenanceRecordMapper;

import java.util.stream.Collectors;

public class VehicleMapper {

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
        dto.setLastLatitude(vehicle.getLastLatitude());
        dto.setLastLongitude(vehicle.getLastLongitude());

        // Falls es MaintenanceRecords gibt -> mappen
        if (vehicle.getMaintenanceRecords() != null) {
            dto.setMaintenanceRecords(
                    vehicle.getMaintenanceRecords().stream()
                            .map(MaintenanceRecordMapper::toDTO)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }

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
        vehicle.setLastLatitude(dto.getLastLatitude());
        vehicle.setLastLongitude(dto.getLastLongitude());

        // MaintenanceRecords werden NICHT hier gesetzt,
        // das macht der Service über MaintenanceRecordMapper
        return vehicle;
    }
}
