package com.feedback.payloads;

import javax.persistence.Id;


import com.feedback.entities.Ticket;
import com.feedback.entities.User;

public class CommentDTO {
	/**
	   * commentId to store.
	   */
	@Id
	  private int commentId;
	  
	  /**
	   * commentMessage to store comments by the user.
	  */

	  private String commentMessage;

	  /**
	   * Comment to User mapping -> Many to One relationship
	  */
	  private User user1;
	  
	  public User getUser1() {
	    return user1;
	    }

	  public void setUser1(User user1) {
	    this.user1 = user1;
	  }

	//  @JoinColumn(name = "userId")
	  private Ticket ticket;

  public Ticket getTicket() {
    return ticket;
	  }
	  
	  public void setTicket(Ticket tickett) {
	    this.ticket = tickett;
	  }
	  /**
	   *
	   * @return id of the comment.
	   */
	  public int getCommentId() {
	    return commentId;
	    }

	  /**
	   * set comment Id.
	   * @param commentIdd.
	   */
	  public void setCommentId(int commentIdd) {
	    this.commentId = commentIdd;
	    }

	  /**
	   * get message comment
	   * @return
	   */
	  public String getCommentMessage() {
	    return commentMessage;
	    }

	  /**
	   * set comment message.
	   * @param commentMessagee
	   */
	  public void setCommentMessage(String commentMessagee) {
	    this.commentMessage = commentMessagee;
	    }

	/**
	  * field constructor.
	  * @param commentId
	  * @param commentMessage
	  * @param user1
	  */
	  public CommentDTO(int commentId,
	    String commentMessage,
	    User user1) {
	      super();
	      this.commentId=commentId;
	      this.commentMessage=commentMessage;
	      this.user1=user1;
	      }

  @Override
  public String toString() {
    return "CommentDTO [commentId=" + commentId 
      + ", commentMessage=" + commentMessage 
      + ", user1=" + user1
      + ", ticket=" + ticket 
      + "]";
  }

	/**
	   * non parameterized constructor.
	  */
	  public CommentDTO() {
	    super();
	  }

  /**
   * field constructor.
   * @param commentId
   * @param commentMessage
   * @param user1
   * @param ticket
   */
  public CommentDTO(int commentId, 
    String commentMessage, 
    User user1, 
    Ticket ticket) {
      super();
      this.commentId = commentId;
      this.commentMessage = commentMessage;
      this.user1 = user1;
      this.ticket = ticket;
  }
}

