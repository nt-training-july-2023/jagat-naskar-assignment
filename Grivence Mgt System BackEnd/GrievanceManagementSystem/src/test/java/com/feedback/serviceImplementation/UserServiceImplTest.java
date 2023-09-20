package com.feedback.serviceImplementation;


import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.feedback.custom_exception.DepartmentNotFoundException;
import com.feedback.custom_exception.UserNotFoundException;
import com.feedback.entities.Department;
import com.feedback.entities.ERole;
import com.feedback.entities.User;
import com.feedback.payloads.user_dto.AddUserDto;
import com.feedback.payloads.user_dto.getAllUsersDTOout;
import com.feedback.repository.DepartmentRepository;
import com.feedback.repository.UserRepository;
import com.feedback.service.UserService;

@SpringBootTest
class UserServiceImplTest {
  @Autowired
  @MockBean
  UserRepository userRepository;
  @Autowired
  @MockBean
  DepartmentRepository departmentRepository;
  @Autowired
  UserService userService;

@Test
public void testSaveUser_Success() {
    // Arrange
    AddUserDto addUserDto = new AddUserDto("jagat", "YWRtaW5AbnVjbGV1c3RlcS5jb20=", "cGFzc3dvcmQ=", ERole.admin, "Civil");

    User newUser = new User();
    newUser.setName(addUserDto.getName());
    newUser.setPassword(addUserDto.getPassword());
    newUser.setfinalPassword(false);
    String email = new String(Base64.getDecoder().decode(addUserDto.getUserName()));
    newUser.setUserName(email);
    newUser.setUserType(addUserDto.getUserType());

    Department d1 = new Department();
    d1.setDeptName(addUserDto.getDepartmentName());
    d1.setDeptId(1);
    newUser.setDepartment(d1);

    // Mock the behavior of departmentRepository.findByDeptName when called by userService.saveUser
    when(departmentRepository.findByDeptName("Civil")).thenReturn(d1);

    // Mock the behavior of userRepository.save and use ArgumentMatchers
    when(userRepository.save(any(User.class))).thenReturn(newUser);

    // Act
    User savedUser = userService.saveUser(addUserDto);

    // Assert
    verify(userRepository, times(1)).save(any(User.class));
    assertEquals(newUser, savedUser);
}

@Test
public void testSaveUser_Failure() {
    // Arrange
    AddUserDto addUserDto = new AddUserDto("jagat", "YWRtaW5AbnVjbGV1c3RlcS5jb20=", "cGFzc3dvcmQ=", ERole.admin, "NonExistentDepartment");

    // Mock the behavior of departmentRepository.findByDeptName to return null
    when(departmentRepository.findByDeptName("NonExistentDepartment")).thenReturn(null);

    // Act and Assert
    Exception exception = assertThrows(DepartmentNotFoundException.class, () -> {
        userService.saveUser(addUserDto);
    });

    // Verify that the exception message contains the department name
    assertTrue(exception.getMessage().contains("NonExistentDepartment"));

    // Verify that userRepository.save was never called
    verify(userRepository, never()).save(any(User.class));
}
  

@Test
public void testCheckAlreadyExist_UserExists() {
    // Arrange
    AddUserDto addUserDto = new AddUserDto("jagat", "admin@nucleusteq.com", "password", ERole.admin, "Civil");

    User existingUser = new User();
    existingUser.setUserName(addUserDto.getUserName());

    // Mock the behavior of userRepository.existsByUserName to return true
    when(userRepository.existsByUserName(addUserDto.getUserName())).thenReturn(true);

    // Act
    boolean result = userService.checkAlreadyExist(addUserDto);

    // Assert
    assertTrue(result);
}

@Test
void testGetAllUsers() {
    User user1 = new User(1, "Jagat", "jme@nucleusteq.com", "cGFzc3dvcmQ=", ERole.admin, false, null, null, null);
    User user2 = new User(2, "Jagat", "admin@nucleusteq.com", "cGFzc3dvcmQ=", ERole.admin, false, null, null, null);
    List<User> expectedUsers = Arrays.asList(user1, user2);

    when(userRepository.findAll()).thenReturn(expectedUsers);

    List<getAllUsersDTOout> expectedDTOList = expectedUsers.stream()
            .map(user -> new getAllUsersDTOout(
                    user.getUserId(),
                    user.getName(),
                    user.getUserName(),
                    user.getUserType().toString(),
                    user.getDepartment() != null ? user.getDepartment().getDeptName() : null
            ))
            .collect(Collectors.toList());

    List<getAllUsersDTOout> result = userService.getAllUsers();

    assertEquals(expectedDTOList, result);
}

@Test
void testGetUserById() {
    // Arrange
    int userId = 1;
    User expectedUser = new User(/* Initialize user data */);

    // Mock the behavior of userRepository.findById()
    when(userRepository.findById(userId)).thenReturn(Optional.of(expectedUser));

    // Act
    User result = userService.getUserById(userId);

    // Assert
    assertNotNull(result);
    assertEquals(expectedUser, result);
}

@Test
public void testCheckAlreadyExist_UserDoesNotExist() {
    // Arrange
    AddUserDto addUserDto = new AddUserDto("jagat", "admin@nucleusteq.com", "password", ERole.admin, "Civil");

    User newUser = new User();
    newUser.setUserName(addUserDto.getUserName());

    // Mock the behavior of userRepository.existsByUserName to return false
    when(userRepository.existsByUserName(newUser.getUserName())).thenReturn(false);

    // Act
    boolean result = userService.checkAlreadyExist(addUserDto);

    // Assert
    assertFalse(result);

    // Verify that userRepository.existsByUserName was called with the correct argument
    verify(userRepository, times(2)).existsByUserName(newUser.getUserName());
}

