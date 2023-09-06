package com.feedback.payloads.user_dto;

import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginDTO {
  
  private String email;
  
  /**
   * The minimum size of password for the member.
   */
  private static final int MIN_SIZE = 8;

  /**
   * The password associated with the member's account.
   * Password must be between 5 and 12 characters in length.
   */
  
  private String password;

  private Boolean isFirstLogin;
  
  /**
   * get firstLogin.
   * @return returns boolean value.
   */
  public Boolean getIsFirstLogin() {
    return isFirstLogin;}
  
  /**
   * set first boolean value.
   * @param isFirstLogin.
   */
  public void setIsFirstLogin(Boolean isFirstLogin) {
    this.isFirstLogin = isFirstLogin;}
/**
   * get email.
   * @return
   */
  public String getEmail() {
    return email;}
  /**
   * set email.
   * @param email
   */
  public void setEmail(String email) {
    this.email = email;}

  /**
   * get password.
   * @return
   */
  public String getPassword() {
    return password;}
  /**
   * set password.
   * @param password
   */
  public void setPassword(String password) {
    this.password = password;
    }
  
  /**
   * to String of userName and Password.
   */
  @Override
  public String toString() {
    return "LoginDTO [email=" + email 
      + ", password=" + password 
      + "]";
    }
  
  /**
   * hashCode method of object.
   */
  @Override 
  public int hashCode() {
    return Objects.hash(email,password);
    }
  
  /**
   * equals of object method.
   */
  @Override public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    LoginDTO other=(LoginDTO)obj;
    return Objects.equals(email,other.email)
      && Objects.equals(password,other.password);
    }

  public LoginDTO(@Email @Size(min=16, max=35) 
      @Pattern(regexp="^[A-Za-z0-9_.-]+@nucleusteq\\.com$", 
      message="email format: ...@nucleusteq.com")
    String email,
    @NotEmpty @Size(min=8, 
    message="Password should be greater than 8 char.")
  String password) {
      super();
      this.email=email;
      this.password=password;
    }

  public LoginDTO(){
    super();
    }
}

