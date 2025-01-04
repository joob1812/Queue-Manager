package com.queue.management.models;

public class Ticket {
    private int ticketNumber;
    private int positionInQueue;
    private int peopleAhead;
    private int currentServingNumber;

    public Ticket(int ticketNumber, int positionInQueue) {
        this.ticketNumber = ticketNumber;
        this.positionInQueue = positionInQueue;
        this.peopleAhead = positionInQueue - 1;
        this.currentServingNumber = -1;  // Not being served at first
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getPositionInQueue() {
        return positionInQueue;
    }

    public void setPositionInQueue(int positionInQueue) {
        this.positionInQueue = positionInQueue;
    }

    public int getPeopleAhead() {
        return peopleAhead;
    }

    public void setPeopleAhead(int peopleAhead) {
        this.peopleAhead = peopleAhead;
    }

    public int getCurrentServingNumber() {
        return currentServingNumber;
    }

    public void setCurrentServingNumber(int currentServingNumber) {
        this.currentServingNumber = currentServingNumber;
    }
}
