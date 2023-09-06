package com.feedback.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
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
  
  @Column(unique = true)
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
//  @Convert(converter = ERoleConverter.class)
  private ERole userType;

  /**
   * The type of the user (e.g., admin, regular).
   */
  @Column
  private Boolean finalPassword;

  /**
   * Maping Users with tickets -> oneToMany.
   */
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Ticket> ticketList = new ArrayList<>();
  
  /**
   * Mapping User to Comment (one to many).
  */
  @OneToMany(mappedBy = "user1", cascade = CascadeType.ALL)
  private List<Comment> commentList = new ArrayList<>();
  
  /**
   * Get the user's unique identifier.
   *
   * @return The user's ID.
   */
  public int getUserId() {
    return userId;
  }

  /**
   * Set the user's unique identifier.
   *
   * @param userIdd The new user ID.
   */
  public void setUserId(final int userIdd) {
    this.userId = userIdd;
  }
  
/**
   * 
   * @return finalPassword
   */
  public Boolean getfinalPassword() {
    return finalPassword;
    }
  
  /**
   * setting the finalPassword of the user.
   * @param finalPasswordd
   */
  public void setfinalPassword(final Boolean finalPasswordd) {
    this.finalPassword = finalPasswordd;
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

  @ManyToOne
  @JoinColumn(name = "deptId")
  private Department department;
  
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
  public ERole getUserType() {
    return userType;
  }

  /**
   * Set the user's type.
   *
   * @param userTypee The new user type.
   */
  public void setUserType(final ERole userTypee) {
    this.userType = userTypee;
  }
  
  /**
   * getDepartment method.
   * @return department.
  */
  public Department getDepartment() {
    return department;
    }
  
  /**
   * set Department.
   * @param department
   */
  public void setDepartment(Department department) {
    this.department = department;
    }
  
  /**
   * List of tickets in getTickets method.
   * @return
   */
  public List<Ticket> getTicketList() {
    return ticketList;
    }
  
  /**
   * set Ticket List.
   * @param ticketList.
   */
  public void setTicketList(List<Ticket> ticketList) {
    this.ticketList = ticketList;
    }
  
  /**
   * get Comment
   * @return
   */
  public List<Comment> getCommentList() {
    return commentList;
    }
  
  /**
   * setting List of Comment.
   * @param commentList
   */
  public void setCommentList(List<Comment> commentList) {
    this.commentList = commentList;
    }

  /**
   * field constructor.
   * @param userId
   * @param name
   * @param userName
   * @param password
   * @param userType
   * @param finalPassword
   * @param ticketList
   * @param commentList
   * @param department
   */
  public User(int userId,
    String name,
    String userName,
    String password,
    ERole userType,
    Boolean finalPassword,
//    List<Ticket> ticketList,
    List<Comment> commentList,
    Department department) {
      super();
      this.userId=userId;
      this.name=name;
      this.userName=userName;
      this.password=password;
      this.userType=userType;
      this.finalPassword=finalPassword;
//      this.ticketList=ticketList;
      this.commentList=commentList;
      this.department=department;
      }

@Override
  public String toString() {
    return "User [userId=" + userId 
      + ", name=" + name 
      + ", userName=" + userName 
      + ", password=" + password 
      + ", userType=" + userType 
      + ", finalPassword=" + finalPassword 
//      + ", ticketList=" + ticketList 
      + ", commentList=" + commentList 
      + ", department=" + department + "]";
  }
  
  public User(){
    super();
  }
}
