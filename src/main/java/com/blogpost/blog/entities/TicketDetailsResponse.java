package com.blogpost.blog.entities;

import java.util.List;
import java.util.Optional;

public class TicketDetailsResponse {

	  private List<Ticket> tickets; // List of tickets (for future extensibility)
	    private List<TicketTracking> trackingDetails;

	    // Getters and Setters
	    public List<Ticket> getTickets() {
	        return tickets;
	    }

	    public void setTickets(List<Ticket> tickets) {
	        this.tickets = tickets;
	    }

	    public List<TicketTracking> getTrackingDetails() {
	        return trackingDetails;
	    }

	    public void setTrackingDetails(List<TicketTracking> trackingDetails) {
	        this.trackingDetails = trackingDetails;
	    }

}
