package com.fleet.vehicle_service_csm.MaintanceEntity.dto;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public class MaintenanceRecordDTO {
    private Long id;
    private String title;
    private Integer dueAtKm;
    private LocalDate dueAtDate;
    private String status;
    private String notes;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private Long vehicleId;

    // --- Getters & Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Integer getDueAtKm() { return dueAtKm; }
    public void setDueAtKm(Integer dueAtKm) { this.dueAtKm = dueAtKm; }

    public LocalDate getDueAtDate() { return dueAtDate; }
    public void setDueAtDate(LocalDate dueAtDate) { this.dueAtDate = dueAtDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }

    public OffsetDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(OffsetDateTime updatedAt) { this.updatedAt = updatedAt; }

    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }
}
