package com.feedback.payloads.comment_dto;

import java.util.Objects;

public class getCommentDTOout {
    private String commentedByUser;
    private String commentMessage;
    private int commentId;

/**
 * getCommentedByUser.
 * @return
 */
  public String getCommentedByUser() {
    return commentedByUser;
  }
  
  /**
   * setCommentedByUser.
   * @param commentedByUserr
   */
  public void setCommentedByUser(String commentedByUserr) {
    this.commentedByUser = commentedByUserr;
  }
  
  /**
   * getCommentMessage.
   * @return
   */
  public String getCommentMessage() {
    return commentMessage;
  }
  
  /**
   * setCommentMessage.
   * @param commentMessagee
   */
  public void setCommentMessage(String commentMessagee) {
    this.commentMessage = commentMessagee;
  }
  
  /**
   * getCommentId.
   * @return
   */
  public int getCommentId() {
    return commentId;
  }
  
  /**
   * setCommentId.
   * @param commentIdd
   */
  public void setCommentId(int commentIdd) {
    this.commentId = commentIdd;
  }
  
  /**
   * toString method.
   */
  @Override
  public String toString() {
    return "getCommentDTOout [commentedByUser=" + commentedByUser 
            + ", commentMessage=" + commentMessage
            + ", commentId=" + commentId + "]";
  }
  
  /**
   * hashCode method.
   */
  @Override
  public int hashCode() {
    return Objects.hash(commentId, commentMessage, commentedByUser);
}
  
  /**
   * object equals.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    getCommentDTOout other = (getCommentDTOout) obj;
    return commentId == other.commentId && Objects.equals(commentMessage, other.commentMessage)
            && Objects.equals(commentedByUser, other.commentedByUser);
}

  public getCommentDTOout(String commentedByUser, String commentMessage, int commentId) {
    super();
    this.commentedByUser = commentedByUser;
    this.commentMessage = commentMessage;
    this.commentId = commentId;
  }

  public getCommentDTOout() {
    super();
    // TODO Auto-generated constructor stub
  }
  
  

}

