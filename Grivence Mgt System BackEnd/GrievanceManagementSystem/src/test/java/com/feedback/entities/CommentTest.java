package com.feedback.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CommentTest {

  @Test
  void testGetCommentId() {
    Comment comment = new Comment(1, "Hi, I am Jagat");
    assertEquals(1, comment.getCommentId());
  }

  @Test
  void testSetCommentId() {
    Comment comment = new Comment();
    comment.setCommentId(2);
    assertEquals(2, comment.getCommentId());
  }

  @Test
  void testGetCommentMessage() {
    Comment comment = new Comment(1, "Hi, I am Jagat.");
    assertEquals("Hi, I am Jagat.", comment.getCommentMessage());
  }

  @Test
  void testSetCommentMessage() {
    Comment comment = new Comment();
    comment.setCommentMessage("Message from moon.");
    assertEquals("Message from moon.", comment.getCommentMessage());
  }

  @Test
  void testToString() {
    Comment comment = new Comment(1, "Message from moon.");
    String expected = "Comment [commentId=1, commentMessage=Message from moon.]";
    assertEquals(expected, comment.toString());
  }

  @Test
  void testCommentIntString() {
    Comment comment = new Comment(3, "Another Allien");
    assertEquals(3, comment.getCommentId());
    assertEquals("Another Allien", comment.getCommentMessage());
  }

  @Test
  void testComment() {
    Comment comment = new Comment();
    assertNull(comment.getCommentMessage());
    assertEquals(0, comment.getCommentId());
  }
}