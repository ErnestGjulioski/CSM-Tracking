package com.fleet.vehicle_service_csm.realtime;

import com.fleet.vehicle_service_csm.VehicleEntity.model.Vehicle;
import com.fleet.vehicle_service_csm.VehicleEntity.repository.VehicleRepository;
import com.fleet.vehicle_service_csm.realtime.dto.PositionMessage;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class PositionService {

    private final SimpMessagingTemplate broker;
    private final VehicleRepository vehicleRepo;

    public PositionService(SimpMessagingTemplate broker, VehicleRepository vehicleRepo) {
        this.broker = broker;
        this.vehicleRepo = vehicleRepo;
    }

    @Transactional
    public void ingest(PositionMessage msg) {
        // Update last known coordinates (if vehicle exists)
        vehicleRepo.findById(msg.getVehicleId()).ifPresent(v -> {
            v.setLastLatitude(msg.getLat());
            v.setLastLongitude(msg.getLon());
            vehicleRepo.save(v);
        });

        // Broadcast to subscribers
        broker.convertAndSend("/topic/positions", msg);
    }

    public void ping(Long vehicleId) {
        broker.convertAndSend("/topic/positions",
                new PositionMessage(vehicleId, 0, 0, Instant.now().toEpochMilli()));
    }
}