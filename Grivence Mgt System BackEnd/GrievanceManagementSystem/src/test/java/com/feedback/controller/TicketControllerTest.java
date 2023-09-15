package com.feedback.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.feedback.custom_exception.NullPointerFromFrontendException;
import com.feedback.entities.Comment;
import com.feedback.entities.EStatus;
import com.feedback.entities.Ticket;
import com.feedback.entities.User;
import com.feedback.payloads.comment_dto.getCommentDTOout;
import com.feedback.payloads.ticket_dto.GetTicketsDTOin;
import com.feedback.payloads.ticket_dto.NewTicketDTO;
import com.feedback.payloads.ticket_dto.UpdateTicketDTOin;
import com.feedback.payloads.ticket_dto.getTicketDTOout;
import com.feedback.service.TicketService;

class TicketControllerTest {

//  TicketService ticketService = mock(TicketService.class);
  TicketService ticketService = Mockito.mock(TicketService.class);
  TicketController ticketController = new TicketController();
  
    @Test
    public void testAddTickets() {
      ticketController.ticketService = ticketService;

      // Create a sample NewTicketDTO
      NewTicketDTO newTicketDTO = new NewTicketDTO();
      newTicketDTO.setTicketDescription("Sample Description");

      // Mock the behavior of ticketService.saveTicket()
      when(ticketService.saveTicket(newTicketDTO)).thenReturn(new Ticket());

      // Call the addTickets method
      ResponseEntity<?> responseEntity = ticketController.addTickets(newTicketDTO);

      // Verify that the response entity is not null and has a status of OK
      assertNotNull(responseEntity);
      assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

      // Verify that the message is "Ticket saved Successfully!!!"
      assertEquals("Ticket saved!!!", responseEntity.getBody());
    }

    @Test
    public void testAddTicketsWithNullTicket() {
      // Create an instance of TicketController
      TicketController ticketController = new TicketController();

      // Create a sample NewTicketDTO (null)
      NewTicketDTO newTicketDTO = null;

      // Use assertThrows to verify that a NullPointerFromFrontendException is thrown
      assertThrows(NullPointerFromFrontendException.class, () -> {
        ticketController.addTickets(newTicketDTO);
      });
    }

    @Test
    void testGetTickets() {
        // Prepare input DTO
        ticketController.setTicketService(ticketService);
        GetTicketsDTOin getTicketsDTOin = new GetTicketsDTOin("admin@nucleusteq.com", "IT", "Jagat Naskar");

        getCommentDTOout comment1 = new getCommentDTOout();
        comment1.setCommentId(1);
        comment1.setCommentMessage("Comment 1");

        getCommentDTOout comment2 = new getCommentDTOout();
        comment2.setCommentId(2);
        comment2.setCommentMessage("Comment 2");
        
        List<getCommentDTOout> comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);

        LocalDateTime dummyCreationTime = LocalDateTime.of(2023, 9, 15, 12, 30);
        getTicketDTOout dummyTicket = new getTicketDTOout(
          1L,            // ticketId
          "Ticket Creating",    // title
          dummyCreationTime, // creationTime
          dummyCreationTime, // updationTime
          EStatus.Open,    // ticketStatus
          "Bug",         // ticketType
          "Jagat Naskar",      // createdBy
          "IT Department",   // departmentName
          comments         // comments
        );
        
        List<getTicketDTOout> mockTicketList = new ArrayList<>();
        mockTicketList.add(dummyTicket);
        when(ticketService.getTickets(getTicketsDTOin)).thenReturn(mockTicketList);

        // Call the controller method
        ResponseEntity<?> responseEntity = ticketController.getTickets(getTicketsDTOin);

        // Check the response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockTicketList, responseEntity.getBody());
    }

    @Test
    void testUpdateTicket_Success() {
    	  ticketController.setTicketService(ticketService);
      User user= new User();
       List<Comment> comments = new ArrayList<>();
         comments.add(new Comment(1, "message1", user));

        // Prepare input DTO
        UpdateTicketDTOin updateTicketDTOin = new UpdateTicketDTOin(1L, EStatus.Open, comments);

        // Prepare mock response from service
        when(ticketService.updatingTicket(updateTicketDTOin)).thenReturn(true);

        // Call the controller method
        ResponseEntity<?> responseEntity = ticketController.updateTicket(updateTicketDTOin);

        // Check the response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Ticket Updated.", responseEntity.getBody());
    }

    @Test
    void testUpdateTicket_Failure() {
        // Prepare input DTO
    	  ticketController.setTicketService(ticketService);
      
      User user= new User();
       List<Comment> comments = new ArrayList<>();
         comments.add(new Comment(1, "message1", user));

         // Create a dummy UpdateTicketDTOin object using field constructor
         UpdateTicketDTOin updateTicketDTOin = new UpdateTicketDTOin();
         updateTicketDTOin.setTicketId(1L);
         updateTicketDTOin.setTicketStatus(EStatus.Open);
         updateTicketDTOin.setCommentList(comments);
        // Prepare mock response from service
        when(ticketService.updatingTicket(updateTicketDTOin)).thenReturn(false);

        // Calling controller method
        ResponseEntity<?> responseEntity = ticketController.updateTicket(updateTicketDTOin);

        // Check the response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Could not update your ticket.", responseEntity.getBody());
    }

}
