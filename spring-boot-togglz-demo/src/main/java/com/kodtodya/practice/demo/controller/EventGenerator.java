package com.kodtodya.practice.demo.controller;

import com.kodtodya.practice.demo.service.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventGenerator {

    @Autowired
    private HealthCheckService healthCheckService;

    @RequestMapping("generate-event")
    public String generateEvent() throws Exception {
        // validation
        healthCheckService.validateAndRun();

        //healthCheckService.enableFeature();
        return "event triggered";
    }
}
