package com.feedback.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.feedback.entities.Department;
import com.feedback.payloads.department_dto.AddDepartemntDTO;
import com.feedback.service.DepartmentService;

@TestInstance(Lifecycle.PER_CLASS)
class DepartmentControllerTest {
	@InjectMocks
  private DepartmentController departmentController;

  @Mock
  private DepartmentService departmentService;

  @BeforeAll
  public void setUp() {
  // Initialize Mockito annotations
  MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testAddDept_DepartmentAlreadyExists() {
    // Create a valid AddDepartemntDTO object
    AddDepartemntDTO validDepartmentDTO = new AddDepartemntDTO("HR");

    // Mock the behavior of the service methods
    when(departmentService.checkAlreadyExist(validDepartmentDTO)).thenReturn(true);

    // Call the controller method
    ResponseEntity<?> response = departmentController.addDept(validDepartmentDTO);

    // Assertions
    verify(departmentService, times(1)).checkAlreadyExist(validDepartmentDTO);
    verify(departmentService, never()).addDept(validDepartmentDTO); // Ensure addDept is never called
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("Department already exists", response.getBody());
  }

  @Test
  public void testAddDept_Success() {
    // Create a valid AddDepartemntDTO object
    AddDepartemntDTO validDepartmentDTO = new AddDepartemntDTO("IT");
    Department d1 = new Department();
    d1.setDeptId(1);
    d1.setDeptName("IT");

    // Mock the behavior of the service methods
    when(departmentService.checkAlreadyExist(validDepartmentDTO)).thenReturn(false);
    when(departmentService.addDept(validDepartmentDTO)).thenReturn(d1);

    // Call the controller method
    ResponseEntity<?> response = departmentController.addDept(validDepartmentDTO);

    // Assertions
    verify(departmentService, times(1)).checkAlreadyExist(validDepartmentDTO);
    verify(departmentService, times(1)).addDept(validDepartmentDTO);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("Department IT saved successfully!!!", response.getBody());
  }

  @Test
  public void testAddDept_DatabaseSaveProblem() {
  // Create a valid AddDepartemntDTO object
  AddDepartemntDTO validDepartmentDTO = new AddDepartemntDTO("IT");

  // Mock the behavior of the service methods to simulate a database save problem
  when(departmentService.checkAlreadyExist(validDepartmentDTO)).thenReturn(false);
  when(departmentService.addDept(validDepartmentDTO)).thenThrow(new RuntimeException("Database save problem"));

  // Call the controller method
  ResponseEntity<?> response = departmentController.addDept(validDepartmentDTO);

  // Assertions
  verify(departmentService, times(2)).checkAlreadyExist(validDepartmentDTO);
  verify(departmentService, times(2)).addDept(validDepartmentDTO);
  assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
  assertEquals("Problem saving in the database: Database save problem", response.getBody());
  }
}
