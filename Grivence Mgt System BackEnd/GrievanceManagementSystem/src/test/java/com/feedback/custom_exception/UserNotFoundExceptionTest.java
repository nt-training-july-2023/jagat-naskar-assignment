package com.feedback.custom_exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserNotFoundExceptionTest {

  @Test
  void testConstructorWithUserName() {
    String userName = "john_doe";
    UserNotFoundException exception = new UserNotFoundException(userName);
    assertEquals("User not found with name: " + userName, exception.getMessage());
  }

  @Test
  void testConstructorWithUserId() {
    int userId = 123;
    UserNotFoundException exception = new UserNotFoundException(userId);
    assertEquals("User not found with name: " + userId, exception.getMessage());
  }

}
