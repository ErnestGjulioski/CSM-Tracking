package com.fleet.vehicle_service_csm.MaintanceEntity.controller;

import com.fleet.vehicle_service_csm.MaintanceEntity.dto.MaintenanceRecordDTO;
import com.fleet.vehicle_service_csm.MaintanceEntity.service.MaintenanceRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/maintenances")
public class MaintenanceRecordController {

    private final MaintenanceRecordService service;

    public MaintenanceRecordController(MaintenanceRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MaintenanceRecordDTO> create(@RequestBody MaintenanceRecordDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<MaintenanceRecordDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaintenanceRecordDTO> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaintenanceRecordDTO> update(@PathVariable Long id, @RequestBody MaintenanceRecordDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/filter/vehicle/{vehicleId}")
    public ResponseEntity<List<MaintenanceRecordDTO>> filterByVehicle(@PathVariable Long vehicleId) {
        return ResponseEntity.ok(service.filterByVehicle(vehicleId));
    }

    @GetMapping("/filter/date")
    public ResponseEntity<List<MaintenanceRecordDTO>> filterByDateRange(
            @RequestParam("start") LocalDate start,
            @RequestParam("end") LocalDate end) {
        return ResponseEntity.ok(service.filterByDateRange(start, end));
    }
}
