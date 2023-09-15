package com.feedback.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.UniqueElements;

/**
 * @version 1.0
 * @author Jagat Naskar
*/
@Entity
@Table(name = "Department")
public class Department {
  /**
   * deptId to store the department id.
  */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private int deptId;

  /**
   * deptName to store the department name.
   */
  @Column
  private String deptName;

  /**
   * Mapping Department to User (one to many).
   */
  @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
  private List<User> users = new ArrayList<>();
  
  /**
   * Mapping Department to Ticket (one to many).
  */
  @OneToMany(mappedBy = "assignedDepartment", cascade = CascadeType.ALL)
  private List<Ticket> assignedTickets = new ArrayList<>();
 
  /**
   * get Id of the department.
   * @return id of the department.
  */
  public int getDeptId() {
    return deptId;
  }

  /**
   * setting department id.
   * @param deptIdd
  */
  public void setDeptId(int deptIdd) {
    this.deptId = deptIdd;
  }

  /**
   * get List of userss.
   * @return
   */
  public List<User> getUser() {
    return users;
    }

  /**
   * set UserList.
   * @param users
   */
  public void setUser(List<User> userss) {
    this.users = userss;
    }
  
  /**
   * field constructor of field.
   * @param deptId
   * @param deptName
   * @param users
   * @param assignedTickets
  */
  public Department(int deptIdd,String deptNamee,
    List<User> userss,
    List<Ticket> assignedTicketss) {
      super();
      this.deptId=deptIdd;
      this.deptName=deptNamee;
      this.users=userss;
      this.assignedTickets=assignedTicketss;
      }

  /**
   * get TicketList.
   * @return
   */
  public List<Ticket> getTicketList() {
    return assignedTickets;
    }

  public void setTicketList(List<Ticket> assignedTicketss) {
    this.assignedTickets = assignedTicketss;
    }

  /**
   * getting name of the department.
   * @return department name.
   */
  public String getDeptName() {
    return deptName;
  }

  /**
   * setting department name.
   * @param deptNamee
   */
  public void setDeptName(String deptNamee) {
    this.deptName = deptNamee;
  }

  /**
   * Argument constructor.
   * @param deptIdd
   * @param deptNamee
   */
  public Department(int deptIdd, String deptNamee) {
    super();
    this.deptId = deptIdd;
    this.deptName = deptNamee;
  }

  /**
   * NoArgsConstructor.
   */
  public Department() {
    super();
  }
  
}
