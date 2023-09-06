package com.feedback.serviceImplementation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.feedback.entities.Department;
import com.feedback.payloads.department_dto.AddDepartemntDTO;
import com.feedback.repository.DepartmentRepository;;

@TestInstance(Lifecycle.PER_CLASS)
class DepartmentServiceImplTest {

  @InjectMocks
  private DepartmentServiceImpl departmentService;

  @Mock
  private DepartmentRepository departmentRepository;

  @BeforeAll
  public void setUp() {
    // Initialize Mockito annotations
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testCheckAlreadyExist_DepartmentExists() {
    // Create a valid AddDepartemntDTO object
    AddDepartemntDTO validDepartmentDTO = new AddDepartemntDTO("HR");

    // Mock the behavior of the repository to return a Department object (department already exists)
    when(departmentRepository.findByDeptName("HR")).thenReturn(new Department());

    // Call the service method
    boolean result = departmentService.checkAlreadyExist(validDepartmentDTO);

    // Assert that the result is true since the department already exists
    assertTrue(result);
  }

  @Test
  public void testCheckAlreadyExist_DepartmentDoesNotExist() {
    // Create a valid AddDepartemntDTO object
    AddDepartemntDTO validDepartmentDTO = new AddDepartemntDTO("IT");

    // Mock the behavior of the repository to return null (department does not exist)
    when(departmentRepository.findByDeptName("IT")).thenReturn(null);

    // Call the service method
    boolean result = departmentService.checkAlreadyExist(validDepartmentDTO);

    // Assert that the result is false since the department does not exist
    assertFalse(result);
  }

  @Test
  public void testAddDept_Success() {
    // Create a valid AddDepartemntDTO object
    AddDepartemntDTO validDepartmentDTO = new AddDepartemntDTO("IT");

    // Mock the behavior of the repository to return a Department object after saving
    Department savedDepartment = new Department();
    savedDepartment.setDeptId(1);
    savedDepartment.setDeptName("IT");
    when(departmentRepository.save(any(Department.class))).thenReturn(savedDepartment);

    // Call the service method
    Department result = departmentService.addDept(validDepartmentDTO);

    // Assert that the result is the saved department object
    assertNotNull(result);
    assertEquals("IT", result.getDeptName());
  }
}
