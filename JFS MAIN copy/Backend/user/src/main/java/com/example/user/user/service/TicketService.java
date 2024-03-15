package com.example.user.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.user.entity.TicketDetails;
import com.example.user.user.repository.TicketRepository;



@Service
public class TicketService {
	@Autowired
	private TicketRepository ticketRepository;
	
	public List<TicketDetails> getAllTickets(){
		return (List<TicketDetails>) ticketRepository.findAll();
	}
	
	public TicketDetails bootTicket(TicketDetails ticketDetails) {
		return ticketRepository.save(ticketDetails);
	}

}
