package com.feedback.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.payloads.DepartmentDTO.AddDepartemntDTO;
import com.feedback.service.DepartmentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/dept")
public class DepartmentController {
  @Autowired
  DepartmentService departmentService;
  @PostMapping("/addDept")
  public ResponseEntity<?> addDept(@Valid @RequestBody final AddDepartemntDTO dept1) {
    System.out.println("____________________________________");
    System.out.println("Controller, DeptDTo = "+dept1);
    String message = "";
    System.out.println("con1");
    if(departmentService.checkAlreadyExist(dept1) == true) {
    	System.out.println("con2");
       message = "Department already exist";
       System.out.println("con3");
       return ResponseEntity.status(HttpStatus.OK).body(message);
    }
    System.out.println("con4");
    if(departmentService.addDept(dept1) == null) {
    	System.out.println("con5");
      throw new NullPointerException("Problem saving in the database");
      
    }
    System.out.println("con6");
    message = "Department "+dept1.getDeptName()+" saved sucessfully!!!";
    return ResponseEntity.status(HttpStatus.OK).body(message);
  }
}
