package com.feedback.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Represents a ticket entity in the system.
 */
@Entity
@Table(name = "Ticket")
public class Ticket {

  /**
   * The Id of the ticket.
  */
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ticketId;

  /**
   * The title of the ticket.
  */
  @Column
  private String ticketTitle;

  /**
   * The type of the ticket.
  */
  @Column
  private String ticketType;

  /**
   * The status of the ticket.
  */
  @Column
  @Enumerated(EnumType.STRING)
  private EStatus ticketStatus;

  /**
   * The user who assigned the ticket.
  */
  @Column
  private String ticketAssignedBy;

  /**
   * The creation time of the ticket.
  */
  @Column
  @CreationTimestamp
  private LocalDateTime ticketCreationTime;

  /**
   * The last updated time of the ticket.
  */
  @Column
  @UpdateTimestamp
  private LocalDateTime lastUpdatedTime;
  
  @Column
  private String ticketDescription;
  
  /**
   * getting ticket description.
   * @return
   */
  public String getTicketDescription() {
    return ticketDescription;}

  /**
   * setting ticket description.
   * @param ticketDescription
   */
  public void setTicketDescription(String ticketDescription) {
    this.ticketDescription = ticketDescription;}

  @ManyToOne
  @JoinColumn(name = "userId")
  private User createdBy;

  @ManyToOne
  @JoinColumn(name = "deptId")
  private Department assignedDepartment; 
  
  @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
  private List<Comment> comments = new ArrayList<>();
  

/**
   * Default constructor.
  */
  public Ticket() {}

  /**
   * get user object.
   * @return
   */
  public User getUser() {
    return createdBy;
    }

  /**
   * set user object.
   * @param user
   */
  public void setUser(User user) {
    this.createdBy = user;
    }

  /**
   * get department object.
   * @return
   */
  public Department getDepartment() {
    return assignedDepartment;
    }

  /**\
   * set department object.
   * @param department
   */
  public void setDepartment(Department department) {
    this.assignedDepartment = department;
    }

/**
     * Get the id of the ticket.
     *
     * @return The ticket title.
     */
    public Long getTicketId() {
        return ticketId;
    }

    /**
     * Set the id of the ticket.
     *
     * @param ticketTitlee The new ticket title.
     */
    public void setTicketId(final long l) {
        this.ticketId = l;
    }
    
    /**
     * Get the title of the ticket.
     *
     * @return The ticket title.
     */
    public String getTicketTitle() {
        return ticketTitle;
    }

    /**
     * Set the title of the ticket.
     *
     * @param ticketTitlee The new ticket title.
     */
    public void setTicketTitle(final String ticketTitlee) {
        this.ticketTitle = ticketTitlee;
    }

    /**
     * Get the type of the ticket.
     *
     * @return The ticket type.
     */
    public String getTicketType() {
        return ticketType;
    }

    /**
     * Set the type of the ticket.
     *
     * @param ticketTypee The new ticket type.
     */
    public void setTicketType(final String ticketTypee) {
        this.ticketType = ticketTypee;
    }

    /**
     * Get the status of the ticket.
     *
     * @return The ticket status.
     */
    public EStatus getTicketStatus() {
        return ticketStatus;
    }

    /**
     * Set the status of the ticket.
     *
     * @param ticketStatuss The new ticket status.
     */
    public void setTicketStatus(final EStatus ticketStatuss) {
        this.ticketStatus = ticketStatuss;
    }

    /**
     * Get the user who assigned the ticket.
     *
     * @return The user who assigned the ticket.
     */
    public String getTicketAssignedBy() {
        return ticketAssignedBy;
    }

    /**
     * Set the user who assigned the ticket.
     *
     * @param ticketAssignedByy The user who assigned the ticket.
     */
    public void setTicketAssignedBy(final String ticketAssignedByy) {
        this.ticketAssignedBy = ticketAssignedByy;
    }

    /**
     * Get the creation time of the ticket.
     *
     * @return The ticket creation time.
     */
    public LocalDateTime getTicketCreationTime() {
        return ticketCreationTime;
    }

    /**
     * Set the creation time of the ticket.
     *
     * @param ticketCreationTimee The new ticket creation time.
     */
    public void setTicketCreationTime(final LocalDateTime ticketCreationTimee) {
        this.ticketCreationTime = ticketCreationTimee;
    }

/**
     * Get the last updated time of the ticket.
     *
     * @return The ticket's last updated time.
     */
    public LocalDateTime getLastUpdatedTime() {
        return lastUpdatedTime;
    }

  /**
   * setUpdated time.
   * @param lastUpdatedTimee
   */
  public void setLastUpdatedTime(final LocalDateTime lastUpdatedTimee) {
    this.lastUpdatedTime = lastUpdatedTimee;
    }

  /**
   * field parameter constructor.
   * @param ticketId
   * @param ticketTitle
   * @param ticketType
   * @param ticketStatus
   * @param ticketAssignedBy
   * @param ticketCreationTime
   * @param lastUpdatedTime
   * @param ticketDescription
   * @param user
   * @param department
   * @param commentList
   */
  public Ticket(Long ticketId, 
    String ticketTitle, 
    String ticketType, 
    EStatus ticketStatus, 
    String ticketAssignedBy,
    LocalDateTime ticketCreationTime, 
    LocalDateTime lastUpdatedTime, 
    String ticketDescription, 
    User user,
    Department department, 
    List<Comment> commentList) {
      super();
      this.ticketId = ticketId;
      this.ticketTitle = ticketTitle;
      this.ticketType = ticketType;
      this.ticketStatus = ticketStatus;
      this.ticketAssignedBy = ticketAssignedBy;
      this.ticketCreationTime = ticketCreationTime;
      this.lastUpdatedTime = lastUpdatedTime;
      this.ticketDescription = ticketDescription;
      this.createdBy = user;
      this.assignedDepartment = department;
      this.comments = commentList;
  }

public User getCreatedBy() {
	return createdBy;
}

public void setCreatedBy(User createdBy) {
	this.createdBy = createdBy;
}

public Department getAssignedDepartment() {
	return assignedDepartment;
}

public void setAssignedDepartment(Department assignedDepartment) {
	this.assignedDepartment = assignedDepartment;
}

public List<Comment> getComments() {
	return comments;
}

public void setComments(List<Comment> comments) {
	this.comments = comments;
}

public void addComment(String st) {
	if(st == null) {
		comments = new ArrayList<>();
	}
	else {
		comments.add(new Comment(st));
	}
}

public void setTicketId(Long ticketId) {
	this.ticketId = ticketId;
}
  
  
}

