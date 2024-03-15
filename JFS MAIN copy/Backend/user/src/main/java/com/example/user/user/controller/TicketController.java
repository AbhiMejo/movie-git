package com.example.user.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.user.user.entity.TicketDetails;
import com.example.user.user.service.TicketService;

@RestController
@CrossOrigin(origins ="*")
public class TicketController {
	@Autowired
	private TicketService ticketService;
	

	@GetMapping("/getTicket")
	public ResponseEntity<List<TicketDetails>> getAllTicketDetails(){
		List<TicketDetails> tickets = ticketService.getAllTickets();
		return new ResponseEntity<>(tickets,HttpStatus.OK);
	}
	
	@PostMapping("/bookTicket")
	public ResponseEntity<TicketDetails> bookTicket(@RequestBody TicketDetails ticket){
		TicketDetails bookTicket = ticketService.bootTicket(ticket);
		return new ResponseEntity<>(bookTicket,HttpStatus.CREATED);
	}

}
