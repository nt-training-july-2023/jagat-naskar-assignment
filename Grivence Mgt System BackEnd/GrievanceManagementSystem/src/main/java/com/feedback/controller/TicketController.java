package com.feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.custom_exception.NullPointerFromFrontendException;
import com.feedback.entities.Ticket;
import com.feedback.payloads.ticket_dto.NewTicketDTO;
import com.feedback.service.TicketService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/tickets")
public class TicketController {
  @Autowired
  TicketService ticketService;
  @PostMapping("/addTicket")
  public ResponseEntity<?> addTickets(@RequestBody final NewTicketDTO ticket) {
    System.out.println("Controller ticket = "+ticket);
    if(ticket == null) {
      throw new NullPointerFromFrontendException("Ticket data not received in the backend.");
    }
    String message = "";
    Ticket savedTicket = new Ticket();
    savedTicket = ticketService.saveTicket(ticket);
    if(savedTicket != null){
      message = "Ticket saved Successfully!!!";
    }
    if (savedTicket == null) {
      return ResponseEntity.status(HttpStatus.OK).body(message);
    }
    return ResponseEntity.status(HttpStatus.OK).body("Ticket saved!!!");
  }
}

