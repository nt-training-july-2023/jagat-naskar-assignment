package com.feedback.payloads.user_dto;

import java.util.Objects;

public class PasswordChangeDTOin {
  private String userName;
  private String oldPassword;
  private String newPassword;
  private String confirmNewPassword;
  


  public PasswordChangeDTOin(String userNamee, 
        String oldPasswordd, 
        String newPasswordd, 
        String confirmNewPasswordd) {
    super();
    this.userName = userNamee;
    this.oldPassword = oldPasswordd;
    this.newPassword = newPasswordd;
    this.confirmNewPassword = confirmNewPasswordd;
}

  public PasswordChangeDTOin() {
    super();
    // TODO Auto-generated constructor stub
  }


  public String getUserName() {
    return userName;
}

public void setUserName(String userNamee) {
    this.userName = userNamee;
}

public String getOldPassword() {
    return oldPassword;
  }

  public void setOldPassword(String oldPasswordd) {
    this.oldPassword = oldPasswordd;
  }

  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPasswordd) {
    this.newPassword = newPasswordd;
  }

  public String getConfirmNewPassword() {
    return confirmNewPassword;
  }

  public void setConfirmNewPassword(String confirmNewPasswordd) {
    this.confirmNewPassword = confirmNewPasswordd;
  }

  @Override
  public String toString() {
    return "PasswordChangeDTOin [oldPassword=" + oldPassword 
        + ", newPassword=" + newPassword 
        + ", confirmNewPassword=" + confirmNewPassword + "]";
  }

@Override
public int hashCode() {
    return Objects.hash(confirmNewPassword, newPassword, oldPassword, userName);
}

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    PasswordChangeDTOin other = (PasswordChangeDTOin) obj;
    return Objects.equals(confirmNewPassword, other.confirmNewPassword)
            && Objects.equals(newPassword, other.newPassword) && Objects.equals(oldPassword, other.oldPassword)
            && Objects.equals(userName, other.userName);
  }

}

