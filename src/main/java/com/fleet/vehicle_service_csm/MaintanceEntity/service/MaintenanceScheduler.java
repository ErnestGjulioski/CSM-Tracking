package com.fleet.vehicle_service_csm.MaintanceEntity.service;

import com.fleet.vehicle_service_csm.MaintanceEntity.model.MaintenanceRecord;

import com.fleet.vehicle_service_csm.MaintanceEntity.repository.MaintenanceRecordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@EnableScheduling
public class MaintenanceScheduler {

    private static final Logger log = LoggerFactory.getLogger(MaintenanceScheduler.class);
    private final MaintenanceRecordRepository repo;

    public MaintenanceScheduler(MaintenanceRecordRepository repo) {
        this.repo = repo;
    }

    // Every 5 minutes
    @Scheduled(fixedDelay = 300000)
    public void checkDueMaintenance() {
        List<MaintenanceRecord> all = repo.findAll();
        LocalDate today = LocalDate.now();
        long dueCount = all.stream().filter(m ->
                (m.getDueAtDate()!=null && !m.getDueAtDate().isAfter(today))
                || (m.getDueAtKm()!=null && m.getDueAtKm() <= 10000) // placeholder threshold
        ).count();
        if (dueCount > 0) {
            log.warn("Maintenance due: {}", dueCount);
        } else {
            log.info("Maintenance check: none due.");
        }
    }
}