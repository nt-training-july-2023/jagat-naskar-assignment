package com.feedback.controller;

import com.feedback.entities.User;
import com.feedback.service.UserService;
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
  public ResponseEntity<?> addUser(@RequestBody final User user) {
	  System.out.println("____________________________________");
	  System.out.println("Controller user = "+user);
    String message = "";
    if (!(userService.checkAlreadyExist(user).equals("userNotExist"))) {
      message = userService.checkAlreadyExist(user);
      return ResponseEntity.status(HttpStatus.OK).body(message);
    }
    User saved = null;
    try {
      System.out.println("TRY controller1_________________");
      saved = userService.saveUser(user);   //null->catch
      System.out.println("TRY controller2_________________");
      message = "Saved Successfully!!!";
      
    } catch (Exception e) {
      System.out.println("catch controller");
      System.out.println("Catch Controller: " + saved);
      message = "Could not saved into database!!! " + e.getMessage();
      System.out.println("End of catch___");
    }
    if (saved == null) {
    	System.out.println("if saved == null");
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
  public ResponseEntity<?> getByUserPassword(@RequestBody final User user) {
    String dataAndRole = (String) userService.getByUserAndPassword(
      user.getUserName(),
      user.getPassword()
    );
    return ResponseEntity.status(HttpStatus.OK).body(dataAndRole);
  }
}
