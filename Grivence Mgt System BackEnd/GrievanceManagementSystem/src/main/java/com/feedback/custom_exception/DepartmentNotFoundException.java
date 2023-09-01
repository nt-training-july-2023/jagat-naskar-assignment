package com.feedback.custom_exception;

public class DepartmentNotFoundException extends RuntimeException {

/**
 * serialId of DepartmentNotFoundException.
 */private static final long serialVersionUID=1L;

public DepartmentNotFoundException(String departmentName) {
        super("Department not found with name: " + departmentName);
    }
}