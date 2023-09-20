package com.feedback.controller;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.feedback.entities.Department;
import com.feedback.payloads.department_dto.AddDepartemntDTO;
import com.feedback.payloads.department_dto.DepartmentListDTO;
import com.feedback.service.DepartmentService;

class DepartmentControllerTest {
 @Test
    void testAddDept() {
        // Arrange
        DepartmentService departmentService = mock(DepartmentService.class);
        DepartmentController departmentController = new DepartmentController(departmentService);

        AddDepartemntDTO deptDTO = new AddDepartemntDTO();
        deptDTO.setDeptName("HR");
        Department department = new Department(1, "HR");

        when(departmentService.checkAlreadyExist(deptDTO)).thenReturn(false);
        when(departmentService.addDept(deptDTO)).thenReturn(department);

        // Act
        ResponseEntity<?> responseEntity = departmentController.addDept(deptDTO);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Department HRsaved successfully!!!", responseEntity.getBody());
    }

    @Test
    void testGetAllDepartments() {
        // Arrange
        DepartmentService departmentService = mock(DepartmentService.class);
        DepartmentController departmentController = new DepartmentController(departmentService);

        List<DepartmentListDTO> departmentList = new ArrayList<>();
        departmentList.add(new DepartmentListDTO(1, "TestDept"));

        when(departmentService.getAllDepartments()).thenReturn(departmentList);

        // Act
        ResponseEntity<List<DepartmentListDTO>> responseEntity = departmentController.getAllDepartments();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(departmentList, responseEntity.getBody());
    }

    @Test
    void testDeleteDeptByName() {
        // Arrange
        DepartmentService departmentService = mock(DepartmentService.class);
        DepartmentController departmentController = new DepartmentController(departmentService);

        when(departmentService.deleteDept("TestDept")).thenReturn("Deleted Successfully");

        // Act
        ResponseEntity<?> responseEntity = departmentController.deleteDeptByName("TestDept");

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Deleted Successfully", responseEntity.getBody());
    }
    
    @Test
    void testAddDeptDepartmentAlreadyExists() {
        // Arrange
        DepartmentService departmentService = mock(DepartmentService.class);
        DepartmentController departmentController = new DepartmentController(departmentService);

        AddDepartemntDTO deptDTO = new AddDepartemntDTO();
        deptDTO.setDeptName("TestDept");

        when(departmentService.checkAlreadyExist(deptDTO)).thenReturn(true);

        // Act
        ResponseEntity<?> responseEntity = departmentController.addDept(deptDTO);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Department already exists", responseEntity.getBody());
    }

    @Test
    void testAddDeptDatabaseError() {
        // Arrange
        DepartmentService departmentService = mock(DepartmentService.class);
        DepartmentController departmentController = new DepartmentController(departmentService);

        AddDepartemntDTO deptDTO = new AddDepartemntDTO();
        deptDTO.setDeptName("TestDept");

        when(departmentService.checkAlreadyExist(deptDTO)).thenReturn(false);
        when(departmentService.addDept(deptDTO)).thenReturn(null);

        // Act
        ResponseEntity<?> responseEntity = departmentController.addDept(deptDTO);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("Problem saving in the database: Database save problem", responseEntity.getBody());
    }
}