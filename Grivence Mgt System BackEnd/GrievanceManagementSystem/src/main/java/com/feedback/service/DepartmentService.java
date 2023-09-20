package com.feedback.service;

import java.util.List;

import com.feedback.entities.Department;
import com.feedback.payloads.department_dto.AddDepartemntDTO;
import com.feedback.payloads.department_dto.DepartmentListDTO;

public interface DepartmentService {

  public boolean checkAlreadyExist(AddDepartemntDTO dept1);
  public Department addDept(AddDepartemntDTO dept);
  List<DepartmentListDTO> getAllDepartments();
  String deleteDept(String deptName);
}
