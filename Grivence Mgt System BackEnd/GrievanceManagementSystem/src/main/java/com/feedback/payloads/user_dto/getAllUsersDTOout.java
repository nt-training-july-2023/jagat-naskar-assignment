package com.feedback.payloads.user_dto;

import java.util.Objects;

public class getAllUsersDTOout {
  int id;
  String name;
  String userName;
  String userType;
  String departmentName;
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
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
public String getUserType() {
    return userType;
}
public void setUserType(String userType) {
    this.userType = userType;
}
public String getDepartmentName() {
    return departmentName;
}
public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
}
@Override
public int hashCode() {
    return Objects.hash(departmentName, id, name, userName, userType);
}
@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    getAllUsersDTOout other = (getAllUsersDTOout) obj;
    return Objects.equals(departmentName, other.departmentName) && id == other.id && Objects.equals(name, other.name)
            && Objects.equals(userName, other.userName) && Objects.equals(userType, other.userType);
}
@Override
public String toString() {
    return "getAllUsersDTOout [id=" + id + ", name=" + name + ", userName=" + userName + ", userType=" + userType
            + ", departmentName=" + departmentName + "]";
}
public getAllUsersDTOout(int id, String name, String userName, String userType, String departmentName) {
    super();
    this.id = id;
    this.name = name;
    this.userName = userName;
    this.userType = userType;
    this.departmentName = departmentName;
}
public getAllUsersDTOout() {
    super();
    
}
  


}
