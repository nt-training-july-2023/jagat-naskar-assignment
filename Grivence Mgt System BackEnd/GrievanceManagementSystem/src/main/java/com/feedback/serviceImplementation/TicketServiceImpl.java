package com.feedback.serviceImplementation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.feedback.custom_exception.TicketNotFoundException;
import com.feedback.custom_exception.UserNotFoundException;
import com.feedback.entities.Comment;
import com.feedback.entities.Department;
import com.feedback.entities.EStatus;
import com.feedback.entities.Ticket;
import com.feedback.entities.User;
import com.feedback.mapper.EStatusConverter;
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
    System.out.println("Dept based ="+getTicketsDTOin.getDepartmentBased());
    System.out.println("own based ="+getTicketsDTOin.getAssignByOwn());
    boolean isDepartmentBased = false;
    boolean isAssignByOwn = false;
    EStatus filterStatus=null;
    if(getTicketsDTOin.getFilterStatus()!=null 
            || getTicketsDTOin.getFilterStatus() != "" 
            || getTicketsDTOin.getFilterStatus() != "Select status") {
         filterStatus = EStatusConverter.convertStringToEStatus(getTicketsDTOin.getFilterStatus().toString());
    }

    if(getTicketsDTOin.getAssignByOwn().equals("true")) {
      isAssignByOwn = true;
    }
    if(getTicketsDTOin.getDepartmentBased().equals("true")) {
      isDepartmentBased = true;
    }
    if(userRepository.existsByUserName(decodedSenderEmail)) {
		      User user = userRepository.getUserByUsername(decodedSenderEmail);
		     System.out.println("Page number: "+getTicketsDTOin.getPageNumber());
		     //setting page number and no of page
		     Pageable pageable = PageRequest.of(getTicketsDTOin.getPageNumber(), 5);
		      
		      
		      //preparing a list of ticket to add into OUTPUT list
		      List<Ticket> outPutlist = null ;
		      int departId = user.getDepartment().getDeptId();
		      if (isDepartmentBased) {
		        Department newDepartment = departmentRepository.findById(departId).get();
		        
		         Page<Ticket> pageList  = ticketRepository.findByDepartment(newDepartment, pageable);
		         outPutlist = pageList.getContent();
		        if(filterStatus!=null) {
		        	 Page<Ticket> pageList1 = ticketRepository.findByDepartmentAndStatus(newDepartment, filterStatus, pageable);
		        	outPutlist = pageList1.getContent();
		        }
		      }
		      else if(isAssignByOwn) {
		    	  Page<Ticket>  pageList2 = ticketRepository.findByUser(user, pageable);
		          outPutlist = pageList2.getContent();
		          if(filterStatus!=null) {
		        	  Page<Ticket> pageList3 = ticketRepository.findByCreatedByAndTicketStatus(user, filterStatus, pageable);
		        	  outPutlist = pageList3.getContent();
			        }
		      } else if (user.getUserType().toString().equals("admin")) {
		    	  Page<Ticket> pageList4 = ticketRepository.findAll(pageable);
		        outPutlist = pageList4.getContent();
		        if(filterStatus != null) {
		          Page<Ticket> pageList5 = ticketRepository.findByTicketStatus(filterStatus, pageable);
		          outPutlist = pageList5.getContent();
		        }
		      }
		      if(outPutlist == null) {
		        throw new TicketNotFoundException("Ticket not found."); 
		      }
		
		      List<getTicketDTOout> OUTPUTLIST = outPutlist.stream()
		            .map(this::convertToDTO)
		            .sorted(Comparator.comparing(getTicketDTOout::getTicketStatus, EStatus.getStatusComparator()))
		            .collect(Collectors.toList());
		      System.out.println("Output = "+OUTPUTLIST);
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
//      List<Comment> comments = commentRepository.findByTicket(ticket);
//      List<getCommentDTOout> commentDTOs = comments.stream()
//          .map(comment -> {
//            getCommentDTOout commentDTO = new getCommentDTOout();
//              commentDTO.setCommentId(comment.getCommentId());
//              commentDTO.setCommentMessage(comment.getCommentMessage());
//              commentDTO.setCommentedByUser(ticket.getUser().getName());
//              return commentDTO;
//          })
//          .collect(Collectors.toList());
//      dto.setComments(commentDTOs);
      dto.setComments(null);
      return dto;
  }
   
