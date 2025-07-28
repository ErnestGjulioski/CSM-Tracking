package com.fleet.vehicle_service_csm.controller;


import com.fleet.vehicle_service_csm.model.Vehicle;
import com.fleet.vehicle_service_csm.repository.VehicleRepository;
import com.fleet.vehicle_service_csm.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/vehicles")
@CrossOrigin
public class VehicleController {
    public final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @GetMapping
    public List<Vehicle> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Vehicle getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return service.create(vehicle);
    }

    @PutMapping("/{id}")
    public Vehicle update(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        return service.update(vehicle);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }



}
