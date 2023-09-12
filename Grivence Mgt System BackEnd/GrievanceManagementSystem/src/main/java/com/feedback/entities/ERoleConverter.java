package com.feedback.entities;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ERoleConverter implements AttributeConverter<ERole, String> {

    @Override
    public String convertToDatabaseColumn(ERole role) {
        if (role == null) {
            return null;
        }
        return role.toString();
    }

    @Override
    public ERole convertToEntityAttribute(String role) {
        if (role == null) {
            return null;
        }
        return ERole.valueOf(role);
    }
}