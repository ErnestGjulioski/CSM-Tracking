package com.fleet.vehicle_service_csm.realtime;

import com.fleet.vehicle_service_csm.realtime.dto.PositionMessage;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/telemetry")
@CrossOrigin
public class TelemetryController {

    private final PositionService service;

    public TelemetryController(PositionService service) {
        this.service = service;
    }

    // HTTP ingestion
    @PostMapping("/position")
    public ResponseEntity<Void> postPosition(@Valid @RequestBody PositionMessage msg) {
        service.ingest(msg);
        return ResponseEntity.accepted().build();
    }

    // STOMP app destination (optional)
    @MessageMapping("/position")
    public void viaStomp(PositionMessage msg) {
        service.ingest(msg);
    }
}