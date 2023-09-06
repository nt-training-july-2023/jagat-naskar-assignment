package com.feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feedback.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}

