package com.feedback.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feedback.entities.Department;
import com.feedback.payloads.department_dto.AddDepartemntDTO;
import com.feedback.payloads.department_dto.DepartmentListDTO;
import com.feedback.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    @Test
    void addDept() throws Exception {
        // Mocking the service method
        when(departmentService.checkAlreadyExist(any(AddDepartemntDTO.class))).thenReturn(false);
        when(departmentService.addDept(any(AddDepartemntDTO.class))).thenReturn(new Department());

        // Create request content
        AddDepartemntDTO inputDTO = new AddDepartemntDTO();
        inputDTO.setDeptName("Test Department");
        String requestContent = new ObjectMapper().writeValueAsString(inputDTO);

        // Perform the request
        mockMvc.perform(post("/api/dept/addDept")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestContent))
                .andExpect(status().isOk())
                .andExpect(content().string("Department Test Department saved successfully!!!"));
    }

    @Test
    void getAllDepartments() throws Exception {
        // Mocking the service method
        List<DepartmentListDTO> departmentList = new ArrayList<>();
        departmentList.add(new DepartmentListDTO());
        when(departmentService.getAllDepartments()).thenReturn(departmentList);

        // Perform the request
        mockMvc.perform(get("/api/dept/allDepartment"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }
}