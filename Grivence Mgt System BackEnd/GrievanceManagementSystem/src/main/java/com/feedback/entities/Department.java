package com.feedback.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
   * to string method.
   */
  @Override
  public String toString() {
    return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
  }

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
