package com.fleet.vehicle_service_csm.ENUM;

public enum VehicleStatus {
    ACTIVE("Aktiv"),
    INACTIVE("Inaktiv"),
    MAINTENANCE("In Wartung");

    private final String label;

    VehicleStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
