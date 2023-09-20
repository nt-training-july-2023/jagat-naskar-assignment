package com.feedback.serviceImplementation;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.custom_exception.DepartmentNotFoundException;
import com.feedback.custom_exception.UserNotFoundException;
import com.feedback.entities.Department;
import com.feedback.payloads.department_dto.AddDepartemntDTO;
import com.feedback.payloads.department_dto.DepartmentListDTO;
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

  @Override
  public List<DepartmentListDTO> getAllDepartments() {
    System.out.println("getting All Department using Effect");
    List<Department> departments = departmentRepository.findAll();
    return departments.stream()
        .map(department -> {
          DepartmentListDTO deptDTO = new DepartmentListDTO();
        deptDTO.setDeptId(department.getDeptId());
        deptDTO.setDeptName(department.getDeptName());
        return deptDTO;
          })
          .collect(Collectors.toList());
  }

@Override
public String deleteDept(String deptName) {
	Department d1 = departmentRepository.findByDeptName(deptName);
	if(d1 != null)
    {
        departmentRepository.deleteById(d1.getDeptId());
        return "Deleted Successfully";
    }
    else throw new DepartmentNotFoundException(deptName);
}
}

