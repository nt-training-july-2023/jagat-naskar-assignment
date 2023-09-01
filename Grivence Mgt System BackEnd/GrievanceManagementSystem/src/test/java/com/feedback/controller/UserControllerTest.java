package com.feedback.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import com.feedback.entities.User;
import com.feedback.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
  @InjectMocks
  private UserController userController;

  @Mock
  private UserService userService;

  @Test
  public void testGetByUserPassword_SuccessfulAuthentication() {
    // Arrange
    User user = new User();
    user.setUserName("admin@nucleusteq.com");
    user.setPassword("admin");
    user.setUserType("admin");
    when(userService.getByUserAndPassword(eq(user.getUserName()), eq(user.getPassword())))
      .thenReturn("true_" + user.getUserType());
    // Act
    ResponseEntity<?> response = userController.getByUserPassword(user);

    // Assert
    verify(userService)
      .getByUserAndPassword(eq(user.getUserName()), eq(user.getPassword()));
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("true_" + user.getUserType(), response.getBody());
  }

  @Test
  public void testGetByUserPassword_FailedAuthentication() {
    // Arrange
    User user = new User();
    user.setUserName("admin@nucleusteq.com");
    user.setPassword("admin");
    user.setUserType("admin");
    when(userService.getByUserAndPassword(eq(user.getUserName()), eq(user.getPassword())))
      .thenReturn("false"); // Simulate failed authentication

    // Act
    ResponseEntity<?> response = userController.getByUserPassword(user);

    // Assert
    verify(userService)
      .getByUserAndPassword(eq(user.getUserName()), eq(user.getPassword()));
    assertEquals(HttpStatus.OK, response.getStatusCode()); // You might want to change this to HttpStatus.UNAUTHORIZED for failed authentication
    assertEquals("false", response.getBody());
  }

  @Test
  public void testAddUser_UserExists() {
    User newUser = new User();
    newUser.setUserName("existingUser");

    when(userService.checkAlreadyExist(newUser)).thenReturn("User already exists");

    ResponseEntity<?> response = userController.addUser(newUser);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("User already exists", response.getBody());

//            verify(userService, times(1)).checkAlreadyExist(newUser);
    verify(userService, never()).saveUser(any(User.class));
  }

  @Test
  public void testAddUser_UserSavedSuccessfully() {
    User newUser = new User();
    newUser.setUserName("newUser");

    when(userService.checkAlreadyExist(newUser)).thenReturn("userNotExist");
    when(userService.saveUser(newUser)).thenReturn(newUser);

    ResponseEntity<?> response = userController.addUser(newUser);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("Saved Successfully!!!", response.getBody());

    verify(userService, times(1)).checkAlreadyExist(newUser);
    verify(userService, times(1)).saveUser(newUser);
  }

  @Test
  public void testAddUser_UserSaveFailure() {
    User newUser = new User();
    newUser.setUserName("newUser");
    when(userService.checkAlreadyExist(newUser)).thenReturn("userNotExist");
    when(userService.saveUser(newUser)).thenThrow(new RuntimeException("Database error"));

    ResponseEntity<?> response = userController.addUser(newUser);

    assertEquals(HttpStatus.OK, response.getStatusCode());
//            assertEquals("Could not saved into database!!! Database error", response.getBody());

    verify(userService, times(1)).checkAlreadyExist(newUser);
    verify(userService, times(1)).saveUser(newUser);
  }
}
