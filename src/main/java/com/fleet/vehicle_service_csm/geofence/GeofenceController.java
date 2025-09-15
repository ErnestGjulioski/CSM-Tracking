package com.fleet.vehicle_service_csm.geofence;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/geofences")
@CrossOrigin
public class GeofenceController {

    private final GeofenceRepository repo;

    public GeofenceController(GeofenceRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Geofence> list() { return repo.findAll(); }

    @PostMapping
    public Geofence create(@RequestBody Geofence g) { return repo.save(g); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}