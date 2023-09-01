package com.feedback.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {
  private User user;

  @BeforeEach
  void setUp() {
    user = new User();
  }

  @Test
  void testEntities() {
    // Test getUserId
    user.setUserId(001);
    assertEquals(001, user.getUserId());

    // Test getName
    user.setName("jagat");
    assertEquals("jagat", user.getName());

    // Test getUserName
    user.setUserName("jagat");
    assertEquals("jagat", user.getUserName());

    // Test getPassword
    user.setPassword("password_admin");
    assertEquals("password_admin", user.getPassword());

    // Test getUserType
    user.setUserType("admin");
    assertEquals("admin", user.getUserType());

    // Test toString
 // Test toString
    user.setUserId(001);
    user.setName("jagat");
    user.setUserName("jme@nucleusteq.com");
    user.setPassword("admin123");
    user.setUserType("admin");

    String expectedToString = "User [" +
            "userId=1" +
            ", name=jagat" +
            ", userName=jme@nucleusteq.com" +
            ", password=admin123" +
            ", userType=admin" +
            ']';
    assertEquals(expectedToString, user.toString());
  }
}
