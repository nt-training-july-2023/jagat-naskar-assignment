package com.feedback.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {
  private User user;

  @BeforeEach
  public void setUp() {
    user = new User();
  }

  @Test
  public void testGettersAndSetters() {
    user.setUserId(1);
    user.setName("Jagat Naskar");
    user.setUserName("jme@nucleusteq.com");
    user.setPassword("password123");
    user.setUserType(ERole.admin);
    user.setfinalPassword(false);

    Department department = new Department();
    user.setDepartment(department);

    List<Ticket> ticketList = new ArrayList<>();
    Ticket ticket1 = new Ticket();
    Ticket ticket2 = new Ticket();
    ticketList.add(ticket1);
    ticketList.add(ticket2);
    user.setTicketList(ticketList);

    List<Comment> commentList = new ArrayList<>();
    Comment comment1 = new Comment();
    Comment comment2 = new Comment();
    commentList.add(comment1);
    commentList.add(comment2);
    user.setCommentList(commentList);

    assertEquals(1, user.getUserId());
    assertEquals("Jagat Naskar", user.getName());
    assertEquals("jme@nucleusteq.com", user.getUserName());
    assertEquals("password123", user.getPassword());
    assertEquals(ERole.admin, user.getUserType());
    assertEquals(false, user.getfinalPassword());
    assertEquals(department, user.getDepartment());
    assertEquals(ticketList, user.getTicketList());
    assertEquals(commentList, user.getCommentList());
  }

  @Test
  public void testConstructor() {
    int userId = 1;
    String name = "Jagat Naskar";
    String userName = "jme@nucleusteq.com";
    String password = "password123";
    ERole userType = ERole.admin;
    Boolean finalPassword = false;

    Department department = new Department();

    List<Ticket> ticketList = new ArrayList<>();
    Ticket ticket1 = new Ticket();
    Ticket ticket2 = new Ticket();
    ticketList.add(ticket1);
    ticketList.add(ticket2);

    List<Comment> commentList = new ArrayList<>();
    Comment comment1 = new Comment();
    Comment comment2 = new Comment();
    commentList.add(comment1);
    commentList.add(comment2);

    User newUser = new User(
      userId,
      name,
      userName,
      password,
      userType,
      finalPassword,
      ticketList,
      commentList,
      department
    );

    assertEquals(userId, newUser.getUserId());
    assertEquals(name, newUser.getName());
    assertEquals(userName, newUser.getUserName());
    assertEquals(password, newUser.getPassword());
    assertEquals(userType, newUser.getUserType());
    assertEquals(finalPassword, newUser.getfinalPassword());
    assertEquals(department, newUser.getDepartment());
    assertEquals(ticketList, newUser.getTicketList());
    assertEquals(commentList, newUser.getCommentList());
  }

  @Test
  public void testToString() {
    user.setUserId(1);
    user.setName("Jagat Naskar");
    user.setUserName("jme@nucleusteq.com");
    user.setPassword("password123");
    user.setUserType(ERole.admin);
    user.setfinalPassword(false);

    String expectedToString =
      "User [userId=1, name=Jagat Naskar, userName=jme@nucleusteq.com, password=password123, userType=admin, finalPassword=false, ticketList=[], commentList=[], department=null]";

    assertEquals(expectedToString, user.toString());
  }
}
