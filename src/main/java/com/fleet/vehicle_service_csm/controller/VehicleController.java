package com.fleet.vehicle_service_csm.controller;


import com.fleet.vehicle_service_csm.dto.VehicleDTO;
import com.fleet.vehicle_service_csm.model.Vehicle;
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
    public Vehicle create(@RequestBody VehicleDTO dto) {
        return service.createFromDto(dto);
    }

    @PutMapping("/{id}")
    public Vehicle update(@PathVariable Long id, @RequestBody VehicleDTO dto) {
        return service.updateFromDto(id,dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }





}
