package com.feedback.controller;

import com.feedback.entities.User;
import com.feedback.payloads.user_dto.AddUserDto;
import com.feedback.payloads.user_dto.LoginDTO;
import com.feedback.service.UserService;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for managing user-related HTTP endpoints.
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/users")
public class UserController {
  /**
   *User Service.
   */
  @Autowired
  private UserService userService;

  @PostMapping("/addUser")
  public ResponseEntity<?> addUser(@Valid @RequestBody final AddUserDto user) {
    System.out.println("____________________________________");
    System.out.println("Controller, userDTo = "+user);
    String message = "";
    if((userService.checkAlreadyExist(user) == true)) {
      message = "UserName(email) already exist!!!";
      return ResponseEntity.status(HttpStatus.OK).body(message);
    }
    User savedUser = null;
    try {
    	System.out.println("con2");
      savedUser = userService.saveUser(user);
      System.out.println("con3 savedUser = "+savedUser);
      if(savedUser != null) {
          message = "Saved Successfully!!!";
      }

      
    } catch (Exception e) {
      message = "Could not saved into database!!! " + e.getMessage();
    }
    if (savedUser == null) {
    	return ResponseEntity.status(HttpStatus.OK).body(message);
    }
    return ResponseEntity.status(HttpStatus.OK).body("User saved!!!");
  }

  /**
   * Endpoint for user authentication.
   * @param user object containing username and password for authentication.
   * @return True if authentication is successful, false otherwise.
   */
  @PostMapping("/login")
  @ResponseBody
  public ResponseEntity<?> getByUserPassword(@RequestBody final LoginDTO user) {
    String dataAndRole = (String) userService.getByUserAndPassword(
      user.getEmail(),
      user.getPassword()
    );
    return ResponseEntity.status(HttpStatus.OK).body(dataAndRole);
  }
}
