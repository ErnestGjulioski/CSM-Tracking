package com.fleet.vehicle_service_csm.VehicleEntity.model;

import com.fleet.vehicle_service_csm.MaintanceEntity.model.MaintenanceRecord;
import com.fleet.vehicle_service_csm.VehicleEntity.ENUM.VehicleStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity representing a vehicle in the fleet.
 * Used for tracking status, maintenance and identification via license plate.
 */

@Entity
public class Vehicle {

    @Setter
    @Getter
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MaintenanceRecord> maintenanceRecords = new ArrayList<>();

    private Double lastLatitude;
    private Double lastLongitude;


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

    public Double getLastLatitude() { return lastLatitude; }
    public void setLastLatitude(Double lastLatitude) { this.lastLatitude = lastLatitude; }

    public Double getLastLongitude() { return lastLongitude; }
    public void setLastLongitude(Double lastLongitude) { this.lastLongitude = lastLongitude; }

    public LocalDateTime getNextMaintenance() { return nextMaintenance; }
    public void setNextMaintenance(LocalDateTime nextMaintenance) { this.nextMaintenance = nextMaintenance; }

    public LocalDateTime getLastMaintenance() { return lastMaintenance; }
    public void setLastMaintenance(LocalDateTime lastMaintenance) { this.lastMaintenance = lastMaintenance; }

}