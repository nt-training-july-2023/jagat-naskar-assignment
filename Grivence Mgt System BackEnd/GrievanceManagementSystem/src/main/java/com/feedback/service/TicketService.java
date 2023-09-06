package com.feedback.service;

import com.feedback.entities.Ticket;
import com.feedback.payloads.AllTicketDTO.NewTicketDTO;

public interface TicketService {

  /**
   * save ticket in the database.
   * @param ticket
   * @return
   */
  Ticket saveTicket(NewTicketDTO ticket);
}

