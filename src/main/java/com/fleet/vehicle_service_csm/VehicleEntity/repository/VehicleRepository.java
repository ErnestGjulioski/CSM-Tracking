package com.fleet.vehicle_service_csm.VehicleEntity.repository;

import com.fleet.vehicle_service_csm.VehicleEntity.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
