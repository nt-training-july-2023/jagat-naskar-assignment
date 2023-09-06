package com.feedback.custom_exception;

public class AlreadyExistExcepton extends RuntimeException {

/**
 * 
 */private static final long serialVersionUID=1L;
  
  public AlreadyExistExcepton() {
     super("Already exist");
 }
  public AlreadyExistExcepton(Long id) {
	     super(id+" Already exist");
	 }
  public AlreadyExistExcepton(String name) {
	     super(name +" Already exist");
	 }
}

