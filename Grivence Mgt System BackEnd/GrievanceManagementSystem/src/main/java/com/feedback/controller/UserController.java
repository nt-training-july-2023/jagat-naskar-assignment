package com.feedback.controller;

import com.feedback.entities.User;
import com.feedback.payloads.user_dto.AddUserDto;
import com.feedback.payloads.user_dto.LoginDTO;
import com.feedback.service.UserService;

import java.util.Base64;

import javax.servlet.http.HttpServletResponse;
import javax.swing.Box.Filler;
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
    if(user.getDepartmentName().equals(null) || user.getName().equals(null) ||
        user.getPassword().equals(null) || user.getUserName().equals(null) ||
        user.getUserType().equals(null)) {
      message = "All the data are not filled.";
      return ResponseEntity.status(HttpStatus.OK).body(message);
    }
    if((userService.checkAlreadyExist(user) == true)) {
      message = "UserName(email) already exist!!!";
      return ResponseEntity.status(HttpStatus.OK).body(message);
    }
    User savedUser = null;
    try {
      savedUser = userService.saveUser(user);
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
  
  
  @PostMapping("/login")
  public ResponseEntity<?> getByUserPassword(@RequestBody final LoginDTO user) {
      String decodedEmail = new String(Base64.getDecoder().decode(user.getEmail()));
      String decodedPassword = new String(Base64.getDecoder().decode(user.getPassword()));
      System.out.println("Email got = "+decodedEmail);
      System.out.println("Password = "+decodedPassword);
      String dataAndRole = (String) userService.getByUserAndPassword(
          decodedEmail,
          decodedPassword
      );
      System.out.println("LOGIM Controller");
      return ResponseEntity.status(HttpStatus.OK).body(dataAndRole);
  }
}
