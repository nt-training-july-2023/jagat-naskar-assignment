package com.feedback.payloads.user_dto;

import java.util.Objects;

import com.feedback.entities.ERole;
import com.feedback.payloads.department_dto.AddDepartemntDTO;

public class AddUserDto {
  String name;
  String userName;
  String password;
  ERole userType;
  String departmentName;
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public ERole getUserType() {
    return userType;
  }
  public void setUserType(ERole userType) {
    this.userType = userType;
  }
  
  
 
public String getDepartmentName() {
    return departmentName;
}
public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
}
@Override
  public String toString() {
    return "AddUser [name=" + name + ", userName=" + userName + ", password=" + password + ", userType=" + userType
      + ", department=" + departmentName + "]";
  }
  public AddUserDto(String namee, 
    String userNamee, 
    String passwordd, 
    ERole userTypee, 
    String departmentt) {
      super();
      this.name = namee;
      this.userName = userNamee;
      this.password = passwordd;
      this.userType = userTypee;
      this.departmentName = departmentt;
}
  
  public AddUserDto() {
    super();
  }
  @Override
  public int hashCode() {
    return Objects.hash(departmentName, name, password, userName, userType);
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    AddUserDto other = (AddUserDto) obj;
    return Objects.equals(departmentName, other.departmentName) && Objects.equals(name, other.name)
          && Objects.equals(password, other.password) && Objects.equals(userName, other.userName)
          && userType == other.userType;
  }
 


}
