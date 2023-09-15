package com.feedback.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feedback.entities.Comment;
import com.feedback.entities.Department;
import com.feedback.entities.ERole;
import com.feedback.entities.EStatus;
import com.feedback.entities.Ticket;
import com.feedback.entities.User;
import com.feedback.payloads.user_dto.AddUserDto;
import com.feedback.payloads.user_dto.LoginDTO;
import com.feedback.payloads.user_dto.PasswordChangeDTOin;
import com.feedback.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddUser_Success() {
        AddUserDto validUser = new AddUserDto("Admin", "admin@nucleusteq.com", "Admin@123", ERole.admin, "Sales");


        User user = new User();

        user.setUserId(1);
        user.setName("John Doe");
        user.setUserName("john.doe@example.com");
        user.setPassword("password123");
        user.setUserType(ERole.admin);
        user.setfinalPassword(true);

        Department department = new Department();
        department.setDeptId(1);
        department.setDeptName("IT");
        user.setDepartment(department);

        Ticket ticket1 = new Ticket();
        ticket1.setTicketId(1L);
        ticket1.setTicketTitle("Issue 1");
        ticket1.setTicketStatus(EStatus.Open);
        ticket1.setCreatedBy(user);
        
        Ticket ticket2 = new Ticket();
        ticket2.setTicketId(2L);
        ticket2.setTicketTitle("Issue 2");
        ticket2.setTicketStatus(EStatus.Being_Addressed);
        ticket2.setCreatedBy(user);

        List<Ticket> ticketList = Arrays.asList(ticket1, ticket2);
        user.setTicketList(ticketList);

        Comment comment1 = new Comment();
        comment1.setCommentId(1);
        comment1.setCommentMessage("Comment 1");
        comment1.setUser1(user);
        
        Comment comment2 = new Comment();
        comment2.setCommentId(2);
        comment2.setCommentMessage("Comment 2");
        comment2.setUser1(user);

        List<Comment> commentList = Arrays.asList(comment1, comment2);
        user.setCommentList(commentList);
        
        
        
        
        
        
        

        when(userService.checkAlreadyExist(any())).thenReturn(false);
        when(userService.saveUser(any())).thenReturn(user);

        ResponseEntity<?> response = userController.addUser(validUser);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("User saved!!!", response.getBody());
    }

    @Test
    public void testAddUser_Failure_AlreadyExist() {
        AddUserDto existingUser = new AddUserDto("Admin", "admin@nucleusteq.com", "Admin@123", ERole.admin, "Sales");

        when(userService.checkAlreadyExist(any())).thenReturn(true);

        ResponseEntity<?> response = userController.addUser(existingUser);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("UserName(email) already exist!!!", response.getBody());
    }

    @Test
    public void testAddUser_Failure_InvalidData() {
        AddUserDto invalidUser = new AddUserDto("Virus", "virus@nucleusteq.com", "Virus@123", ERole.admin, "Sales");

        ResponseEntity<?> response = userController.addUser(invalidUser);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("", response.getBody());
    }

    @Test
    public void testChangePassword_Success() throws Exception {
        PasswordChangeDTOin validPasswordChange = new PasswordChangeDTOin("admin@nucleusteq.com", "oldPassword", "newPassword", "newPassword");

        when(userService.passwordChangedSuccess(any())).thenReturn("Password changed successfully!");

        ResponseEntity<String> response = userController.changePassword(validPasswordChange);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Password changed successfully!", response.getBody());
    }

    @Test
    public void testChangePassword_Failure() throws Exception {
        PasswordChangeDTOin invalidPasswordChange = new PasswordChangeDTOin("admin@nucleusteq.com", "oldPassword", "newPassword", "confirmPassword");

        when(userService.passwordChangedSuccess(any())).thenAnswer(invocation -> {
            throw new Exception("Password change failed");
        });

        ResponseEntity<String> response = userController.changePassword(invalidPasswordChange);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("An error occurred while changing the password.", response.getBody());
    }

    
    
    
    
    
    
    
    
    @Test
    public void testGetByUserPassword_Success() {
        LoginDTO validLogin = new LoginDTO("YWRtaW5AbnVjbGV1c3RlcS5jb20=", "QWRtaW5AMTIz");//admin@nu..., Admin@123

        when(userService.getByUserAndPassword(any(), any())).thenReturn("Role");

        ResponseEntity<?> response = userController.getByUserPassword(validLogin);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Role", response.getBody());
    }



}