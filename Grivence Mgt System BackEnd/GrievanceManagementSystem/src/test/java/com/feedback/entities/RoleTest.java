package com.feedback.entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RoleTest {

  @Test
  void testRole() {
    Role role = new Role();
    assertNotNull(role);
  }

  @Test
  void testRoleERole() {
    Role role = new Role(ERole.admin);
    assertEquals(ERole.admin, role.getName());
  }

  @Test
  void testGetId() {
    Role role = new Role();
    role.setId(1);
    assertEquals(1, role.getId());
  }

  @Test
  void testSetId() {
    Role role = new Role();
    role.setId(2);
    assertEquals(2, role.getId());
  }

  @Test
  void testGetName() {
    Role role = new Role();
    role.setName(ERole.member);
    assertEquals(ERole.member, role.getName());
  }

  @Test
  void testSetName() {
    Role role = new Role();
    role.setName(ERole.admin);
    assertEquals(ERole.admin, role.getName());
  }
}
