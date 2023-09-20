package com.feedback.service;

import java.util.List;

import com.feedback.entities.Ticket;
import com.feedback.payloads.ticket_dto.GetTicketsDTOin;
import com.feedback.payloads.ticket_dto.NewTicketDTO;
import com.feedback.payloads.ticket_dto.UpdateTicketDTOin;
import com.feedback.payloads.ticket_dto.getTicketDTOout;


public interface TicketService {

  /**
   * save ticket in the database.
   * @param ticket
   * @return
   */
  Ticket saveTicket(NewTicketDTO ticket);
  
  List<getTicketDTOout> getTickets(GetTicketsDTOin getTicketsDTOin);

  Boolean updatingTicket(UpdateTicketDTOin updateTicketDTOin);
  
  getTicketDTOout getByTicketById(Long ticketId);
}

