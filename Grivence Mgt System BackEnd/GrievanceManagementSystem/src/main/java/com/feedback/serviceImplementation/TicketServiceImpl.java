package com.feedback.serviceImplementation;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.entities.Ticket;
import com.feedback.payloads.ticket_dto.NewTicketDTO;
import com.feedback.repository.DepartmentRepository;
import com.feedback.repository.TicketRepository;
import com.feedback.repository.UserRepository;
import com.feedback.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
  @Autowired
  TicketRepository ticketRepository;
  @Autowired
  DepartmentRepository departmentRepository;
  @Autowired
  UserRepository userRepository;
  
  @Override 
  public Ticket saveTicket(NewTicketDTO ticket) {
    LocalDateTime currentDateTime = LocalDateTime.now();

    Ticket newTicket = new Ticket();
    newTicket.setTicketTitle(ticket.getTicketTitle());
    newTicket.setTicketType(ticket.getTicketType());
    newTicket.setTicketStatus(ticket.getTicketStatus());
    newTicket.setTicketDescription(ticket.getTicketDescription());
    newTicket.setDepartment(departmentRepository.findByDeptName(ticket.getDeptName()));
    newTicket.setUser(userRepository.getUserByUsername(ticket.getSenderEmail()));
    newTicket.setTicketAssignedBy(newTicket.getUser().getName());
    newTicket.setTicketCreationTime(currentDateTime);
    newTicket.setLastUpdatedTime(currentDateTime);
    return ticketRepository.save(newTicket);
    }
}

