package com.feedback.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import com.feedback.entities.Department;
import com.feedback.entities.User;
import com.feedback.repository.DepartmentRepository;
import com.feedback.repository.UserRepository;



class UserServiceImplTest {
	@Autowired
	UserRepository userRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	@InjectMocks
	UserService userService;
  
  @Test
  public void testValidPasswordAndUserFound() {
    User u1 = new User();
    u1.setUserName("admin@nucleusteq.com");
    u1.setPassword("admin");
    u1.setUserType("admin");
    
    UserRepository userRepository = mock(UserRepository.class);
    
    when(userRepository.getUserByUsername("admin@nucleusteq.com")).thenReturn(u1);
    userService = new UserServiceImpl(userRepository);
    String result = userService.getByUserAndPassword("admin@nucleusteq.com", "admin");
    assertEquals("true_" + u1.getUserType(), result);
  }
  
  @Test
  public void testSaveUser_success() {
    User newUser = new User();
      newUser.setName("jagat");
      newUser.setPassword("password");
      newUser.setStatus("active");
      newUser.setUserName("admin@nucleusteq.com");
      newUser.setUserType("admin");
      Department d1 = new Department();
      d1.setDeptName("Civil");
      newUser.setDepartment(d1);
      
      UserRepository userRepository = mock(UserRepository.class);
      DepartmentRepository departmentRepository = mock(DepartmentRepository.class);
     
      when(departmentRepository.findByDeptName("Civil")).thenReturn(d1);
      when(userRepository.save(newUser)).thenReturn(newUser);
      
      assertNotNull(d1);
      assertNotNull(newUser);
      assertEquals(newUser.getUserName(), "admin@nucleusteq.com");
      assertEquals(d1.getDeptName(), "Civil");
  }
  
  @Test
  public void testUserNotFound() {
    UserRepository userRepository = mock(UserRepository.class);
    when(userRepository.getUserByUsername("nonExistentUser")).thenReturn(null);
    UserService userService = new UserServiceImpl(userRepository);
    String result = userService.getByUserAndPassword("nonExistentUser", "password");
    assertEquals("false", result);
  }
}
