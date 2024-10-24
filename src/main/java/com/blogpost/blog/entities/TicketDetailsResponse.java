package com.blogpost.blog.entities;

import java.util.List;
import java.util.Optional;

public class TicketDetailsResponse {

	  private Optional<List<Ticket>> tickets; // List of tickets (for future extensibility)
	    private Optional<List<TicketTracking>> trackingDetails;
		public Optional<List<Ticket>> getTickets() {
			return tickets;
		}
		public void setTickets(Optional<List<Ticket>> tickets) {
			this.tickets = tickets;
		}
		public Optional<List<TicketTracking>> getTrackingDetails() {
			return trackingDetails;
		}
		public void setTrackingDetails(Optional<List<TicketTracking>> trackingDetails) {
			this.trackingDetails = trackingDetails;
		}

	    // Getters and Setters
	   
}
