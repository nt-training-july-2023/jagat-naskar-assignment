package com.feedback.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.feedback.entities.User;
import com.feedback.service.UserService;
@CrossOrigin(origins ="http://localhost:3000/")

/**
 * Controller class for managing user-related HTTP endpoints.
 */
@RestController
@RequestMapping("api/users")
public class UserController {
	@Autowired
	UserService userService;
	
	 /**
     * Endpoint to save a new user.
     *
     * @param user The user object to be saved.
     * @return ResponseEntity containing the saved user and HTTP status code.
     */
//	@PostMapping("/saveUser")
//	public ResponseEntity<?> saveUser(@RequestBody User user){
//		 return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
//	}
	 /**
     * Endpoint to retrieve a list of all users.
     *
     * @return List of User objects representing all users.
     */
//	@GetMapping("/allUsers")
//	public List<User> getAllUsers() {
//		return userService.getAllUsers();
//	}
	 /**
     * Endpoint for user authentication.
     *
     * @param user The user object containing username and password for authentication.
     * @return True if authentication is successful, false otherwise.
     */
	@PostMapping("/login")
	@ResponseBody
	public Boolean getByUserPassword(@RequestBody User user) {
		System.out.println("JAGAT"+user.getUserName());
		System.out.println("PASS"+user.getPassword());
		return userService.getByUserAndPassword(user.getUserName(), user.getPassword());
	}
}