//  EStatusConverter eStatusConverter;
  /**
   * updating ticket.
   * @param updateTicketDTOin
   * @return true if ticket updated else false.
   */
  @Override
  public Boolean updatingTicket(UpdateTicketDTOin updateTicketDTOin) {
	  
	  EStatus newStatus = EStatusConverter.convertStringToEStatus(updateTicketDTOin.getTicketStatus().toString());
	  System.out.println("ticket exist = "+ticketRepository.existsById(updateTicketDTOin.getTicketId()));
    if(!ticketRepository.existsById(updateTicketDTOin.getTicketId())) {
      throw new TicketNotFoundException((int)updateTicketDTOin.getTicketId());
    }
    Optional<Ticket> ticket = ticketRepository.findById(updateTicketDTOin.getTicketId());
    
    Ticket ticket2 = ticket.get();
    if(!ticket.isPresent()) {
      throw new TicketNotFoundException("Ticket not found");
    }
    if(newStatus != null) {
      ticket2.setTicketStatus(newStatus);
      if(newStatus.equals(EStatus.Resolved) && updateTicketDTOin.getComment() == "") {//changed status without comment not allowed
        return null;
      }
    }
    LocalDateTime lastUpdateTime = LocalDateTime.now();
    ticket2.setLastUpdatedTime(lastUpdateTime);
    if (updateTicketDTOin.getComment() != null && updateTicketDTOin.getComment() != "") {
        ticket2.addComment(updateTicketDTOin.getComment());
    }
    Comment comment=new Comment();
    comment.setCommentMessage(updateTicketDTOin.getComment());
    comment.setTicket(ticket2);
    comment.setUser1(ticket.get().getUser());
    
   // Comment savedComment = commentRepository.save(comment);
   
    
List<Comment>list=new ArrayList<>();
list.add(comment);
    ticket2.setComments( list);
    Ticket savedTicket = ticketRepository.save(ticket2);
  
    return savedTicket != null;
  }

@Override
public getTicketDTOout getByTicketById(Long ticketId) {
    if(!ticketRepository.existsById(ticketId)) {
        return null;
    }
    Optional<Ticket> ticket = ticketRepository.findById(ticketId);
    getTicketDTOout t1 = new getTicketDTOout();
    t1.setTicketId(ticketId);
    t1.setTitle(ticket.get().getTicketTitle());
    t1.setCreatedBy(ticket.get().getTicketAssignedBy());
    t1.setCreationTime(ticket.get().getTicketCreationTime());
    t1.setUpdationTime(ticket.get().getLastUpdatedTime());
    t1.setTicketStatus(ticket.get().getTicketStatus());
    t1.setTicketType(ticket.get().getTicketType());
    t1.setCreatedBy(ticket.get().getTicketAssignedBy());
    t1.setDepartmentName(ticket.get().getDepartment().getDeptName());
    List<getCommentDTOout> dtoList = convertToDTOList(ticket.get().getComments());
    t1.setComments(dtoList);
    return t1;
}

public List<getCommentDTOout> convertToDTOList(List<Comment> commentList) {
    List<getCommentDTOout> dtoList = new ArrayList<>();

    for (Comment comment : commentList) {
        getCommentDTOout dto = new getCommentDTOout();
        dto.setCommentedByUser(comment.getUser1().getName()); // Assuming there's a method to get the user's name
        dto.setCommentMessage(comment.getCommentMessage());
        dto.setCommentId(comment.getCommentId());
        dtoList.add(dto);
    }

    return dtoList;
}
}

