package com.feedback.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DepartmentTest {

  @Test
  void testToString() {
    Department department = new Department(1, "HR");
    String expected = "Department [deptId=1, deptName=HR]";
    String actual = department.toString();
    assertEquals(expected, actual);
  }

  @Test
  void testGetDeptId() {
    Department department = new Department(2, "IT");
    assertEquals(2, department.getDeptId());
  }

  @Test
  void testSetDeptId() {
    Department department = new Department();
    department.setDeptId(3);
    assertEquals(3, department.getDeptId());
  }

  @Test
  void testGetDeptName() {
    Department department = new Department(4, "Finance");
    assertEquals("Finance", department.getDeptName());
  }

  @Test
  void testSetDeptName() {
    Department department = new Department();
    department.setDeptName("Marketing");
    assertEquals("Marketing", department.getDeptName());
  }

  @Test
  void testDepartmentIntString() {
    Department department = new Department(5, "Sales");
    assertEquals(5, department.getDeptId());
    assertEquals("Sales", department.getDeptName());
  }

  /**
   * checking no constructor, defines the id = 0 or not.
   */
  @Test
  void testDepartment() {
    Department department = new Department();
    assertNull(department.getDeptName());
    assertEquals(0, department.getDeptId());
  }
}
