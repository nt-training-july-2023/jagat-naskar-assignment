package com.feedback.service;

import com.feedback.entities.Department;
import com.feedback.payloads.department_dto.AddDepartemntDTO;

public interface DepartmentService {

  public boolean checkAlreadyExist(AddDepartemntDTO dept1);
  public Department addDept(AddDepartemntDTO dept);
}
