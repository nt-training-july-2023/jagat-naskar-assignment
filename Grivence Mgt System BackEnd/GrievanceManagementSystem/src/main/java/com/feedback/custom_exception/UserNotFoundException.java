package com.feedback.custom_exception;

public class UserNotFoundException extends RuntimeException {

/**
 * serialId of DepartmentNotFoundException.
 */private static final long serialVersionUID=1L;

public UserNotFoundException(String userName) {
        super("User not found with name: " + userName);
    }

public UserNotFoundException(int userId) {
    super("User not found with id: " + userId);
}
}
