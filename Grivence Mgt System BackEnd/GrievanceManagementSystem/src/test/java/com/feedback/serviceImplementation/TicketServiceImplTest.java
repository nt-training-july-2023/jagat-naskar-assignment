package com.feedback.serviceImplementation;



//  @Test
//  public void testSaveTicket() {
//    // Create a sample NewTicketDTO
//    NewTicketDTO newTicketDTO = new NewTicketDTO();
//    newTicketDTO.setTicketTitle("Ticket title");
//    newTicketDTO.setTicketType("Feedback");
//    newTicketDTO.setTicketStatus(EStatus.Open);
//    newTicketDTO.setTicketDescription("My Description ...");
//    newTicketDTO.setDeptName("HR");
//    newTicketDTO.setSenderEmail("amFnYXRAbnVjbGV1c3RlcS5jb20=");//jagat@nucleusteq.com
//    
//    Department department = new Department();
//    department.setDeptId(1);
//    department.setDeptName("HR");
//    List<Ticket> ticketList = new ArrayList<>();
//    List<Comment> commentList = new ArrayList<>();
//    User user = new User(
//        1,                  // userId
//        "Jagat Naskar",         // name
//        "amFnYXRAbnVjbGV1c3RlcS5jb20=",          // userName
//        "cGFzc3dvcmQxMjM=",      // password
//        ERole.admin,        // userType
//        true,               // finalPassword
//        ticketList,         // createdTicket
//        commentList,        // comments
//        department          // department
//    );
//
//    Comment comment1 = new Comment();
//    comment1.setCommentId(1);
//    comment1.setCommentMessage("This is a comment.");
//
//    List<Comment> comments = new ArrayList<>();
//    comments.add(comment1);
//
//    LocalDateTime dummyDateTime = LocalDateTime.of(2023, 9, 15, 12, 30);
//    // Create the dummy ticket object
//    Ticket dummyTicket = new Ticket(
//            1L,                         // ticketId
//            "Sample Ticket",            // ticketTitle
//            "Bug",                      // ticketType
//            EStatus.Open,               // ticketStatus
//            "Admin",                    // ticketAssignedBy
//            dummyDateTime,        // ticketCreationTime
//            dummyDateTime,        // lastUpdatedTime
//            "Description of the ticket",// ticketDescription
//            user,                       // createdBy
//            department,                 // assignedDepartment
//            comments                    // comments
//    );
//    when(departmentRepository.findByDeptName("HR")).thenReturn(department);
//    when(userRepository.getUserByUsername(user.getUserName())).thenReturn(user);
//    when(ticketRepository.save(any(Ticket.class))).thenReturn(dummyTicket);
//
//    Ticket savedTicket = ticketService.saveTicket(newTicketDTO);
//
//    assertNotNull(savedTicket);
//  }


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.feedback.custom_exception.TicketNotFoundException;
import com.feedback.custom_exception.UserNotFoundException;
import com.feedback.entities.*;
import com.feedback.payloads.comment_dto.getCommentDTOout;
import com.feedback.payloads.ticket_dto.*;
import com.feedback.repository.*;
import com.feedback.serviceImplementation.TicketServiceImpl;

class TicketServiceImplTest {

    @Mock
    private TicketRepository ticketRepository;
    
    @Mock
    private DepartmentRepository departmentRepository;
    
    @Mock
    private UserRepository userRepository;
    
    @Mock
    private CommentRepository commentRepository;
    
    @InjectMocks
    private TicketServiceImpl ticketService;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    void testUpdatingTicket() {
        // Arrange
        UpdateTicketDTOin updateTicketDTOin = new UpdateTicketDTOin();
        updateTicketDTOin.setTicketId(1L);
        updateTicketDTOin.setTicketStatus(EStatus.Being_Addressed);
        updateTicketDTOin.setCommentList(new ArrayList<>());

        Ticket ticket = new Ticket();
        ticket.setTicketId(1L);
        ticket.setTicketStatus(EStatus.Open);
        ticket.setUser(new User());
        ticket.setDepartment(new Department());

        when(ticketRepository.findById(1L)).thenReturn(Optional.of(ticket));
        when(ticketRepository.save(any(Ticket.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Boolean result = ticketService.updatingTicket(updateTicketDTOin);

        // Assert
        assertTrue(result);
        assertEquals(EStatus.Being_Addressed, ticket.getTicketStatus());
        assertEquals(0, ticket.getComments().size());
    }
    
    
    


    
    
    
    
    
    
    
    
    
    
    @Test
    void testSaveTicket() {
        // Arrange
        NewTicketDTO newTicketDTO = new NewTicketDTO();
        newTicketDTO.setTicketId(1L);
        newTicketDTO.setTicketTitle("Test Ticket");
        newTicketDTO.setTicketType("Test Type");
        newTicketDTO.setTicketStatus(EStatus.Open);
        newTicketDTO.setTicketDescription("Test Description");
        newTicketDTO.setDeptName("HR");
        newTicketDTO.setSenderEmail("amFnYXRAbnVjbGV1c3Rlc3EuY29t"); // jagat@nucleusteq.com

        LocalDateTime currentDateTime = LocalDateTime.of(2023, 9, 15, 12, 30);

        Department department = new Department();
        department.setDeptId(1);
        department.setDeptName("HR");

        User user = new User();
        user.setName("jagat");
        user.setUserName("amFnYXRAbnVjbGV1c3Rlc3EuY29t");

        when(departmentRepository.findByDeptName("Test Department")).thenReturn(department);
        when(userRepository.existsByUserName("jagat@nucleustesq.com")).thenReturn(true);
        when(userRepository.getUserByUsername("jagat@nucleustesq.com")).thenReturn(user);

        // Act
        Ticket savedTicket = ticketService.saveTicket(newTicketDTO);

        // Assert
        assertNotNull(savedTicket);
        assertEquals("Test Ticket", savedTicket.getTicketTitle());
        assertEquals("Test Type", savedTicket.getTicketType());
        assertEquals(EStatus.Open, savedTicket.getTicketStatus());
        assertEquals("Test Description", savedTicket.getTicketDescription());
        assertEquals("Test Department", savedTicket.getDepartment().getDeptName());
        assertEquals("jagat", savedTicket.getTicketAssignedBy());
        assertNotNull(savedTicket.getTicketCreationTime());
        assertNotNull(savedTicket.getLastUpdatedTime());
    }

//    @Test
//    void testSaveTicketUserNotFound() {
//        // Arrange
//        NewTicketDTO newTicketDTO = new NewTicketDTO();
//        newTicketDTO.setSenderEmail("nonexistentuser@example.com");
//
//        when(userRepository.existsByUserName("nonexistentuser@example.com")).thenReturn(false);
//
//        // Act and Assert
//        assertThrows(UserNotFoundException.class, () -> {
//            ticketService.saveTicket(newTicketDTO);
//        });
//    }
  
}

