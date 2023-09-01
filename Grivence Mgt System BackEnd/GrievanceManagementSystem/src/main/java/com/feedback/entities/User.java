package com.feedback.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Represents a user entity in the system.
 * This class defines properties and methods related to users.
 *
 * @version 1.0
 * @author Jagat Naskar
 */
@Entity
@Table(name = "users")
public class User {

/**
   * The unique identifier for the user.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int userId;

  /**
   * The name of the user.
   */
  @Column
  private String name;

  /**
   * The username of the user.
   */
  @Column
  private String userName;

  /**
   * The password of the user.
   */
  @Column
  private String password;

  /**
   * The type of the user (e.g., admin, regular).
   */
  @Column
  private String userType;

  /**
   * Get the user's unique identifier.
   *
   * @return The user's ID.
   */
  public int getUserId() {
    return userId;
  }
  /**
   * The type of the user (e.g., admin, regular).
   */
  @Column
  private String status;

  /**
   * 
   * @return status
   */
  public String getStatus() {
    return status;}
  /**
   * setting the status of the user.
   * @param statuss
   */
  public void setStatus(final String statuss) {
    this.status = statuss;}

/**
   * Set the user's unique identifier.
   *
   * @param userIdd The new user ID.
   */
  public void setUserId(final int userIdd) {
    this.userId = userIdd;
  }

  /**
   * Get the user's name.
   *
   * @return The user's name.
   */
  public String getName() {
    return name;
  }

  /**
   * Set the user's name.
   *
   * @param namee The new name.
   */
  public void setName(final String namee) {
    this.name = namee;
  }

  /**
   * Get the user's username.
   *
   * @return The username.
   */
  public String getUserName() {
    return userName;
  }

  @OneToOne(cascade = CascadeType.ALL)
  private Department department;
  
  /**
   * getDepartment method.
   * @return department.
   */
  public Department getDepartment() {
    return department;}
  
  /**
   * set Department.
   * @param department
   */
  public void setDepartment(Department department) {
    this.department = department;}
/**
   * Set the user's username.
   *
   * @param userNamee The new username.
   */
  public void setUserName(final String userNamee) {
    this.userName = userNamee;
  }

  /**
   * Get the user's password.
   *
   * @return The password.
   */
  public String getPassword() {
    return password;
  }

  /**
   * Set the user's password.
   *
   * @param passwordd The new password.
   */
  public void setPassword(final String passwordd) {
    this.password = passwordd;
  }

  /**
   * Get the user's type.
   *
   * @return The user's type.
   */
  public String getUserType() {
    return userType;
  }

  /**
   * Set the user's type.
   *
   * @param userTypee The new user type.
   */
  public void setUserType(final String userTypee) {
    this.userType = userTypee;
  }

  // ... constructors and other methods ...

  /**
   * all Fields constructor of user.
   * @param userId
   * @param name
   * @param userName
   * @param password
   * @param userType
   * @param status
   * @param department
   */
  public User(int userId,
		  String name,
		  String userName,
		  String password,
		  String userType,
		  String status,
		  Department department) {
	  super();
	  this.userId=userId;
	  this.name=name;
	  this.userName=userName;
	  this.password=password;
	  this.userType=userType;
	  this.status=status;
	  this.department=department;}
  
  /**
   * Get a string representation of the user.
   *
   * @return A string representing the user.
   */
  
  @Override public String toString() {
	  return "User [userId=" + userId 
			  + ", name=" + name 
			  + ", userName=" 
			  + userName + ", password=" 
			  + password + ", userType=" 
			  + userType + ", status=" 
			  + status + ", department=" 
			  + department + "]";}
  
  public User(){
    super();
  }
}