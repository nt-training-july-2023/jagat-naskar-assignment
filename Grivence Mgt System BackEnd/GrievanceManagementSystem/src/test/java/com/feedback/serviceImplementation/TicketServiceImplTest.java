package com.feedback.serviceImplementation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.feedback.entities.Department;
import com.feedback.entities.EStatus;
import com.feedback.entities.Ticket;
import com.feedback.entities.User;
import com.feedback.payloads.ticket_dto.NewTicketDTO;
import com.feedback.repository.DepartmentRepository;
import com.feedback.repository.TicketRepository;
import com.feedback.repository.UserRepository;

class TicketServiceImplTest {

  @Mock
  private TicketRepository ticketRepository;

  @Mock
  private DepartmentRepository departmentRepository;

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private TicketServiceImpl ticketService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testSaveTicket() {
    // Create a sample NewTicketDTO
    NewTicketDTO newTicketDTO = new NewTicketDTO();
    newTicketDTO.setTicketTitle("Sample Ticket");
    newTicketDTO.setTicketType("Sample Type");
    newTicketDTO.setTicketStatus(EStatus.Open);
    newTicketDTO.setTicketDescription("Sample Description");
    newTicketDTO.setDeptName("Sample Department");
    newTicketDTO.setSenderEmail("sample@example.com");

    when(departmentRepository.findByDeptName("Sample Department")).thenReturn(new Department());
    when(userRepository.getUserByUsername("sample@example.com")).thenReturn(new User());
    when(ticketRepository.save(any(Ticket.class))).thenReturn(new Ticket());

    Ticket savedTicket = ticketService.saveTicket(newTicketDTO);

    assertNotNull(savedTicket);
  }

}