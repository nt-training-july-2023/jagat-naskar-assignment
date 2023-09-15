package com.feedback.payloads.ticket_dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.feedback.entities.EStatus;
import com.feedback.payloads.comment_dto.getCommentDTOout;


public class getTicketDTOout {
    private Long ticketId;
    private String title;
    private LocalDateTime creationTime;
    private LocalDateTime updationTime;
    private EStatus ticketStatus;
    private String ticketType;
    private String createdBy;
    private String departmentName;
    private List<getCommentDTOout> comments;
    
    public Long getTicketId() {
        return ticketId;
    }
    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public LocalDateTime getCreationTime() {
        return creationTime;
    }
    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }
    public LocalDateTime getUpdationTime() {
        return updationTime;
    }
    public void setUpdationTime(LocalDateTime updationTime) {
        this.updationTime = updationTime;
    }
    public EStatus getTicketStatus() {
        return ticketStatus;
    }
    public void setTicketStatus(EStatus eStatus) {
        this.ticketStatus = eStatus;
    }
    public String getTicketType() {
        return ticketType;
    }
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<getCommentDTOout> getComments() {
        return comments;
    }
    public void setComments(List<getCommentDTOout> commentDTOs) {
        this.comments = commentDTOs;
    }
  public getTicketDTOout(Long ticketIdd, 
      String titlee, 
      LocalDateTime creationTimee, 
      LocalDateTime updationTimee,
      EStatus ticketStatuss, 
      String ticketTypee, 
      String createdByy, 
      String departmentNamee,
      List<getCommentDTOout> commentss) {
    super();
    this.ticketId = ticketIdd;
    this.title = titlee;
    this.creationTime = creationTimee;
    this.updationTime = updationTimee;
    this.ticketStatus = ticketStatuss;
    this.ticketType = ticketTypee;
    this.createdBy = createdByy;
    this.departmentName = departmentNamee;
    this.comments = commentss;
  }
  public getTicketDTOout() {
    super();
    // TODO Auto-generated constructor stub
  }
  @Override
  public int hashCode() {
    return Objects.hash(comments, createdBy, 
        creationTime, departmentName, 
        ticketId, ticketStatus, ticketType,
        title, updationTime);
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    getTicketDTOout other = (getTicketDTOout) obj;
    return Objects.equals(comments, other.comments) && 
        Objects.equals(createdBy, other.createdBy)
        && Objects.equals(creationTime, other.creationTime)
        && Objects.equals(departmentName, other.departmentName) && 
        Objects.equals(ticketId, other.ticketId)
        && ticketStatus == other.ticketStatus && 
        Objects.equals(ticketType, other.ticketType)
        && Objects.equals(title, other.title) && 
        Objects.equals(updationTime, other.updationTime);
  }

  

  }
