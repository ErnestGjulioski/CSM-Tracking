package com.fleet.vehicle_service_csm.geofence;

import org.springframework.stereotype.Service;

@Service
public class GeofenceService {

    private final GeofenceRepository repo;

    public GeofenceService(GeofenceRepository repo) {
        this.repo = repo;
    }

    public boolean isInside(Geofence g, double lat, double lon) {
        double d = haversineMeters(g.getCenterLat(), g.getCenterLon(), lat, lon);
        return d <= g.getRadiusMeters();
    }

    // Haversine distance in meters
    private static double haversineMeters(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371000.0;
        double dLat = Math.toRadians(lat2-lat1);
        double dLon = Math.toRadians(lon2-lon1);
        double a = Math.sin(dLat/2)*Math.sin(dLat/2) +
                   Math.cos(Math.toRadians(lat1))*Math.cos(Math.toRadians(lat2))*
                   Math.sin(dLon/2)*Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return R * c;
    }
}