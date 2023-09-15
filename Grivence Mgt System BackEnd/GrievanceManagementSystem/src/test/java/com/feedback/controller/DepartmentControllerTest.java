package com.feedback.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.feedback.entities.Department;
import com.feedback.payloads.department_dto.AddDepartemntDTO;
import com.feedback.payloads.department_dto.DepartmentListDTO;
import com.feedback.service.DepartmentService;

class DepartmentControllerTest {

    DepartmentService departmentService = Mockito.mock(DepartmentService.class);
    DepartmentController departmentController = new DepartmentController();

//    @Test
//    void testAddDept_Success() {
//        // Create a sample AddDepartemntDTO
//    	AddDepartemntDTO departmentDTO = new AddDepartemntDTO();
//        departmentDTO.setDeptName("HR");
//        Department department = new Department(1, "HR");
//        // Mock the behavior of departmentService.checkAlreadyExist() and departmentService.addDept()
//        when(departmentService.checkAlreadyExist(departmentDTO)).thenReturn(false);
//        when(departmentService.addDept(departmentDTO)).thenReturn(department);
//
//        // Call the addDept method
//        ResponseEntity<?> responseEntity = departmentController.addDept(departmentDTO);
//
//        // Verify that the response entity is not null and has a status of OK
//        assertNotNull(responseEntity);
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//
//        // Verify that the message is "Department {deptName} saved successfully!!!"
//        assertEquals("Department Sample Department saved successfully!!!", responseEntity.getBody());
//    }

    @Test
    void testAddDept_AlreadyExists() {
        // Create a sample AddDepartemntDTO
        AddDepartemntDTO departmentDTO = new AddDepartemntDTO();
        departmentDTO.setDeptName("Sample Department");

        // Mock the behavior of departmentService.checkAlreadyExist() to return true
        when(departmentService.checkAlreadyExist(departmentDTO)).thenReturn(true);

        // Call the addDept method
        ResponseEntity<?> responseEntity = departmentController.addDept(departmentDTO);

        // Verify that the response entity is not null and has a status of OK
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Verify that the message is "Department already exists"
        assertEquals("Department already exists", responseEntity.getBody());
    }

    @Test
    void testAddDept_DatabaseError() {
        // Create a sample AddDepartemntDTO
        AddDepartemntDTO departmentDTO = new AddDepartemntDTO();
        departmentDTO.setDeptName("Sample Department");

        // Mock the behavior of departmentService.checkAlreadyExist() and departmentService.addDept()
        when(departmentService.checkAlreadyExist(departmentDTO)).thenReturn(false);
        when(departmentService.addDept(departmentDTO)).thenReturn(null);

        // Call the addDept method
        ResponseEntity<?> responseEntity = departmentController.addDept(departmentDTO);

        // Verify that the response entity is not null and has a status of INTERNAL_SERVER_ERROR
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());

        // Verify the error message
        assertEquals("Problem saving in the database: Database save problem", responseEntity.getBody());
    }

    @Test
    void testGetAllDepartments() {
        // Create a sample DepartmentListDTO
        DepartmentListDTO departmentListDTO = new DepartmentListDTO();
        departmentListDTO.setDeptId(1);
        departmentListDTO.setDeptName("Sample Department");

        List<DepartmentListDTO> departmentList = new ArrayList<>();
        departmentList.add(departmentListDTO);

        // Mock the behavior of departmentService.getAllDepartments()
        when(departmentService.getAllDepartments()).thenReturn(departmentList);

        // Call the getAllDepartments method
        ResponseEntity<List<DepartmentListDTO>> responseEntity = departmentController.getAllDepartments();

        // Verify that the response entity is not null and has a status of OK
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Verify the list of DepartmentListDTOs
        assertEquals(departmentList, responseEntity.getBody());
    }

    @Test
    void testGetAllDepartments_NoContent() {
        // Mock the behavior of departmentService.getAllDepartments() to return an empty list
        when(departmentService.getAllDepartments()).thenReturn(new ArrayList<>());

        // Call the getAllDepartments method
        ResponseEntity<List<DepartmentListDTO>> responseEntity = departmentController.getAllDepartments();

        // Verify that the response entity has a status of NO_CONTENT
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }
}