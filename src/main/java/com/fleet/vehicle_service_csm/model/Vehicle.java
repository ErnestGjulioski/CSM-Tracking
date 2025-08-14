package com.fleet.vehicle_service_csm.model;

import com.fleet.vehicle_service_csm.ENUM.VehicleStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

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

    @NotBlank(message = "Kennzeichen darf nicht leer sein")
    private String licensePlate;

    @NotBlank(message = "Hersteller ist erforderlich")
    private String manufacturer;

    @NotBlank(message = "Modell ist erforderlich")
    private String model;

    @Min(value = 1980, message = "Fahrzeugjahr muss ≥ 1980 sein")
    private int year;

    @Enumerated(EnumType.STRING)
    private VehicleStatus status;

    private LocalDateTime lastMaintenance;
    private LocalDateTime nextMaintenance;

    public Vehicle() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public VehicleStatus getStatus() { return status; }
    public void setStatus(VehicleStatus status) { this.status = status; }

    public LocalDateTime getLastMaintenance() { return lastMaintenance; }
    public void setLastMaintenance(LocalDateTime lastMaintenance) { this.lastMaintenance = lastMaintenance; }

    public LocalDateTime getNextMaintenance() { return nextMaintenance; }
    public void setNextMaintenance(LocalDateTime nextMaintenance) { this.nextMaintenance = nextMaintenance; }
}