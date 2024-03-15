package com.example.user.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TicketDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long TicketId;
private Long movieId;
private String customerName;
private int noOfTickets;

public TicketDetails() {

	
}

public TicketDetails(Long ticketId, Long movieId, String customerName, int noOfTickets) {
	super();
	TicketId = ticketId;
	this.movieId = movieId;
	this.customerName = customerName;
	this.noOfTickets = noOfTickets;
}

public Long getTicketId() {
	return TicketId;
}

public void setTicketId(Long ticketId) {
	TicketId = ticketId;
}

public Long getMovieId() {
	return movieId;
}

public void setMovieId(Long movieId) {
	this.movieId = movieId;
}

public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

public int getNoOfTickets() {
	return noOfTickets;
}

public void setNoOfTickets(int noOfTickets) {
	this.noOfTickets = noOfTickets;
}


}
