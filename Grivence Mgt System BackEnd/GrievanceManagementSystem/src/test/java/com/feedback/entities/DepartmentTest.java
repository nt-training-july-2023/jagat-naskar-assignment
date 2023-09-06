package com.feedback.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DepartmentTest {
  private Department department;

  @BeforeEach
  public void setUp() {
    department = new Department();
  }

  @Test
  public void testGettersAndSetters() {
    // Set values using setters
    department.setDeptId(1);
    department.setDeptName("HR");

    List<User> userList = new ArrayList<>();
    User user1 = new User();
    User user2 = new User();
    userList.add(user1);
    userList.add(user2);
    department.setUser(userList);

    List<Ticket> ticketList = new ArrayList<>();
    Ticket ticket1 = new Ticket();
    Ticket ticket2 = new Ticket();
    ticketList.add(ticket1);
    ticketList.add(ticket2);
    department.setTicketList(ticketList);

    // Use getters to retrieve values
    assertEquals(1, department.getDeptId());
    assertEquals("HR", department.getDeptName());
    assertEquals(userList, department.getUser());
    assertEquals(ticketList, department.getTicketList());
  }

  @Test
  public void testConstructor() {
    List<User> userList = new ArrayList<>();
    List<Ticket> ticketList = new ArrayList<>();

    Department newDepartment = new Department(2, "IT", userList, ticketList);

    assertEquals(2, newDepartment.getDeptId());
    assertEquals("IT", newDepartment.getDeptName());
    assertEquals(userList, newDepartment.getUser());
    assertEquals(ticketList, newDepartment.getTicketList());
  }

  @Test
  public void testToString() {
    department.setDeptId(3);
    department.setDeptName("Finance");

    String expectedToString =
      "Department [deptId=3, deptName=Finance, user=[], ticketList=[]]";

    assertEquals(expectedToString, department.toString());
  }
}
