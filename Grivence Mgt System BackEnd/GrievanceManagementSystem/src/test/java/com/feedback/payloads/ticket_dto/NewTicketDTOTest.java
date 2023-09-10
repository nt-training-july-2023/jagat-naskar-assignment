package com.feedback.payloads.ticket_dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.feedback.entities.EStatus;
import com.feedback.entities.Ticket;

class NewTicketDTOTest {

	 @Test
  void testEquals() {
      NewTicketDTO ticket1 = new NewTicketDTO(1L, "Title", "Type", EStatus.Open, "Description", "email@example.com", "IT");
      NewTicketDTO ticket2 = new NewTicketDTO(1L, "Title", "Type", EStatus.Open, "Description", "email@example.com", "IT");
      NewTicketDTO ticket3 = new NewTicketDTO(2L, "Title", "Type", EStatus.Open, "Description", "email@example.com", "IT");

      assertEquals(ticket1, ticket2);
      assertNotEquals(ticket1, ticket3);
  }

  @Test
  void testHashCode() {
      NewTicketDTO ticket1 = new NewTicketDTO(1L, "Title", "Type", EStatus.Open, "Description", "email@example.com", "IT");
      NewTicketDTO ticket2 = new NewTicketDTO(1L, "Title", "Type", EStatus.Open, "Description", "email@example.com", "IT");

      assertEquals(ticket1.hashCode(), ticket2.hashCode());
  }

  @Test
  void testToString() {
      NewTicketDTO ticket = new NewTicketDTO(1L, "Title", "Type", EStatus.Open, "Description", "email@example.com", "IT");
      String expected = "NewTicketDTO [ticketId=1, ticketTitle=Title, ticketType=Type, ticketStatus=Open, " +
              "ticketDescription=Description, senderEmail=email@example.com, deptName=IT]";

      assertEquals(expected, ticket.toString());
  }
  
  @Test
  public void testGetTicketId() {
	  Ticket ticket = new Ticket();
      Long expected = 123L; // Set an expected value
      ticket.setTicketId(expected); // Set the ticketId
      Long actual = ticket.getTicketId(); // Get the ticketId

      assertEquals(expected, actual);
  }

  @Test
  public void testSetTicketId() {
	  Ticket ticket = new Ticket();
      Long expected = 456L; // Set an expected value
      ticket.setTicketId(expected); // Set the ticketId
      Long actual = ticket.getTicketId(); // Get the ticketId

      assertEquals(expected, actual);
  }
}
