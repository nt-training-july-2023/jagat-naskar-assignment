package com.feedback.payloads.AllTicketDTO;


import com.feedback.entities.EStatus;

public class NewTicketDTO {

  Long ticketId;
  String ticketTitle;
  String ticketType;
  EStatus ticketStatus;
  String ticketDescription;
  String senderEmail;
  String deptName;
  
  public Long getTicketId() {
    return ticketId;
  }
  public void setTicketId(Long ticketId) {
    this.ticketId = ticketId;
  }
  public String getTicketTitle() {
    return ticketTitle;
  }
public void setTicketTitle(String ticketTitle) {
    this.ticketTitle = ticketTitle;
  }
  public String getTicketType() {
    return ticketType;
  }
  public void setTicketType(String ticketType) {
    this.ticketType = ticketType;
  }
  public EStatus getTicketStatus() {
    return ticketStatus;
  }
  public void setTicketStatus(EStatus ticketStatus) {
    this.ticketStatus = ticketStatus;
  }
  
  public String getTicketDescription() {
    return ticketDescription;
  }
  public void setTicketDescription(String ticketDescription) {
    this.ticketDescription = ticketDescription;
}
  
  

  public String getSenderEmail() {
  return senderEmail;
}
  public void setSenderEmail(String senderEmail) {
    this.senderEmail = senderEmail;
  }
  public String getDeptName() {
    return deptName;
  }
  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  


  @Override
  public String toString() {
    return "NewTicketDTO [ticketId=" + ticketId + ", ticketTitle=" + ticketTitle + ", ticketType=" + ticketType
      + ", ticketStatus=" + ticketStatus + ", ticketDescription=" + ticketDescription + ", senderEmail="
      + senderEmail + ", deptName=" + deptName + "]";
}
public NewTicketDTO(Long ticketIdd, 
    String ticketTitlee, 
    String ticketTypee, 
    EStatus ticketStatuss,
    String ticketDescriptionn,
    String senderEmaill,
    String deptNamee) {
      super();
      this.ticketId = ticketIdd;
      this.ticketTitle = ticketTitlee;
      this.ticketType = ticketTypee;
      this.ticketStatus = ticketStatuss;
      this.ticketDescription = ticketDescriptionn;
      this.deptName = deptNamee;
      this.senderEmail = senderEmaill;
}
  
  public NewTicketDTO() {
    super();
  }

}
