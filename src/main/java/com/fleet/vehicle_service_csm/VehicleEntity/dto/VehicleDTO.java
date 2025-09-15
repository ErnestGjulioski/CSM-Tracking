package com.fleet.vehicle_service_csm.VehicleEntity.dto;

import com.fleet.vehicle_service_csm.MaintanceEntity.dto.MaintenanceRecordDTO;
import com.fleet.vehicle_service_csm.MaintanceEntity.model.MaintenanceRecord;
import com.fleet.vehicle_service_csm.VehicleEntity.ENUM.VehicleStatus;

import java.time.LocalDateTime;
import java.util.List;

public class VehicleDTO {
    private Long id;
    private String licensePlate;
    private String manufacturer;
    private String model;
    private Integer year;
    private VehicleStatus status;
    private List<MaintenanceRecordDTO> maintenanceRecords;

    private LocalDateTime lastMaintenance;
    private LocalDateTime nextMaintenance;

    private Double lastLatitude;
    private Double lastLongitude;

    public VehicleDTO() {}

    public VehicleDTO(Long id, String licensePlate, String manufacturer,
                      String model, Integer year, VehicleStatus status,
                      Double lastLatitude, Double lastLongitude) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.status = status;
        this.lastLatitude = lastLatitude;
        this.lastLongitude = lastLongitude;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    public VehicleStatus getStatus() { return status; }
    public void setStatus(VehicleStatus status) { this.status = status; }

    public Double getLastLatitude() { return lastLatitude; }
    public void setLastLatitude(Double lastLatitude) { this.lastLatitude = lastLatitude; }

    public Double getLastLongitude() { return lastLongitude; }
    public void setLastLongitude(Double lastLongitude) { this.lastLongitude = lastLongitude; }

    public List<MaintenanceRecordDTO> getMaintenanceRecords() { return maintenanceRecords; }
    public void setMaintenanceRecords(List<MaintenanceRecordDTO> maintenanceRecords) {this.maintenanceRecords = maintenanceRecords; }

    public LocalDateTime getNextMaintenance() { return nextMaintenance; }
    public void setNextMaintenance(LocalDateTime nextMaintenance) { this.nextMaintenance = nextMaintenance; }

    public LocalDateTime getLastMaintenance() { return lastMaintenance; }
    public void setLastMaintenance(LocalDateTime lastMaintenance) { this.lastMaintenance = lastMaintenance; }
}
