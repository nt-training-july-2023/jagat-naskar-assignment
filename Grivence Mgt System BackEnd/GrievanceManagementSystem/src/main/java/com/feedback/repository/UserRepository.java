package com.feedback.repository;

import com.feedback.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * User repository for connecting the user table from the database.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  /**
   * SQL query to get user by username.
   */
  String MQ= "SELECT * FROM users WHERE user_name = :userName";

  /**
   * Checking if the user with the given username is present or not.
   * @param userName The username to search for.
   * @return The user if found, or null if not.
   */
	
	  @Query(value = MQ, nativeQuery = true) User
	  getUserByUsername(@Param("userName") String userName);
	 
	/*
	 * @Query("SELECT u FROM User u WHERE u.userName = :userName") User
	 * findByUserName(@Param("userName") String userName);
	 */
//  @Query(value="select User from User where userName=:userName")
//  User getUserByUserNames(@Param("userName") String userName);
  /**
   * SQL query to dept ID by deptName.
   */
  /**
   * check if the user exist or not by userName
   * @param userName
   * @return
   */
  @Query(
    value = "SELECT EXISTS(SELECT 1 FROM users WHERE user_name = :userName) AS user_exists",
    nativeQuery = true
  )
  boolean existsByUserName(@Param("userName") String userName);
  
  
  /**
   * updating password of a user.
   * @param userName
   * @param finalPassword
   * @param newPassword
   */
//  @Modifying
//  @Query("UPDATE users u SET u.password = :newPassword, u.final_password = :finalPassword WHERE u.user_name = :userName")
//  void updatePassword( @Param ("userName") String userName, @Param ("finalPassword") Boolean finalPassword, @Param ("newPassword") String newPassword);
}
