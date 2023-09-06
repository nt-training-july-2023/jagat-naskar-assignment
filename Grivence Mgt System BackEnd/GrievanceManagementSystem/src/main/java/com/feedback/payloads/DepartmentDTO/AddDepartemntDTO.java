package com.feedback.payloads.DepartmentDTO;

public class AddDepartemntDTO {
  private String deptName;

  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  public AddDepartemntDTO(String deptNamee) {
    super();
    this.deptName = deptNamee;
  }

  @Override
  public String toString() {
    return "AddDepartemntDTO [deptName=" 
      + deptName + "]";
  }

  public AddDepartemntDTO() {
    super();
  }



  

  
}
