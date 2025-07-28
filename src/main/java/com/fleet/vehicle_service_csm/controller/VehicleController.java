package com.fleet.vehicle_service_csm.controller;


import com.fleet.vehicle_service_csm.model.Vehicle;
import com.fleet.vehicle_service_csm.repository.VehicleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/vehicles")
@CrossOrigin
public class VehicleController {
    public final VehiclesService service;

}
