package com.feedback.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.repository.query.Param;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.feedback.entities.Department;
import com.feedback.entities.User;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private UserRepository userRepository;

  /**
   * return success user test.
   */
  @Test
  public void testGetUserByUsername_ExistingUser_ReturnsUser() {
    User user = new User();
    user.setUserName("jagat");
    entityManager.persistAndFlush(user);
    User foundUser = userRepository.getUserByUsername("jagat");
    assertEquals(user.getUserName(), foundUser.getUserName());
  }

  /**
   * failed to fetch user data.
   */
  @Test
  public void testGetUserByUsername_NonExistingUser_ReturnsNull() {
    User foundUser = userRepository.getUserByUsername("nonexistentuser");
    assertNull(foundUser);
  }
  

  /**
   * checking is the userExist in the database with the userName.
   * return true if exist.
   */
  @Test
  public void existsByUserName_success() {
	  User user = new User();
	    user.setUserName("jagat");
	    entityManager.persistAndFlush(user);
	    boolean foundUser = userRepository.existsByUserName("jagat");
	    assertEquals(true, foundUser);
  }
  
  /**
   * checking is the userExist in the database with the userName.
   * return false if not exist.
   */
  @Test
  public void existsByUserName_failure() {
	  User user = new User();
	    user.setUserName("jagat");
	    entityManager.persistAndFlush(user);
	    boolean foundUser = userRepository.existsByUserName("naskar");
	    assertEquals(false, foundUser);
  }
}
