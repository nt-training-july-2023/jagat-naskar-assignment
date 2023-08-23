package com.feedback.service;

import java.util.List;
import com.feedback.entities.User;

/**
 * User service interface to declare all the class 
 */
public interface UserService {
	 User saveUser(User user);
	 List<User> getAllUsers();
	 User getUserById(Integer id); 
	 Boolean deleteUser(Integer id);
	 Boolean getByUserAndPassword(String userName, String Password);
}
