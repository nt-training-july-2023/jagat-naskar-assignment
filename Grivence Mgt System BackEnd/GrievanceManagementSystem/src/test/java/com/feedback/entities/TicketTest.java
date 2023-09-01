package com.feedback.entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TicketTest {

  @Test
  void testTicket() {
    Ticket ticket = new Ticket();
    assertNotNull(ticket);
  }

  @Test
  void testTicketStringStringStringEStatusStringStringString() {
    Ticket ticket = new Ticket("1", "Title", "Type", EStatus.Open, "Jagat", "10am on 13th Aug, 23", "12am on 14th Aug, 23");
    assertEquals("1", ticket.getTicketId());
    assertEquals("Title", ticket.getTicketTitle());
    assertEquals("Type", ticket.getTicketType());
    assertEquals(EStatus.Open, ticket.getTicketStatus());
    assertEquals("Jagat", ticket.getTicketAssignedBy());
    assertEquals("10am on 13th Aug, 23", ticket.getTicketCreationTime());
    assertEquals("12am on 14th Aug, 23", ticket.getLastUpdatedTime());
  }

  @Test
  void testGetTicketId() {
    Ticket ticket = new Ticket();
    ticket.setTicketId("10023");
    assertEquals("10023", ticket.getTicketId());
  }

  @Test
  void testSetTicketId() {
    Ticket ticket = new Ticket();
    ticket.setTicketId("45600");
    assertEquals("45600", ticket.getTicketId());
  }

  @Test
  void testGetTicketTitle() {
    Ticket ticket = new Ticket();
    ticket.setTicketTitle("Ticket to Moon");
    assertEquals("Ticket to Moon", ticket.getTicketTitle());
  }

  @Test
  void testSetTicketTitle() {
    Ticket ticket = new Ticket();
    ticket.setTicketTitle("Ticket for Moon");
    assertEquals("Ticket for Moon", ticket.getTicketTitle());
  }

  @Test
  void testGetTicketType() {
    Ticket ticket = new Ticket();
    ticket.setTicketType("Type A");
    assertEquals("Type A", ticket.getTicketType());
  }

  @Test
  void testSetTicketType() {
    Ticket ticket = new Ticket();
    ticket.setTicketType("Type B");
    assertEquals("Type B", ticket.getTicketType());
  }

  @Test
  void testGetTicketStatus() {
    Ticket ticket = new Ticket();
    ticket.setTicketStatus(EStatus.Resolved);
    assertEquals(EStatus.Resolved, ticket.getTicketStatus());
  }

  @Test
  void testSetTicketStatus() {
    Ticket ticket = new Ticket();
    ticket.setTicketStatus(EStatus.Being_Addressed);
    assertEquals(EStatus.Being_Addressed, ticket.getTicketStatus());
  }

  @Test
  void testGetTicketAssignedBy() {
    Ticket ticket = new Ticket();
    ticket.setTicketAssignedBy("admin");
    assertEquals("admin", ticket.getTicketAssignedBy());
  }

  @Test
  void testSetTicketAssignedBy() {
    Ticket ticket = new Ticket();
    ticket.setTicketAssignedBy("member");
    assertEquals("member", ticket.getTicketAssignedBy());
  }

  @Test
  void testGetTicketCreationTime() {
    Ticket ticket = new Ticket();
    ticket.setTicketCreationTime("2023-08-30 23:12");
    assertEquals("2023-08-30 23:12", ticket.getTicketCreationTime());
  }

  @Test
  void testSetTicketCreationTime() {
    Ticket ticket = new Ticket();
    ticket.setTicketCreationTime("2023-09-01");
    assertEquals("2023-09-01", ticket.getTicketCreationTime());
  }

  @Test
  void testGetLastUpdatedTime() {
    Ticket ticket = new Ticket();
    ticket.setLastUpdatedTime("2023-08-31 21:00");
    assertEquals("2023-08-31 21:00", ticket.getLastUpdatedTime());
  }

  @Test
  void testSetLastUpdatedTime() {
    Ticket ticket = new Ticket();
    ticket.setLastUpdatedTime("2023-09-02 23:45");
    assertEquals("2023-09-02 23:45", ticket.getLastUpdatedTime());
  }
}

