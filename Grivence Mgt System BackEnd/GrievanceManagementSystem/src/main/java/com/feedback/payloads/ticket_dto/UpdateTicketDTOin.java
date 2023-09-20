package com.feedback.payloads.ticket_dto;

import java.util.Objects;

import com.feedback.entities.Comment;
import com.feedback.entities.EStatus;

public class UpdateTicketDTOin {
    long ticketId;
    EStatus ticketStatus;
    String comment;
    
    public long getTicketId() {
        return ticketId;
    }
    public void setTicketId(long ticketIdd) {
        this.ticketId = ticketIdd;
    }
    public EStatus getTicketStatus() {
        return ticketStatus;
    }
    public void setTicketStatus(EStatus ticketStatuss) {
        this.ticketStatus = ticketStatuss;
    }
    public String getComment() {
        return comment;
    }
    public void setCommentList(String commentt) {
        this.comment = commentt;
    }
    @Override
    public String toString() {
        return "UpdateTicketDTOin [ticketId=" + ticketId 
                + ", ticketStatus=" + ticketStatus 
                +"]";
    }
    public UpdateTicketDTOin(long ticketIdd, 
            EStatus ticketStatuss, 
            String commentt) {
        super();
        this.ticketId = ticketIdd;
        this.ticketStatus = ticketStatuss;
        this.comment = commentt;
    }
    public UpdateTicketDTOin() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public int hashCode() {
        return Objects.hash(comment, ticketId, ticketStatus);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UpdateTicketDTOin other = (UpdateTicketDTOin) obj;
        return Objects.equals(comment, other.comment) && ticketId == other.ticketId
                && ticketStatus == other.ticketStatus;
    }

    
    
}
