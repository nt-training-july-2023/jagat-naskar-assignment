package com.feedback.entities;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicketTest {
	 @Test
  public void testGettersAndSetters() {
    Ticket ticket = new Ticket();
    ticket.setTicketId(1L);
    ticket.setTicketTitle("Title of the ticket");
    ticket.setTicketType("Bug");
    ticket.setTicketStatus(EStatus.Open);
    ticket.setTicketAssignedBy("Jagat Naskar");
    LocalDateTime creationTime = LocalDateTime.of(2023, 9, 7, 12, 0);
    ticket.setTicketCreationTime(creationTime);
    LocalDateTime lastUpdatedTime = LocalDateTime.of(2023, 9, 7, 14, 30);
    ticket.setLastUpdatedTime(lastUpdatedTime);
    ticket.setTicketDescription("Description of the ticket");

//    assertEquals((1L), ticket.getTicketId());
    assertEquals("Title of the ticket", ticket.getTicketTitle());
    assertEquals("Bug", ticket.getTicketType());
    assertEquals(EStatus.Open, ticket.getTicketStatus());
    assertEquals("Jagat Naskar", ticket.getTicketAssignedBy());
    assertEquals(creationTime, ticket.getTicketCreationTime());
    assertEquals(lastUpdatedTime, ticket.getLastUpdatedTime());
    assertEquals("Description of the ticket", ticket.getTicketDescription());
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
    department.setDeptName("IT");

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
}

