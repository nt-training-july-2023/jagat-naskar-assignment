package com.feedback.custom_exception;

public class PasswordChangeException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PasswordChangeException(String message) {
        super(message);
    }
}