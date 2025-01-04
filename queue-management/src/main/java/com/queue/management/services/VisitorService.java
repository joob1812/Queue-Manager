package com.queue.management.services;

import com.queue.management.models.Queue;
import com.queue.management.models.Ticket;
import org.springframework.stereotype.Service;

@Service
public class VisitorService {

    private final AdminService adminService;

    public VisitorService(AdminService adminService) {
        this.adminService = adminService;
    }

    public String generateTicket(String serviceName, String location) {
        Queue queue = adminService.getQueueByServiceAndLocation(serviceName, location);
        if (queue != null) {
            Ticket ticket = new Ticket(queue.getCurrentTicketNumber(), queue.getTickets().size() + 1);
            queue.addTicket(ticket);
            queue.incrementTicketNumber();
            return "Votre numéro de ticket est: " + ticket.getTicketNumber() +
                    ", vous êtes à la " + ticket.getPositionInQueue() + "ème position.";
        }
        return "Service ou localisation introuvables.";
    }
}
