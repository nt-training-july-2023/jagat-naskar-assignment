package com.feedback.service;

import com.feedback.entities.User;
import com.feedback.payloads.user_dto.AddUserDto;
import com.feedback.payloads.user_dto.PasswordChangeDTOin;

import java.util.List;

/**
 * User service interface to declare all the class.
 */
public interface UserService {
  /**
   *
   * @param user
   * @return user to save
   */
  User saveUser(AddUserDto user);

  /**
   *
   * @return list of user
   */
  List<User> getAllUsers();

  /**
   *
   * @param id
   * @return user
   */
  User getUserById(Integer id);

  /**
   *
   * @param id
   * @return true or false based on the action
   */
  Boolean deleteUser(Integer id);

  /**
   *
   * @param userName
   * @param Password
   * @return true or false
   */
  String getByUserAndPassword(String userName, String Password);

  /**
   *
   * @param user
   * @return if the user exist or not by id or by mail.
   */
  boolean checkAlreadyExist(AddUserDto user);
  
  /**
   * interface of passwordChangedSuccess.
   * @param request
   * @return true or false;
   */
  String passwordChangedSuccess(PasswordChangeDTOin request);
}
