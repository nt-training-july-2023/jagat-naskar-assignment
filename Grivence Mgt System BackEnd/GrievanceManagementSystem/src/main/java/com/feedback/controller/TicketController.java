package com.feedback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.custom_exception.NullPointerFromFrontendException;
import com.feedback.entities.Ticket;
import com.feedback.payloads.ticket_dto.GetTicketsDTOin;
import com.feedback.payloads.ticket_dto.NewTicketDTO;
import com.feedback.payloads.ticket_dto.UpdateTicketDTOin;
import com.feedback.payloads.ticket_dto.getTicketDTOout;
import com.feedback.service.TicketService;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/tickets")
public class TicketController {
  @Autowired
  TicketService ticketService;
  @PostMapping("/addTicket")
  /**
   * adding tickets to databases.
   * @param ticket.
   * @return saved ticket string.
   */
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
  
  /**
   * getting tickets based on certain condition.
   * @param getTicketsDTOin
   * @return
   */
  @PostMapping("/getAllTicket")
  public ResponseEntity<?> getTickets(@RequestBody GetTicketsDTOin getTicketsDTOin) {
	  System.out.println("________________get ticket controller____________________");
    List<getTicketDTOout> allTicketList = ticketService.getTickets(getTicketsDTOin);
    return ResponseEntity.status(HttpStatus.OK).body(allTicketList);
  }

  /**
   * updating status and comment on the ticket.
   * @param updateTicketDTOin
   * @return
   */
  @PostMapping("/updateTicket")
  public ResponseEntity<?> updateTicket(@RequestBody UpdateTicketDTOin updateTicketDTOin) {
	  System.out.println("_____________________update tickrt controller___________________");
	  System.out.println("id = "+updateTicketDTOin.getTicketId());
	  System.out.println("message = "+updateTicketDTOin.getComment());
	  System.out.println("status = "+updateTicketDTOin.getTicketStatus());
	  Boolean updatedTicket = ticketService.updatingTicket(updateTicketDTOin);
	  if(updatedTicket == true) {
		  return ResponseEntity.status(HttpStatus.OK).body("Ticket Updated.");
	  }
	  return ResponseEntity.status(HttpStatus.OK).body("Could not update your ticket.");
  }
  
  
  //set it to work in the test cases
  public void setTicketService(TicketService ticketService) {
      this.ticketService = ticketService;
  }
  


  @GetMapping("/getIcketById/{ticketId}")
  public ResponseEntity<?> getTicketById(@PathVariable("ticketId") final Long ticketId )
  {
    getTicketDTOout ticketDTOout = ticketService.getByTicketById(ticketId);
    if(ticketDTOout != null) {
      return ResponseEntity.status(HttpStatus.OK).body(ticketDTOout);
    }
    return ResponseEntity.status(HttpStatus.OK).body("Tickets not found");
    
  }


}

