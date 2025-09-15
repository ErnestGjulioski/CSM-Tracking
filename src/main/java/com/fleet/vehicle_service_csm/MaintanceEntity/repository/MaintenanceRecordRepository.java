package com.fleet.vehicle_service_csm.MaintanceEntity.repository;

import com.fleet.vehicle_service_csm.MaintanceEntity.model.MaintenanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
public interface MaintenanceRecordRepository extends JpaRepository<MaintenanceRecord, Long> {

        // alle Records für ein bestimmtes Vehicle
        List<MaintenanceRecord> findByVehicle_Id(Long vehicleId);

        // Records nach Fälligkeitsdatum filtern
        List<MaintenanceRecord> findByDueAtDateBetween(LocalDate startDate, LocalDate endDate);

        // optional: nach Status suchen (z. B. OPEN, DONE, OVERDUE)
        List<MaintenanceRecord> findByStatus(String status);
    }

