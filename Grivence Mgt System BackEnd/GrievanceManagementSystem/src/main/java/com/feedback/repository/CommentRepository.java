package com.feedback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feedback.entities.Comment;
import com.feedback.entities.Ticket;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
	List<Comment> findByTicket(Ticket ticket);
}
