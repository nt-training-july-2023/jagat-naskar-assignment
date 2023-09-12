package com.feedback.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Base64;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feedback.entities.User;
import com.feedback.payloads.user_dto.AddUserDto;
import com.feedback.payloads.user_dto.LoginDTO;
import com.feedback.payloads.user_dto.PasswordChangeDTOin;
import com.feedback.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Base64Utils;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
  @InjectMocks
  private UserController userController;

  @Mock
  private UserService userService;

    @Autowired
    private MockMvc mockMvc;

  @BeforeEach
  public void setUp() {
      MockitoAnnotations.openMocks(this);
      mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
  }


  @Test
  public void testGetByUserPassword_SuccessfulAuthentication() throws Exception {
      // Arrange
      LoginDTO loginDTO = new LoginDTO();
      loginDTO.setEmail(Base64.getEncoder().encodeToString("admin@nucleusteq.com".getBytes()));
      loginDTO.setPassword(Base64.getEncoder().encodeToString("admin".getBytes()));

      String expectedResult = "true_admin";
      when(userService.getByUserAndPassword(anyString(), anyString())).thenReturn(expectedResult);

      Object mockMvc;
	// Act & Assert
      mockMvc.perform(post("/login")
              .contentType(MediaType.APPLICATION_JSON)
              .content(new ObjectMapper().writeValueAsString(loginDTO)))
              .andExpect(status().isOk())
              .andExpect(content().string(expectedResult));
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
  
  @Test
  public void testChangePassword_PasswordChangedSuccessfully() {
      PasswordChangeDTOin request = new PasswordChangeDTOin();
      request.setOldPassword("oldPassword");
      request.setNewPassword("newPassword");

      when(userService.passwordChangedSuccess(request)).thenReturn("Password changed successfully.");

      ResponseEntity<String> response = userController.changePassword(request);

      assertEquals(HttpStatus.OK, response.getStatusCode());
      assertEquals("Password changed successfully.", response.getBody());

      verify(userService, times(1)).passwordChangedSuccess(request);
  }
  
  @Test
  public void testChangePassword_FailedScenario() {
      PasswordChangeDTOin request = new PasswordChangeDTOin();
      request.setOldPassword("wrongOldPassword");
      request.setNewPassword("newPassword");

      when(userService.passwordChangedSuccess(request)).thenReturn(null); // Simulating a failure

      ResponseEntity<String> response = userController.changePassword(request);

      assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
      assertNull(response.getBody());

      verify(userService, times(1)).passwordChangedSuccess(request);
  }
}
