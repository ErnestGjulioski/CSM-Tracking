package com.fleet.vehicle_service_csm.MaintanceEntity.mapper;

import com.fleet.vehicle_service_csm.MaintanceEntity.dto.MaintenanceRecordDTO;
import com.fleet.vehicle_service_csm.MaintanceEntity.model.MaintenanceRecord;

public class MaintenanceRecordMapper {

    public static MaintenanceRecordDTO toDTO(MaintenanceRecord entity) {
        if (entity == null) {
            return null;
        }
        MaintenanceRecordDTO dto = new MaintenanceRecordDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDueAtKm(entity.getDueAtKm());
        dto.setDueAtDate(entity.getDueAtDate());
        dto.setStatus(entity.getStatus());
        dto.setNotes(entity.getNotes());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        if (entity.getVehicle() != null) {
            dto.setVehicleId(entity.getVehicle().getId());
        }

        return dto;
    }

    public static MaintenanceRecord toEntity(MaintenanceRecordDTO dto) {
        if (dto == null) {
            return null;
        }
        MaintenanceRecord entity = new MaintenanceRecord();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDueAtKm(dto.getDueAtKm());
        entity.setDueAtDate(dto.getDueAtDate());
        entity.setStatus(dto.getStatus());
        entity.setNotes(dto.getNotes());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        // Vehicle wird im Service gesetzt nicht hier
        return entity;
    }
}
