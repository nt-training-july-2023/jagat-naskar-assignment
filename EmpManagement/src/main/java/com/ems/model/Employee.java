package com.ems.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "EmployeeTable")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int empId;
	@Column(name = "empName")
	private String nameString;
	@Column(name = "empSalary")
	private double salary;
	@Column(name = "empEmail")
	private String emailString;
	@Column(name = "empAge")
	private int age;

	public Employee(int empId, String nameString, double salary, String emailString) {
		super();
		this.empId = empId;
		this.nameString = nameString;
		this.salary = salary;
		this.emailString = emailString;
	}

	public Employee(int empId, String nameString, double salary, String emailString, int age) {
		super();
		this.empId = empId;
		this.nameString = nameString;
		this.salary = salary;
		this.emailString = emailString;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", nameString=" + nameString + ", salary=" + salary + ", emailString="
				+ emailString + "]";
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmailString() {
		return emailString;
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}
}
