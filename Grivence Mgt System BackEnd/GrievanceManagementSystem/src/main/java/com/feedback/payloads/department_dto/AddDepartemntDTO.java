package com.feedback.payloads.department_dto;

import java.util.Objects;

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

  @Override
  public int hashCode() {
    return Objects.hash(deptName);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    AddDepartemntDTO other = (AddDepartemntDTO) obj;
    return Objects.equals(deptName, other.deptName);
  }
}

