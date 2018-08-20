package com.example.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HealthCheckController {
    private LocalDateTime unhealthyTill = LocalDateTime.MIN;
    private LocalDateTime unreadyTill = LocalDateTime.MIN;;


    @RequestMapping("healthcheck/healthy")
    public ResponseEntity<?> healthy() {
        if(LocalDateTime.now().isBefore(unhealthyTill)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok().build();
    }

    @RequestMapping("healthcheck/ready")
    public ResponseEntity<?> ready() {
        if(LocalDateTime.now().isBefore(unreadyTill)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "healthcheck/unhealthy-for-a-minute")
    public void unhealthyForMinute() {
        unhealthyTill = LocalDateTime.now().plusMinutes(1);
    }

    @RequestMapping(value = "healthcheck/unready-for-a-minute")
    public void unreadyForMinute() {
        unreadyTill = LocalDateTime.now().plusMinutes(1);
    }
}