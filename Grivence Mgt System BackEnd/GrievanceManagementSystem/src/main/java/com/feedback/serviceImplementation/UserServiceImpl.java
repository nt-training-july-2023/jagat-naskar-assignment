package com.feedback.serviceImplementation;

import com.feedback.custom_exception.DepartmentNotFoundException;
import com.feedback.entities.Department;
import com.feedback.entities.ERole;
import com.feedback.entities.User;
import com.feedback.payloads.userDTO.AddUserDto;
import com.feedback.repository.DepartmentRepository;
import com.feedback.repository.UserRepository;
import com.feedback.service.UserService;

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
  public User saveUser(final AddUserDto user) {
    User newUser = new User();
    System.out.println("ser1 "+newUser);
    newUser.setName(user.getName());
    newUser.setUserName(user.getUserName());
    newUser.setPassword(user.getPassword());
    newUser.setfinalPassword(false);
    newUser.setUserType(user.getUserType());
    System.out.println("ser2");
    
    
    
//    System.out.println("---->"+departmentRepository.findByDeptName(user.getDepartment().getDeptName()));
    Department d1 = new Department();
    try {
    
      d1= departmentRepository.findByDeptName(user.getDepartment().getDeptName());
      System.out.println("d1= "+d1);
    }catch (Exception e) {
		System.out.println("Error = "+e.getMessage());
	}
    if(d1 == null)
    {
      throw new DepartmentNotFoundException(user.getDepartment().getDeptName());
    }
    newUser.setDepartment(d1);
    
    System.out.println("Service newUser = "+newUser);
    return userRepository.save(newUser);
  }

  public boolean checkAlreadyExist(AddUserDto user) {
    User u1 = new User();
    u1.setUserName(user.getUserName());
    System.out.println("checking..."+userRepository.existsByUserName(u1.getUserName()));
    if (userRepository.existsByUserName(u1.getUserName())) {
      return false;
    }
    return true;
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
    System.out.println("ser1....");
    try {
      System.out.println("ser2....");
      u1 = userRepository.getUserByUsername(userName);
      System.out.println("ser3....");
      ERole roll=null;
      System.out.println("ser3.3....");
      if (password.equals(u1.getPassword())) {
        System.out.println("ser4....");
        if (u1 != null) {
          System.out.println("ser5....");
          roll = u1.getUserType();
        }
        System.out.println("ser6....");
        return "true_" + roll.name();
      }
    } catch (Exception e) {
      System.out.println("ser7...."+e.getMessage());
      System.out.println("User not found");
    }
    System.out.println("ser8....");
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
