package com.feedback.payloads.userDTO;

import com.feedback.entities.ERole;
import com.feedback.payloads.DepartmentDTO.AddDepartemntDTO;

public class AddUserDto {
  String name;
  String userName;
  String password;
  ERole userType;
  AddDepartemntDTO department;
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
  public AddDepartemntDTO getDepartment() {
    return department;
  }
  public void setDepartment(AddDepartemntDTO department) {
    this.department = department;
  }
  
  @Override
  public String toString() {
    return "AddUser [name=" + name + ", userName=" + userName + ", password=" + password + ", userType=" + userType
      + ", department=" + department + "]";
  }
  public AddUserDto(String namee, 
    String userNamee, 
    String passwordd, 
    ERole userTypee, 
    AddDepartemntDTO departmentt) {
      super();
      this.name = namee;
      this.userName = userNamee;
      this.password = passwordd;
      this.userType = userTypee;
      this.department = departmentt;
}
  
  public AddUserDto() {
    super();
  }
 


}
