package com.feedback.payloads.department_dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddDepartemntDTOTest {

  private AddDepartemntDTO departmentDTO;

  @BeforeEach
  public void setUp() {
    departmentDTO = new AddDepartemntDTO();
  }

  @Test
  public void testDefaultConstructor() {
    assertNull(departmentDTO.getDeptName());
  }

  @Test
  public void testParameterizedConstructor() {
    AddDepartemntDTO departmentDTO = new AddDepartemntDTO("HR");

    assertEquals("HR", departmentDTO.getDeptName());
  }

  @Test
  public void testSettersAndGetters() {
    departmentDTO.setDeptName("Finance");

    assertEquals("Finance", departmentDTO.getDeptName());
  }

  @Test
  public void testEqualsAndHashCode() {
    AddDepartemntDTO departmentDTO1 = new AddDepartemntDTO("IT");
    AddDepartemntDTO departmentDTO2 = new AddDepartemntDTO("IT");
    AddDepartemntDTO departmentDTO3 = new AddDepartemntDTO("Finance");

    assertEquals(departmentDTO1, departmentDTO2);
    assertNotEquals(departmentDTO1, departmentDTO3);

    assertEquals(departmentDTO1.hashCode(), departmentDTO2.hashCode());
    assertNotEquals(departmentDTO1.hashCode(), departmentDTO3.hashCode());
  }

  @Test
  public void testToString() {
    AddDepartemntDTO departmentDTO = new AddDepartemntDTO("Marketing");
    String expectedToString = "AddDepartemntDTO [deptName=Marketing]";
    assertEquals(expectedToString, departmentDTO.toString());
  }

}
