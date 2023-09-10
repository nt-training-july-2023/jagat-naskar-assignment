package com.feedback.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicketTest {

	 @Test
  public void ticketCreationTest() {
      // Create a ticket
      Ticket ticket = new Ticket();
      assertNotNull(ticket);

      // Check if ticketId is null (since it's not set in the default constructor)
      assertNull(ticket.getTicketId());

      // Set ticketTitle and check if it's set correctly
      ticket.setTicketTitle("Sample Ticket Title");
      assertEquals("Sample Ticket Title", ticket.getTicketTitle());

      // Set ticketType and check if it's set correctly
      ticket.setTicketType("Bug");
      assertEquals("Bug", ticket.getTicketType());
  }

  @Test
  public void commentListTest() {
      // Create a ticket
      Ticket ticket = new Ticket();

      // Create some comments
      Comment comment1 = new Comment();
      Comment comment2 = new Comment();

      // Add comments to the ticket's commentList
      List<Comment> commentList = new ArrayList<>();
      commentList.add(comment1);
      commentList.add(comment2);
      ticket.setCommentList(commentList);

      // Check if commentList is set correctly
      assertEquals(2, ticket.getCommentList().size());
      assertTrue(ticket.getCommentList().contains(comment1));
      assertTrue(ticket.getCommentList().contains(comment2));
  }

  @Test
  public void ticketDefaultConstructorTest() {
      // Create a ticket using default constructor
      Ticket ticket = new Ticket();

      // Check if ticket is not null
      assertNotNull(ticket);

      // Check if ticketId is null (since it's not set in the default constructor)
      assertNull(ticket.getTicketId());

      // Check if ticketTitle is null
      assertNull(ticket.getTicketTitle());

      // Check if ticketType is null
      assertNull(ticket.getTicketType());

      // Check if ticketStatus is null
      assertNull(ticket.getTicketStatus());

      // Check if ticketAssignedBy is null
      assertNull(ticket.getTicketAssignedBy());

      // Check if ticketCreationTime is null
      assertNull(ticket.getTicketCreationTime());

      // Check if lastUpdatedTime is null
      assertNull(ticket.getLastUpdatedTime());

      // Check if ticketDescription is null
      assertNull(ticket.getTicketDescription());

      // Check if user is null
      assertNull(ticket.getUser());

      // Check if department is null
      assertNull(ticket.getDepartment());

      // Check if commentList is an empty list
      assertNotNull(ticket.getCommentList());
      assertTrue(ticket.getCommentList().isEmpty());
  }

  @Test
  public void ticketParameterizedConstructorTest() {
      // Create a ticket using parameterized constructor
      Long ticketId = 1L;
      String ticketTitle = "Sample Ticket Title";
      String ticketType = "Bug";
      EStatus ticketStatus = EStatus.Open;
      String ticketAssignedBy = "Admin";
      LocalDateTime ticketCreationTime = LocalDateTime.now();
      LocalDateTime lastUpdatedTime = LocalDateTime.now();
      String ticketDescription = "Sample Ticket Description";
      User user = new User();
      Department department = new Department();
      List<Comment> commentList = new ArrayList<>();

      Ticket ticket = new Ticket(ticketId, ticketTitle, ticketType, ticketStatus, ticketAssignedBy,
              ticketCreationTime, lastUpdatedTime, ticketDescription, user, department, commentList);

      // Check if ticket is not null
      assertNotNull(ticket);

      // Check if ticket properties are set correctly
      assertEquals(ticketId, ticket.getTicketId());
      assertEquals(ticketTitle, ticket.getTicketTitle());
      assertEquals(ticketType, ticket.getTicketType());
      assertEquals(ticketStatus, ticket.getTicketStatus());
      assertEquals(ticketAssignedBy, ticket.getTicketAssignedBy());
      assertEquals(ticketCreationTime, ticket.getTicketCreationTime());
      assertEquals(lastUpdatedTime, ticket.getLastUpdatedTime());
      assertEquals(ticketDescription, ticket.getTicketDescription());
      assertEquals(user, ticket.getUser());
      assertEquals(department, ticket.getDepartment());
      assertEquals(commentList, ticket.getCommentList());
  }

  @Test
  public void gettersAndSettersTest() {
      // Create a ticket
      Ticket ticket = new Ticket();

      // Set properties using setters
      Long ticketId = 1L;
      ticket.setTicketId(ticketId);

      String ticketTitle = "Sample Ticket Title";
      ticket.setTicketTitle(ticketTitle);

      String ticketType = "Bug";
      ticket.setTicketType(ticketType);

      EStatus ticketStatus = EStatus.Open;
      ticket.setTicketStatus(ticketStatus);

      String ticketAssignedBy = "Admin";
      ticket.setTicketAssignedBy(ticketAssignedBy);

      LocalDateTime ticketCreationTime = LocalDateTime.now();
      ticket.setTicketCreationTime(ticketCreationTime);

      LocalDateTime lastUpdatedTime = LocalDateTime.now();
      ticket.setLastUpdatedTime(lastUpdatedTime);

      String ticketDescription = "Sample Ticket Description";
      ticket.setTicketDescription(ticketDescription);

      User user = new User();
      ticket.setUser(user);

      Department department = new Department();
      ticket.setDepartment(department);

      List<Comment> commentList = new ArrayList<>();
      Comment comment1 = new Comment();
      Comment comment2 = new Comment();
      commentList.add(comment1);
      commentList.add(comment2);
      ticket.setCommentList(commentList);

      // Check if getters return the expected values
      assertEquals(ticketId, ticket.getTicketId());
      assertEquals(ticketTitle, ticket.getTicketTitle());
      assertEquals(ticketType, ticket.getTicketType());
      assertEquals(ticketStatus, ticket.getTicketStatus());
      assertEquals(ticketAssignedBy, ticket.getTicketAssignedBy());
      assertEquals(ticketCreationTime, ticket.getTicketCreationTime());
      assertEquals(lastUpdatedTime, ticket.getLastUpdatedTime());
      assertEquals(ticketDescription, ticket.getTicketDescription());
      assertEquals(user, ticket.getUser());
      assertEquals(department, ticket.getDepartment());
      assertEquals(commentList, ticket.getCommentList());
  }

  @Test
    public void testUserAssociation() {
    User user = new User();
    user.setUserId(1);
    Ticket ticket = new Ticket();
    ticket.setUser(user);
    assertEquals(user, ticket.getUser());
  }

  @Test
  public void testDepartmentAssociation() {
    Department department = new Department();
    department.setDeptId(1);
    department.setDeptName("Sales");
    Ticket ticket = new Ticket();
    ticket.setDepartment(department);
    assertEquals(department, ticket.getDepartment());
  }

  @Test
  public void testCommentListAssociation() {
    Comment comment1 = new Comment();
    comment1.setCommentId(1);
    Comment comment2 = new Comment();
    comment2.setCommentId(2);
    List<Comment> commentList = new ArrayList<>();
    commentList.add(comment1);
    commentList.add(comment2);
    Ticket ticket = new Ticket();
    ticket.setCommentList(commentList);
    assertEquals(commentList, ticket.getCommentList());
  }











//  @Test
//  public void testGettersAndSetters() {
//    Ticket ticket = new Ticket();
//    ticket.setTicketId(1L);
//    ticket.setTicketTitle("Title of the ticket");
//    ticket.setTicketType("Feedback");
//    ticket.setTicketStatus(EStatus.Open);
//    ticket.setTicketAssignedBy("Jagat Naskar");
//    LocalDateTime creationTime = LocalDateTime.of(2023, 9, 7, 12, 0);
//    ticket.setTicketCreationTime(creationTime);
//    LocalDateTime lastUpdatedTime = LocalDateTime.of(2023, 9, 7, 14, 30);
//    ticket.setLastUpdatedTime(lastUpdatedTime);
//    ticket.setTicketDescription("Description of the ticket");
//
////    assertEquals((1L), ticket.getTicketId());  -->not worknig
//    assertEquals("Title of the ticket", ticket.getTicketTitle());
//    assertEquals("Feedback", ticket.getTicketType());
//    assertEquals(EStatus.Open, ticket.getTicketStatus());
//    assertEquals("Jagat Naskar", ticket.getTicketAssignedBy());
//    assertEquals(creationTime, ticket.getTicketCreationTime());
//    assertEquals(lastUpdatedTime, ticket.getLastUpdatedTime());
//    assertEquals("Description of the ticket", ticket.getTicketDescription());
//  }
//

}

