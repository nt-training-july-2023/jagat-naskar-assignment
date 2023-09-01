package com.feedback.service;

import com.feedback.entities.User;
import com.feedback.repository.DepartmentRepository;
import com.feedback.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
  public User saveUser(final User user) {
    User newUser = new User();
    System.out.println("Service User = "+user);
    newUser.setName(user.getName());
    newUser.setPassword(user.getPassword());
    newUser.setStatus("active");
    newUser.setUserName(user.getUserName());
    newUser.setUserType(user.getUserType());
    newUser.setDepartment(
      departmentRepository.findByDeptName(user.getDepartment().getDeptName())
    );
    return userRepository.save(newUser);
  }

  public String checkAlreadyExist(User user) {
    if (userRepository.existsByUserName(user.getUserName())) {
      return ("Email already exist.");
    } else if (userRepository.existsById(user.getUserId())) {
      return "UserId already exist.";
    }
    return "userNotExist";
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
      u1 = userRepository.getUserByUsername(userName);
      String roll = "";
      if (password.equals(u1.getPassword())) {
        if (u1 != null) {
          roll = u1.getUserType();
        }
        return "true_" + roll;
      }
    } catch (Exception e) {
      System.out.println("User not found");
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
}
