package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dao.Dao;
import com.ems.model.Employee;

@RestController
public class EmployeeRestCont {
	@Autowired
	Dao repo;
	/**
	 * adding an employee
	 * @param Employee e from Body
	 * @return employee e's details
	 */
	@PostMapping("/addEmployee")
	public void addEmployee(@RequestBody Employee emp) {
		repo.save(emp);
	}
	
	/**
	 * adding list of employees
	 * @param List of Employee from Body
	 * @return List of employee which are currently added to the database
	 */
	@PostMapping("/addListEmployee")
	public void addListEmployee(@RequestBody List<Employee> list) {
		for(Employee e: list)
			repo.save(e);
		
	}
	//List<Employee>
	//return (List<Employee>) ResponseEntity.ok(list);
	/**
	 * get an employee by its id
	 * @param id
	 * @return employee's details
	 */
	@GetMapping("/getEmployee")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
		Employee employee = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(employee);
	}
	

	/**
	 * getting all the employees
	 * @return list of all employees
	 */
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(){
		return repo.findAll();
	}
	
	/**
	 * updating an employee details by getting it, by emp's id
	 * @param id
	 * @return updated employee
	 */
	@PutMapping("/updateEmployees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee e){
		Employee employee = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employee.setSalary(e.getSalary());
		employee.setNameString(e.getNameString());
		employee.setEmpId(e.getEmpId());
		employee.setAge(e.getAge());
		
		Employee updatedEmployee = repo.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	/**
	 * Delete a employee with its id
	 * @param id
	 * @return deleted employee
	 */
	@DeleteMapping("/deleteEmp/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable Integer id)
	{
		Employee e = repo.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee not found with emp no: "+id));
		//Employee e1 = e1;
		repo.delete(e);
		return ResponseEntity.ok(e);
	}
	
	
	
}
