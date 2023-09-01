package com.feedback.service;

import com.feedback.entities.User;
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
  User saveUser(User user);

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
  String checkAlreadyExist(User user);
}
