package com.feedback.payloads.department_dto;

import java.util.Objects;

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
  public DepartmentListDTO(int l, String deptName) {
    super();
    this.deptId = l;
    this.deptName = deptName;
  }
  
  public DepartmentListDTO() {
    super();
  }

@Override
public int hashCode() {
    return Objects.hash(deptId, deptName);
}
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    DepartmentListDTO other = (DepartmentListDTO) obj;
    return deptId == other.deptId && Objects.equals(deptName, other.deptName);
  }
}
