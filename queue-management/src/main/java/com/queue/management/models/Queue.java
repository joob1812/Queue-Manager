package com.queue.management.models;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    private String serviceName;
    private String location;
    private List<Ticket> tickets;
    private List<Ticket> servedTickets;
    private int currentTicketNumber;

    public Queue(String serviceName, String location) {
        this.serviceName = serviceName;
        this.location = location;
        this.tickets = new ArrayList<>();
        this.servedTickets = new ArrayList<>();
        this.currentTicketNumber = 1;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public int getCurrentTicketNumber() {
        return currentTicketNumber;
    }

    public void incrementTicketNumber() {
        this.currentTicketNumber++;
    }

    public List<Ticket> getServedTickets() {
        return servedTickets;
    }

    public void setServedTickets(List<Ticket> servedTickets) {
        this.servedTickets = servedTickets;
    }
}
