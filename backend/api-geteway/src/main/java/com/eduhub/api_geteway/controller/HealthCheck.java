package com.eduhub.api_geteway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health/")
public class HealthCheck {

    @GetMapping("healthCheck")
    public String healthCheck() { return "api-gateway service is running"; }
}
