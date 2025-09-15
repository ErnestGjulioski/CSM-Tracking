package com.fleet.vehicle_service_csm.VehicleEntity.controller;

import com.fleet.vehicle_service_csm.VehicleEntity.ENUM.VehicleStatus;
import com.fleet.vehicle_service_csm.VehicleEntity.dto.VehicleDTO;
import com.fleet.vehicle_service_csm.VehicleEntity.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @GetMapping
    public List<VehicleDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.findById(id));
        } catch (jakarta.persistence.EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<VehicleDTO> create(@Valid @RequestBody VehicleDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleDTO> update(@PathVariable Long id, @Valid @RequestBody VehicleDTO dto) {
        try {
            return ResponseEntity.ok(service.update(id, dto));
        } catch (jakarta.persistence.EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (jakarta.persistence.EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/filter")
    public List<VehicleDTO> searchVehicle(
            @RequestParam(required = false) String licensePlate,
            @RequestParam(required = false) String manufacturer,
            @RequestParam(required = false) VehicleStatus status,
            @RequestParam(required = false) Integer year
            ){
        return service.filter(licensePlate, manufacturer, status, year);
    }

}

