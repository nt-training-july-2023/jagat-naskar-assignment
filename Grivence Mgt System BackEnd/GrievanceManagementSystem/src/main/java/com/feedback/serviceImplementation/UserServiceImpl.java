package com.feedback.serviceImplementation;

import com.feedback.custom_exception.DepartmentNotFoundException;
import com.feedback.custom_exception.PasswordChangeException;
import com.feedback.custom_exception.UserNotFoundException;
import com.feedback.entities.Department;
import com.feedback.entities.ERole;
import com.feedback.entities.User;
import com.feedback.payloads.user_dto.AddUserDto;
import com.feedback.payloads.user_dto.PasswordChangeDTOin;
import com.feedback.repository.DepartmentRepository;
import com.feedback.repository.UserRepository;
import com.feedback.service.UserService;

import java.util.Base64;
import java.util.List;

import org.aspectj.lang.reflect.DeclareErrorOrWarning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Implementation of UserService interface.
 */
@Service
public class UserServiceImpl implements UserService {

  /**
   * @param userRepositoryy
   */
  public UserServiceImpl(final UserRepository userRepositoryy) {
    super();
    this.userRepository = userRepositoryy;
  }

  /**
   *userRepository.
   */
  @Autowired
  private final UserRepository userRepository;

  @Autowired
  private DepartmentRepository departmentRepository;

  /**
   * Save a user to the repository.
   *
   * @param user The user to be saved (should be final).
   * @return The saved user.
   */
  @Override
  public User saveUser(final AddUserDto user) {
    User newUser = new User();
    System.out.println("ser1 "+newUser);
    newUser.setName(user.getName());
    String decodedUserName = new String(Base64.getDecoder().decode(user.getUserName()));
    newUser.setUserName(decodedUserName);
    newUser.setPassword(user.getPassword());//encoded password from frontend
    newUser.setfinalPassword(false);
    newUser.setUserType(user.getUserType());
    System.out.println("ser2");
    Department d1 = new Department();
    if((departmentRepository.findByDeptName(user.getDepartmentName()) == null)) {
          throw new DepartmentNotFoundException(user.getDepartmentName());
      }
    d1= departmentRepository.findByDeptName(user.getDepartmentName());
    newUser.setDepartment(d1);
    return userRepository.save(newUser);
  }

  public boolean checkAlreadyExist(AddUserDto user) {
    User u1 = new User();
    u1.setUserName(user.getUserName());
    System.out.println("checking..."+userRepository.existsByUserName(u1.getUserName()));
    if (userRepository.existsByUserName(u1.getUserName())) {
      return true;
    }
    return false;
  }

  /**
   * Get a list of all users.
   *
   * @return A list of all users.
   */
  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  /**
   * Get a user by their ID.
   *
   * @param id The ID of the user to retrieve (should be final).
   * @return The user with the specified ID.
   */
  @Override
  public User getUserById(final Integer id) {
    return userRepository.findById(id).get();
  }

  /**
   * Check if a user with the given username and password exists.
   *
   * @param userName The username.
   * @param password The password.
   * @return True if a user with the given credentials exists, false otherwise.
   */
  @Override
  public String getByUserAndPassword(final String userName, final String password) {
    User u1 = null;
    try {
      if(!userRepository.existsByUserName(userName)) {
            return "false";
          }
      u1 = userRepository.getUserByUsername(userName);
      ERole roll=null;
      if (password.equals(u1.getPassword())) {
        if (u1 != null) {
          roll = u1.getUserType();
          if(u1.getfinalPassword() == false)
            return "true_" + roll.name()+"cp";
        }
        return "true_" + roll.name();
      }
    } catch (Exception e) {
        return "Error : "+e.getMessage();
    }
    return "false";
  }

  /**
   * Delete a user by their ID.
   *
   * @param id The ID of the user to delete (should be final).
   * @return True if the user was successfully deleted, false otherwise.
   */
  @Override
  public Boolean deleteUser(final Integer id) {
    return true;
  }

  public String passwordChangedSuccess(PasswordChangeDTOin request) {
	  System.out.println("change pass service 1");
    String userName = new String(Base64.getDecoder().decode(request.getUserName()));
//    String oldPassword = new String(Base64.getDecoder().decode(request.getOldPassword()));
//    String newPassword = new String(Base64.getDecoder().decode(request.getNewPassword()));
//    String confirmNewPassword = new String(Base64.getDecoder().decode(request.getConfirmNewPassword()));
    String oldPassword = request.getOldPassword();
    String newPassword = request.getNewPassword();
    String confirmNewPassword = request.getConfirmNewPassword();
  if(!userRepository.existsByUserName(userName))
      throw new UserNotFoundException(userName);
  User user = new User();
  user = userRepository.getUserByUsername(userName);
  String userPassword = user.getPassword();
  if(!userPassword.equals(oldPassword)) {
    return "Incorrect old password.";
  }
  if(!newPassword.equals(confirmNewPassword)) {
    return "newPassword does not match with confirm password";
  }
  if(userPassword.equals(oldPassword)) {
    if(newPassword.equals(confirmNewPassword)) {
      user.setPassword(newPassword);
      user.setfinalPassword(true);//for first time user
      userRepository.save(user);
      return "Password changed successfully";
    }
  }
  System.out.println("change pass ser end.");
    return "Sorry, could not change the password.";
    
    
  }
  
  
  
//Add ExceptionHandler for PasswordChangeException
// @ExceptionHandler(PasswordChangeException.class)
// public ResponseEntity<String> handlePasswordChangeException(PasswordChangeException ex) {
//     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
// }
  
}
