package com.feedback.payloads.department_dto;


public class DepartmentListDTO {
  private int deptId;
  private String deptName;

  public int getDeptId() {
  return deptId;
  }
  public void setDeptId(int deptId) {
    this.deptId = deptId;
  }
  public String getDeptName() {
    return deptName;
  }
  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }
  @Override
  public String toString() {
    return "DepartmentListDTO [deptId=" + deptId 
        + ", deptName=" + deptName 
        + "]";
  }
  

}
