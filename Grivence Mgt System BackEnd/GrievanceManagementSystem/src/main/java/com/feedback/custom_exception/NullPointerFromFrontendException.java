package com.feedback.custom_exception;

public class NullPointerFromFrontendException extends RuntimeException {
  /**
   *
   */private static final long serialVersionUID = 1L;

  public NullPointerFromFrontendException() {
    super("Already exist");
  }

  public NullPointerFromFrontendException(Long id) {
    super("Object id =" + id + " from frontend returns null.");
  }

  public NullPointerFromFrontendException(String name) {
    super(name + " object from frontend returns null");
  }
  
  public NullPointerFromFrontendException(Object name) {
	     super(name +" object from frontend returns null");
	 }
}
