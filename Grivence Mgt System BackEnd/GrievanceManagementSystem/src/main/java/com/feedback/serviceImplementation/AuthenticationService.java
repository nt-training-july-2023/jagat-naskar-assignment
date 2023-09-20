package com.feedback.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.entities.User;
import com.feedback.repository.UserRepository;
import com.feedback.service.authorization_service;

@Service
public class AuthenticationService implements authorization_service{

  @Autowired
  private UserRepository userRepository;

  @Override
  public boolean authenticateAdmin(String username, String password) {
    User user = new User();
    if(userRepository.existsByUserName(username)) {
      user = userRepository.getUserByUsername(username);
      if(password.equals(user.getPassword())) {
    	  if(user.getUserType().equals("admin")) {
    		  return true;
    	  }
          
        }
    }
    return false;
  }

}

