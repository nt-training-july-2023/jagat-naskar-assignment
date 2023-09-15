package com.feedback.serviceImplementation;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.custom_exception.TicketNotFoundException;
import com.feedback.custom_exception.UserNotFoundException;
import com.feedback.entities.Comment;
import com.feedback.entities.Department;
import com.feedback.entities.EStatus;
import com.feedback.entities.Ticket;
import com.feedback.entities.User;
import com.feedback.payloads.comment_dto.getCommentDTOout;
import com.feedback.payloads.ticket_dto.GetTicketsDTOin;
import com.feedback.payloads.ticket_dto.NewTicketDTO;
import com.feedback.payloads.ticket_dto.UpdateTicketDTOin;
import com.feedback.payloads.ticket_dto.getTicketDTOout;
import com.feedback.repository.CommentRepository;
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
  @Autowired
  CommentRepository commentRepository;
  
  /**
   * saving ticket.
   * @param NewTicketDTO.
   * @return saved ticket.
   */
  @Override 
  public Ticket saveTicket(NewTicketDTO ticket) {
    LocalDateTime currentDateTime = LocalDateTime.now();
    Ticket newTicket = new Ticket();
    newTicket.setTicketTitle(ticket.getTicketTitle());
    newTicket.setTicketType(ticket.getTicketType());
    newTicket.setTicketStatus(ticket.getTicketStatus());
    newTicket.setTicketDescription(ticket.getTicketDescription());
    newTicket.setDepartment(departmentRepository.findByDeptName(ticket.getDeptName()));
    
    byte[] decodedBytes = Base64.getDecoder().decode(ticket.getSenderEmail());
    String decodedEmail = new String(decodedBytes);
    
    if(userRepository.existsByUserName(decodedEmail)) {
      newTicket.setUser(userRepository.getUserByUsername(decodedEmail));
      newTicket.setTicketAssignedBy(newTicket.getUser().getName());
    }else {
      throw new UserNotFoundException(ticket.getSenderEmail());
    }
    newTicket.setTicketCreationTime(currentDateTime);
    newTicket.setLastUpdatedTime(currentDateTime);
    return ticketRepository.save(newTicket);
    }
  
  /**
   * saving getting ticket.
   * @param GetTicketsDTOin.
   * @return list of ticket.
   */
  @Override
  public List<getTicketDTOout> getTickets(GetTicketsDTOin getTicketsDTOin) {
    String decodedSenderEmail = new String(Base64.getDecoder().decode(getTicketsDTOin.getEmail()));
    System.out.println("ser email => "+decodedSenderEmail);
    boolean isDepartmentBased = false;
    boolean isAssignByOwn = false;
    if(getTicketsDTOin.getAssignByOwn().equals("true")) {
      isAssignByOwn = true;
    }
    if(getTicketsDTOin.getDepartmentBased().equals("true")) {
      isDepartmentBased = true;
    }
    if(userRepository.existsByUserName(decodedSenderEmail)) {
      User user = userRepository.getUserByUsername(decodedSenderEmail);
      List<Ticket> outPutlist = null ;
      int departId = user.getDepartment().getDeptId();
      if (isDepartmentBased) {
        Department newDepartment = departmentRepository.findById(departId).get();
        outPutlist = ticketRepository.findByDepartment(newDepartment);
      }
      else if(isAssignByOwn) {
    	  outPutlist = ticketRepository.findByUser(user);
      } else if (user.getUserType().toString().equals("admin")) {
        outPutlist =  ticketRepository.findAll();
      }
      if(outPutlist == null) {
        throw new TicketNotFoundException("Ticket not found."); 
      }

      List<getTicketDTOout> OUTPUTLIST = outPutlist.stream()
            .map(this::convertToDTO)
            .sorted(Comparator.comparing(getTicketDTOout::getTicketStatus, EStatus.getStatusComparator()))
            .collect(Collectors.toList());
      
      System.out.println("SERVICE END");
      return OUTPUTLIST;

    }else {
      System.out.println("User Not Found");
      throw new UserNotFoundException(decodedSenderEmail);
    }
  }

  
  
  
  
  private getTicketDTOout convertToDTO(Ticket ticket) {
    if(ticket == null)
      throw new TicketNotFoundException("No ticket available.");
      getTicketDTOout dto = new getTicketDTOout();
      dto.setTicketId(ticket.getTicketId());
      dto.setTitle(ticket.getTicketTitle());
      dto.setCreationTime(ticket.getTicketCreationTime());
      dto.setUpdationTime(ticket.getLastUpdatedTime());
      dto.setTicketStatus(ticket.getTicketStatus());
      dto.setTicketType(ticket.getTicketType());
      dto.setCreatedBy(ticket.getTicketAssignedBy());
      dto.setDepartmentName(ticket.getDepartment().getDeptName());
      
      // Fetch and set comments for this ticket
      List<Comment> comments = commentRepository.findByTicket(ticket);
      List<getCommentDTOout> commentDTOs = comments.stream()
          .map(comment -> {
            getCommentDTOout commentDTO = new getCommentDTOout();
              commentDTO.setCommentId(comment.getCommentId());
              commentDTO.setCommentMessage(comment.getCommentMessage());
              commentDTO.setCommentedByUser(ticket.getUser().getName());
              return commentDTO;
          })
          .collect(Collectors.toList());
      dto.setComments(commentDTOs);
      return dto;
  }

  /**
   * updating ticket.
   * @param updateTicketDTOin
   * @return true if ticket updated else false.
   */
  @Override
  public Boolean updatingTicket(UpdateTicketDTOin updateTicketDTOin) {
    Optional<Ticket> ticket = ticketRepository.findById(updateTicketDTOin.getTicketId());
    Ticket ticket2 = ticket.get();
    if(!ticket.isPresent()) {
      throw new TicketNotFoundException("Ticket not found");
    }
    if(updateTicketDTOin.getTicketStatus() != null) {
      ticket2.setTicketStatus(updateTicketDTOin.getTicketStatus());
      if(updateTicketDTOin.getTicketStatus().toString().equals("Resolved") && updateTicketDTOin.getCommentList() == null) {
        return null;
      }
    }
    LocalDateTime lastUpdateTime = LocalDateTime.now();
    ticket2.setLastUpdatedTime(lastUpdateTime);
    if (updateTicketDTOin.getCommentList() != null) {
        List<Comment> newComments = updateTicketDTOin.getCommentList();
        ticket2.setComments(newComments);
    }
    Ticket savedTicket = ticketRepository.save(ticket2);
  
    return savedTicket != null;
  }
}

