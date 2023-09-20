package com.feedback.payloads.ticket_dto;

import java.util.Objects;

/**
 * This inDTO is for getAllTickets function.
 * @author jagat.
 * @version 001.
 */
public class GetTicketsDTOin {
    
    private String email;
    private String departmentBased;
    private String assignByOwn;
    private String filterStatus;
    private int pageNumber;
    
    /**
     * getPageNumber.
     * @return pageNumber.
     */
    public int getPageNumber() {
        return pageNumber;
    }
    
    /**
     * setPageNumber.
     * @return pageNumberr.
     */
    public void setPageNumber(final int pageNumberr) {
        this.pageNumber = pageNumberr;
    }
    
    /**
     * getEmail.
     * @return email.
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * setEmail.
     * @param emaill.
     */
    public void setEmail(final String emaill) {
        this.email = emaill;
    }
    
    /**
     * getDepartmentBased.
     * @return departmentBased.
     */
    public String getDepartmentBased() {
        return departmentBased;
    }
    
    /**
     * setDepartmentBased.
     * @param departmentBasedd.
     */
    public void setDepartmentBased(final String departmentBasedd) {
        this.departmentBased = departmentBasedd;
    }
    
    /**
     * getAssignByOwn.
     * @return assignByOwn.
     */
    public String getAssignByOwn() {
        return assignByOwn;
    }
    
    /**
     * setAssignByOwn.
     * @param assignByOwnn
     */
    public void setAssignByOwn(final String assignByOwnn) {
        this.assignByOwn = assignByOwnn;
    }
    
    /**
     * getFilterStatus.
     * @return filterStatus.
     */
    public String getFilterStatus() {
        return filterStatus;
    }
    
    /**
     * setFilterStatus.
     * @param selectedStatuss.
     */
    public void setFilterStatus(final String selectedStatuss) {
        this.filterStatus = selectedStatuss;
    }
    
    /**
     * GetTicketsDTOin.
     */
    public GetTicketsDTOin() {
        super();
    }
    
    /**
     * toString.
     */
    @Override
    public String toString() {
        return "GetTicketsDTOin [email=" + email 
                + ", departmentBased=" + departmentBased 
                + ", assignByOwn=" + assignByOwn 
                + ", filterStatus=" + filterStatus 
                + ", pageNumber=" + pageNumber + "]";
    }
    
    /**
     * GetTicketsDTOin field constructor.
     * @param emaill
     * @param departmentBasedd
     * @param assignByOwnn
     * @param filterStatuss
     * @param pageNumberr
     */
    public GetTicketsDTOin(final String emaill, 
            final String departmentBasedd, 
            final String assignByOwnn, 
            final String filterStatuss,
            final int pageNumberr) {
        super();
        this.email = emaill;
        this.departmentBased = departmentBasedd;
        this.assignByOwn = assignByOwnn;
        this.filterStatus = filterStatuss;
        this.pageNumber = pageNumberr;
    }
    
    /**
     * hashCode method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(assignByOwn, departmentBased, email, filterStatus, pageNumber);
    }
    
    /**
     * equals object.
     * @param object.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GetTicketsDTOin other = (GetTicketsDTOin) obj;
        return Objects.equals(assignByOwn, other.assignByOwn) 
                && Objects.equals(departmentBased, other.departmentBased)
                && Objects.equals(email, other.email) 
                && Objects.equals(filterStatus, other.filterStatus)
                && pageNumber == other.pageNumber;
    }

}

