  package com.feedback.payloads.ticket_dto;

import java.util.Objects;

public class GetTicketsDTOin {
    private String email;
    private String departmentBased;
    private String assignByOwn;
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDepartmentBased() {
        return departmentBased;
    }
    public void setDepartmentBased(String departmentBased) {
        this.departmentBased = departmentBased;
    }
    public String getAssignByOwn() {
        return assignByOwn;
    }
    public void setAssignByOwn(String assignByOwn) {
        this.assignByOwn = assignByOwn;
    }
    public GetTicketsDTOin(String email, String departmentBased, String assignByOwn) {
        super();
        this.email = email;
        this.departmentBased = departmentBased;
        this.assignByOwn = assignByOwn;
    }
    @Override
    public String toString() {
        return "GetTicketsDTOin [email=" + email 
            + ", departmentBased=" + departmentBased 
            + ", assignByOwn=" + assignByOwn + "]";
    }
    @Override
    public int hashCode() {
        return Objects.hash(assignByOwn, departmentBased, email);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GetTicketsDTOin other = (GetTicketsDTOin) obj;
        return Objects.equals(assignByOwn, other.assignByOwn) && 
                Objects.equals(departmentBased, other.departmentBased)
                && Objects.equals(email, other.email);
    }
    public GetTicketsDTOin() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
   
    
    
}
