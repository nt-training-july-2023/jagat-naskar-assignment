package com.feedback.entities;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ERoleConverter implements AttributeConverter<ERole, String> {

    @Override
    public String convertToDatabaseColumn(ERole role) {
        return role.toString(); // Convert the enum to its string representation
    }

    @Override
    public ERole convertToEntityAttribute(String roleString) {
        return ERole.valueOf(roleString); // Convert the string back to the enum
    }
}