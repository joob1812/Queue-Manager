package com.queue.management.controllers;

import com.queue.management.services.VisitorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitorController {
    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @GetMapping("/visitor/ticket")
    public String getTicket(@RequestParam String serviceName, @RequestParam String location) {
        return visitorService.generateTicket(serviceName, location);
    }
}
