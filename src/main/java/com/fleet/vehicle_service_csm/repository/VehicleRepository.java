package com.fleet.vehicle_service_csm.repository;

import com.fleet.vehicle_service_csm.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
