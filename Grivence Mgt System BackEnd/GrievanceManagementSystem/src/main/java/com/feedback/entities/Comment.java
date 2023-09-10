package com.feedback.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Comment class.
 */

@Entity
@Table(name = "Comment")
public class Comment {
  
  /**
   * commentId to store.
   */
  @Id
  @Column
  private int commentId;
  
  /**
   * commentMessage to store comments by the user.
  */
  @Column
  private String commentMessage;

  /**
   * Comment to User mapping -> Many to One relationship
  */
  @JoinColumn(name = "userId")
  @ManyToOne
  private User user1;
  
  public User getUser1() {
    return user1;
    }

  public void setUser1(User user1) {
    this.user1 = user1;
  }

//  @JoinColumn(name = "userId")
  @ManyToOne
  private Ticket ticket;

  public Ticket getTicket() {
    return ticket;
  }
  
  public void setTicket(Ticket tickett) {
    this.ticket = tickett;
  }
  /**
   *
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
  public Comment(int commentId,
    String commentMessage,
    User user1) {
      super();
      this.commentId=commentId;
      this.commentMessage=commentMessage;
      this.user1=user1;
      }

  /**
   * non parameterized constructor.
  */
  public Comment() {
    super();
  }
}
