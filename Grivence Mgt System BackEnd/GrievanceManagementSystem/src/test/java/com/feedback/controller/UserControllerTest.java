package com.feedback.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import com.feedback.entities.User;
import com.feedback.payloads.user_dto.AddUserDto;
import com.feedback.payloads.user_dto.LoginDTO;
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
      LoginDTO loginDTO = new LoginDTO();
      loginDTO.setEmail("admin@nucleusteq.com");
      loginDTO.setPassword("admin");

      when(userService.getByUserAndPassword(eq(loginDTO.getEmail()), eq(loginDTO.getPassword())))
              .thenReturn("true_admin"); // Assuming successful authentication for admin user

      // Act
      ResponseEntity<?> response = userController.getByUserPassword(loginDTO);

      // Assert
      verify(userService).getByUserAndPassword(eq(loginDTO.getEmail()), eq(loginDTO.getPassword()));
      assertEquals(HttpStatus.OK, response.getStatusCode());
      assertEquals("true_admin", response.getBody());
  }

  @Test
  public void testGetByUserPassword_FailedAuthentication() {
      // Arrange
      LoginDTO loginDTO = new LoginDTO();
      loginDTO.setEmail("admin@nucleusteq.com");
      loginDTO.setPassword("admin");

      when(userService.getByUserAndPassword(eq(loginDTO.getEmail()), eq(loginDTO.getPassword())))
              .thenReturn("false"); // Simulate failed authentication

      // Act
      ResponseEntity<?> response = userController.getByUserPassword(loginDTO);

      // Assert
      verify(userService).getByUserAndPassword(eq(loginDTO.getEmail()), eq(loginDTO.getPassword()));
      assertEquals(HttpStatus.OK, response.getStatusCode()); // You might want to change this to HttpStatus.UNAUTHORIZED for failed authentication
      assertEquals("false", response.getBody());
  }


  @Test
  public void testAddUser_UserSavedSuccessfully() {
      AddUserDto newUser = new AddUserDto();
      newUser.setUserName("newUser");

      when(userService.checkAlreadyExist(newUser)).thenReturn(false);
      when(userService.saveUser(newUser)).thenReturn(new User());

      ResponseEntity<?> response = userController.addUser(newUser);

      assertEquals(HttpStatus.OK, response.getStatusCode());
      assertEquals("User saved!!!", response.getBody());

      verify(userService, times(1)).checkAlreadyExist(newUser);
      verify(userService, times(1)).saveUser(newUser);
  }

  @Test
  public void testAddUser_UserSaveFailure() {
      AddUserDto newUser = new AddUserDto();
      newUser.setUserName("newUser");

      when(userService.checkAlreadyExist(newUser)).thenReturn(false);
      when(userService.saveUser(newUser)).thenThrow(new RuntimeException("Database error"));

      ResponseEntity<?> response = userController.addUser(newUser);

      assertEquals(HttpStatus.OK, response.getStatusCode());
      assertEquals("Could not saved into database!!! Database error", response.getBody());

      verify(userService, times(1)).checkAlreadyExist(newUser);
      verify(userService, times(1)).saveUser(newUser);
  }
}