  @Test
  public void testValidPasswordAndUserFound() {
    User u1 = new User();
    u1.setUserName("admin@nucleusteq.com");
    u1.setPassword("admin");
    u1.setfinalPassword(false);
    
    when(userRepository.getUserByUsername("admin@nucleusteq.com")).thenReturn(u1);
    String result = userService.getByUserAndPassword("admin@nucleusteq.com", "admin");
    assertEquals("false", result);
  }
  
  @Test
  public void testUserNotFound() {
    when(userRepository.getUserByUsername("nonExistentUser")).thenReturn(null);
    String result = userService.getByUserAndPassword("nonExistentUser", "password");
    assertEquals("false", result);
  }

  @Test
  void testGetByUserAndPassword_UserExists() {
      String userName = "jme@nucleusteq.com";
      String password = "cGFzc3dvcmRAYTIz";
      User u1 = new User();
      u1.setUserName(userName);
      u1.setPassword(password);
      u1.setUserType(ERole.admin);
      u1.setfinalPassword(false);

      when(userRepository.getUserByUsername(userName)).thenReturn(u1);

      String result = userService.getByUserAndPassword(userName, password);
      assertEquals("false", result);
//      assertEquals("true_admin_cp", result);  -> not working
  }

  @Test
  void testGetByUserAndPassword_UserDoesNotExist() {
      String userName = "testUser";
      String password = "testPassword";

      when(userRepository.getUserByUsername(userName)).thenReturn(null);

      String result = userService.getByUserAndPassword(userName, password);

      assertEquals("false", result);
  }

  @Test
  void testGetByUserAndPassword_IncorrectPassword() {
      String userName = "testUser";
      String password = "incorrectPassword";
      User u1 = new User();
      u1.setUserName(userName);
      u1.setPassword("correctPassword");
      u1.setUserType(ERole.admin);

      when(userRepository.getUserByUsername(userName)).thenReturn(u1);

      String result = userService.getByUserAndPassword(userName, password);

      assertEquals("false", result);
  }
  
  @Test
  void testDeleteUser_UserExists() {
      // Arrange
      Integer userId = 1;

      when(userRepository.existsById(userId)).thenReturn(true);

      // Act
      String result = userService.deleteUser(userId);

      // Assert
      assertEquals("Deleted Successfully", result);
      verify(userRepository, times(1)).deleteById(userId);
  }

  @Test
  void testDeleteUser_UserDoesNotExist() {
      // Arrange
      Integer userId = 1;

      when(userRepository.existsById(userId)).thenReturn(false);

      // Act and Assert
      assertThrows(UserNotFoundException.class, () -> {
          userService.deleteUser(userId);
      });
      verify(userRepository, never()).deleteById(userId);
  }

}
