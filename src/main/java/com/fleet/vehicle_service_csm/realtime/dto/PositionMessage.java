package com.fleet.vehicle_service_csm.realtime.dto;

public class PositionMessage {
    private Long vehicleId;
    private double lat;
    private double lon;
    private long timestamp;

    public PositionMessage() {}

    public PositionMessage(Long vehicleId, double lat, double lon, long timestamp) {
        this.vehicleId = vehicleId;
        this.lat = lat;
        this.lon = lon;
        this.timestamp = timestamp;
    }

    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }
    public double getLat() { return lat; }
    public void setLat(double lat) { this.lat = lat; }
    public double getLon() { return lon; }
    public void setLon(double lon) { this.lon = lon; }
    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
}