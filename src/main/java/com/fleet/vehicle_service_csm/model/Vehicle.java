package com.fleet.vehicle_service_csm.model;

import com.fleet.vehicle_service_csm.ENUM.VehicleStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity representing a vehicle in the fleet.
 * Used for tracking status, maintenance and identification via license plate.
 */

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String LicensePlate;
    private String model;

    /**
     * Current status of the vehicle (e.g. ACTIVE, INACTIVE).
     */

    @Enumerated(EnumType.STRING)
    private VehicleStatus status;

    private LocalDateTime lastMaintenance;
    private LocalDateTime nextMaintenance;

    //StandardKonstruktor
    public Vehicle() {}

    public Vehicle(String LicensePlate, VehicleStatus status) {
        this.LicensePlate = LicensePlate;
        this.status = status;
    }

    //getter/setter

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getLicensePlate() { return LicensePlate; }
    public void setLicensePlate(String LicensePlate) { this.LicensePlate = LicensePlate; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public VehicleStatus getStatus() { return status; }
    public void setStatus(VehicleStatus status) { this.status = status; }

    public LocalDateTime getLastMaintenance(){return lastMaintenance;}
    public void setLastMaintenance(LocalDateTime lastMaintance) { this.lastMaintenance = lastMaintance; }

    public LocalDateTime getNextMaintenance(){return nextMaintenance;}
    public void setNextMaintenance(LocalDateTime nextMaintance) { this.nextMaintenance = nextMaintance; }

}
