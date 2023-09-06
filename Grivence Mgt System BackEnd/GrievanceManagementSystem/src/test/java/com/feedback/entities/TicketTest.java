package com.feedback.entities;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicketTest {
  private Ticket ticket;

  @BeforeEach
  public void setUp() {
    ticket = new Ticket();
  }

  @Test
  public void testConstructor() {
    String ticketId = "T123";
    String ticketTitle = "Sample Ticket";
    String ticketType = "Bug";
    EStatus ticketStatus = EStatus.Open;
    String ticketAssignedBy = "John Doe";
    String ticketCreationTime = "2023-09-01 10:00:00";
    String lastUpdatedTime = "2023-09-01 12:00:00";

    User user = new User();
    user.setUserId(1);
    user.setName("Alice");

    Department department = new Department();
    department.setDeptId(1);
    department.setDeptName("IT");

    ticket = new Ticket(
        ticketId,
        ticketTitle,
        ticketType,
        ticketStatus,
        ticketAssignedBy,
        ticketCreationTime,
        lastUpdatedTime,
        user,
        department
    );

        assertEquals(ticketId, ticket.getTicketId());
        assertEquals(ticketTitle, ticket.getTicketTitle());
        assertEquals(ticketType, ticket.getTicketType());
        assertEquals(ticketStatus, ticket.getTicketStatus());
        assertEquals(ticketAssignedBy, ticket.getTicketAssignedBy());
        assertEquals(ticketCreationTime, ticket.getTicketCreationTime());
        assertEquals(lastUpdatedTime, ticket.getLastUpdatedTime());
        assertEquals(user, ticket.getUser());
        assertEquals(department, ticket.getDepartment());
    }

    @Test
    public void testGettersAndSetters() {
        String ticketId = "T456";
        String ticketTitle = "Another Ticket";
        String ticketType = "Feature";
        EStatus ticketStatus = EStatus.Being_Addressed;
        String ticketAssignedBy = "Jane Smith";
        String ticketCreationTime = "2023-09-02 09:30:00";
        String lastUpdatedTime = "2023-09-02 11:45:00";

        User user = new User();
        user.setUserId(2);
        user.setName("Bob");

        Department department = new Department();
        department.setDeptId(2);
        department.setDeptName("HR");

        ticket.setTicketId(ticketId);
        ticket.setTicketTitle(ticketTitle);
        ticket.setTicketType(ticketType);
        ticket.setTicketStatus(ticketStatus);
        ticket.setTicketAssignedBy(ticketAssignedBy);
        ticket.setTicketCreationTime(ticketCreationTime);
        ticket.setLastUpdatedTime(lastUpdatedTime);
        ticket.setUser(user);
        ticket.setDepartment(department);

        assertEquals(ticketId, ticket.getTicketId());
        assertEquals(ticketTitle, ticket.getTicketTitle());
        assertEquals(ticketType, ticket.getTicketType());
        assertEquals(ticketStatus, ticket.getTicketStatus());
        assertEquals(ticketAssignedBy, ticket.getTicketAssignedBy());
        assertEquals(ticketCreationTime, ticket.getTicketCreationTime());
        assertEquals(lastUpdatedTime, ticket.getLastUpdatedTime());
        assertEquals(user, ticket.getUser());
        assertEquals(department, ticket.getDepartment());
    }

    @Test
    public void testToString() {
        String ticketId = "T789";
        String ticketTitle = "Yet Another Ticket";
        String ticketType = "Task";
        EStatus ticketStatus = EStatus.Resolved;
        String ticketAssignedBy = "David Johnson";
        String ticketCreationTime = "2023-09-03 14:15:00";
        String lastUpdatedTime = "2023-09-03 16:30:00";

        User user = new User();
        user.setUserId(3);
        user.setName("Charlie");

        Department department = new Department();
        department.setDeptId(3);
        department.setDeptName("Finance");

        ticket.setTicketId(ticketId);
        ticket.setTicketTitle(ticketTitle);
        ticket.setTicketType(ticketType);
        ticket.setTicketStatus(ticketStatus);
        ticket.setTicketAssignedBy(ticketAssignedBy);
        ticket.setTicketCreationTime(ticketCreationTime);
        ticket.setLastUpdatedTime(lastUpdatedTime);
        ticket.setUser(user);
        ticket.setDepartment(department);

        String expectedToString = "Ticket [ticketId=" + ticketId + ", ticketTitle=" + ticketTitle + ", ticketType=" + ticketType +
                ", ticketStatus=" + ticketStatus + ", ticketAssignedBy=" + ticketAssignedBy + ", ticketCreationTime=" + ticketCreationTime +
                ", lastUpdatedTime=" + lastUpdatedTime + ", user=" + user + ", department=" + department + "]";

        assertEquals(expectedToString, ticket.toString());
    }
}

