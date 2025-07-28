package com.fleet.vehicle_service_csm.repository;

import com.fleet.vehicle_service_csm.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
