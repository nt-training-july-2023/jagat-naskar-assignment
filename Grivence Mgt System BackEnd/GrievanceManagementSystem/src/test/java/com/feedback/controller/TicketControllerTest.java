package com.feedback.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.feedback.custom_exception.NullPointerFromFrontendException;
import com.feedback.entities.Ticket;
import com.feedback.payloads.ticket_dto.NewTicketDTO;
import com.feedback.service.TicketService;

class TicketControllerTest {

	  @Test
	  public void testAddTickets() {
	      // Create a mock of TicketService
	      TicketService ticketService = mock(TicketService.class);

	      // Create an instance of TicketController and inject the mock TicketService
	      TicketController ticketController = new TicketController();
	      ticketController.ticketService = ticketService;

	      // Create a sample NewTicketDTO
	      NewTicketDTO newTicketDTO = new NewTicketDTO();
	      newTicketDTO.setTicketDescription("Sample Description");

	      // Mock the behavior of ticketService.saveTicket()
	      when(ticketService.saveTicket(newTicketDTO)).thenReturn(new Ticket());

	      // Call the addTickets method
	      ResponseEntity<?> responseEntity = ticketController.addTickets(newTicketDTO);

	      // Verify that the response entity is not null and has a status of OK
	      assertNotNull(responseEntity);
	      assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

	      // Verify that the message is "Ticket saved Successfully!!!"
	      assertEquals("Ticket saved!!!", responseEntity.getBody());
	  }

	  @Test
	  public void testAddTicketsWithNullTicket() {
	      // Create an instance of TicketController
	      TicketController ticketController = new TicketController();

	      // Create a sample NewTicketDTO (null)
	      NewTicketDTO newTicketDTO = null;

	      // Use assertThrows to verify that a NullPointerFromFrontendException is thrown
	      assertThrows(NullPointerFromFrontendException.class, () -> {
	          ticketController.addTickets(newTicketDTO);
	      });
	  }

}
