package com.feedback.custom_exception;




public class ResourceNotFoundException extends RuntimeException {

    /**
 * 
 */private static final long serialVersionUID=1L;
    String resourceName;
    String FieldName;
    Long fieldValue;

    public ResourceNotFoundException(final String resourceName, final String fieldName, final long fieldValue) {
        super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        FieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}