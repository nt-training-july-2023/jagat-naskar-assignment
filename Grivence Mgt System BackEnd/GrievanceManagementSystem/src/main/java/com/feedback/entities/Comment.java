package com.feedback.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Comment class.
 */

/**
 * comment entity.
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
   * 
   * @return id of the comment.
   */
  public int getCommentId() {
    return commentId;}

  /**
   * set comment Id.
   * @param commentIdd.
   */
  public void setCommentId(int commentIdd) {
    this.commentId = commentIdd;}

  /**
   * get message comment
   * @return
   */
  public String getCommentMessage() {
    return commentMessage;}

  /**
   * set comment message.
   * @param commentMessagee
   */
  public void setCommentMessage(String commentMessagee) {
    this.commentMessage = commentMessagee;}

  /**
   * to string menthod.
   */
  @Override 
  public String toString() {
	  return "Comment [commentId=" 
        + commentId 
        + ", commentMessage=" 
        + commentMessage 
        + "]";}

  /**
   * parameterized constructor.
   * @param commentId
   * @param commentMessage
   */
  public Comment(int commentIdd,String commentMessagee) {
	  super();this.commentId=commentIdd;
	  this.commentMessage=commentMessagee;}

  /**
   * non parameterized constructor.
   */
  public Comment() {
	  super();
  }
  
}
