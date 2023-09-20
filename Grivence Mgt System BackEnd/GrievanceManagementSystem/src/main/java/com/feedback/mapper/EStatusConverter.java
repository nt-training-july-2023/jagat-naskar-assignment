package com.feedback.mapper;

import com.feedback.entities.EStatus;

public class EStatusConverter {
    public static EStatus convertStringToEStatus(String eStatus) {
        switch (eStatus.toLowerCase()) {
            case "open":
                return EStatus.Open;
            case "being_addressed":
                return EStatus.Being_Addressed;
            case "resolved":
                return EStatus.Resolved;
            default:
                return null;
//            default:
//                throw new IllegalArgumentException("Invalid status string: " + eStatus);
        }
    }
}