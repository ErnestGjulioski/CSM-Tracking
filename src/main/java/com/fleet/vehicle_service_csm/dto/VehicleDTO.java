package com.fleet.vehicle_service_csm.dto;

import com.fleet.vehicle_service_csm.ENUM.VehicleStatus;

import java.time.LocalDateTime;

public class VehicleDTO {

    private String licensePlate;
    private String model;
    private VehicleStatus status;
    private LocalDateTime lastMaintenance;
    private LocalDateTime nextMaintenanceDue;

    public VehicleDTO() {}

    // Getter / Setter
    public String getLicensePlate() {
        return licensePlate;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public VehicleStatus getStatus() {
        return status;
    }
    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public LocalDateTime getLastMaintenance() {
        return lastMaintenance;
    }
    public void setLastMaintenance(LocalDateTime lastMaintenance) {
        this.lastMaintenance = lastMaintenance;
    }

    public LocalDateTime getNextMaintenanceDue() {
        return nextMaintenanceDue;
    }
    public void setNextMaintenanceDue(LocalDateTime nextMaintenanceDue) {
        this.nextMaintenanceDue = nextMaintenanceDue;
    }
}