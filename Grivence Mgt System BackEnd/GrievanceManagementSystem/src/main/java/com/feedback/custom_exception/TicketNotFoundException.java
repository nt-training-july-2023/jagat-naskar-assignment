package com.feedback.custom_exception;

public class TicketNotFoundException extends RuntimeException {

	/**
	 * serialId of DepartmentNotFoundException.
	 */private static final long serialVersionUID=1L;
	
	public TicketNotFoundException(String notFound) {
	        super(notFound);
	    }
	
	public TicketNotFoundException(int userId) {
	    super("Ticket not found with id: " + userId);
	}

}
