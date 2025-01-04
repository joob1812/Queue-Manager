package com.queue.management.controllers;

import com.queue.management.models.Queue;
import com.queue.management.services.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin/queues")
    public List<Queue> getAllQueues() {
        return adminService.getAllQueues();
    }
}
