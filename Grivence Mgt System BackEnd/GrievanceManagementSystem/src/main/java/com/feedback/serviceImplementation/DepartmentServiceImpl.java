package com.feedback.serviceImplementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.entities.Department;
import com.feedback.payloads.DepartmentDTO.AddDepartemntDTO;
import com.feedback.repository.DepartmentRepository;
import com.feedback.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

  @Autowired
  DepartmentRepository departmentRepository;
  /**
   * check if the Already department exist or not.
  */
  public boolean checkAlreadyExist(AddDepartemntDTO dept1) {
    Department d1 = new Department();
    d1.setDeptName(dept1.getDeptName());
    System.out.println("Already "+departmentRepository.findByDeptName(d1.getDeptName()));
    if(departmentRepository.findByDeptName(d1.getDeptName()) != null) {
      return true;
    }
    return false;
  }
  
  /**
   * adding new Department in the database.
   * @return dept, saved department object.
   */
  public Department addDept(AddDepartemntDTO dept) {
  System.out.println("SERvice1 --> ");
    Department d1 = new Department();
    System.out.println("SERvice2 --> ");
    d1.setDeptName(dept.getDeptName());
    System.out.println("SERvice3 --> ");
    
    return departmentRepository.save(d1);
  }
}
