package com.fleet.vehicle_service_csm.MaintanceEntity.model;

import com.fleet.vehicle_service_csm.VehicleEntity.model.Vehicle;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
public class MaintenanceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;          // e.g. "Oil Change"
    private Integer dueAtKm;       // e.g. 15000
    private LocalDate dueAtDate;   // alternative: a due date
    private String status;         // e.g. "OPEN", "DONE", "OVERDUE"
    private String notes;          // free text

    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    // link to vehicle
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

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

    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
}
