package com.feedback.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.payloads.department_dto.AddDepartemntDTO;
import com.feedback.payloads.department_dto.DepartmentListDTO;
import com.feedback.service.DepartmentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/dept")
public class DepartmentController {

  private static final Logger logger = LogManager.getLogger(DepartmentController.class);
  
  
  @Autowired
  DepartmentService departmentService;

  @PostMapping("/addDept")
  public ResponseEntity<?> addDept(@Valid @RequestBody final AddDepartemntDTO dept1) {
    try {
        if (departmentService.checkAlreadyExist(dept1)) {
          String message = "Department already exists";
          return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        if (departmentService.addDept(dept1) == null) {
          throw new RuntimeException("Database save problem");
        }
        
        String message = "Department " + dept1.getDeptName() + " saved successfully!!!";
        return ResponseEntity.status(HttpStatus.OK).body(message);
    } catch (Exception e) {
        String errorMessage = "Problem saving in the database: " + e.getMessage();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }
  }
  
  @GetMapping("/allDepartment")
  public ResponseEntity<List<DepartmentListDTO>> getAllDepartments() {
    List<DepartmentListDTO> departmentList = departmentService.getAllDepartments();
    if (!departmentList.isEmpty()) {
        return ResponseEntity.ok(departmentList);
    } else {
        return ResponseEntity.noContent().build();
    }
  }
}

