package com.fleet.vehicle_service_csm.model;

import jakarta.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue
    private long id;
    private String LicensePlate;
    private String status;

    //StandardKonstruktor
    public Vehicle() {}

    public Vehicle(String LicensePlate, String status) {
        this.LicensePlate = LicensePlate;
        this.status = status;
    }

    //getter/setter

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getLicensePlate() { return LicensePlate; }
    public void setLicensePlate(String LicensePlate) { this.LicensePlate = LicensePlate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
