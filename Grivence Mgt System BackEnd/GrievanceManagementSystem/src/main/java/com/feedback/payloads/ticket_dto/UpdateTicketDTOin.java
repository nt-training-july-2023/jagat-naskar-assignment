package com.feedback.payloads.ticket_dto;

import java.util.List;
import java.util.Objects;

import com.feedback.entities.Comment;
import com.feedback.entities.EStatus;

public class UpdateTicketDTOin {
    long ticketId;
    EStatus ticketStatus;
    List<Comment> commentList;
    
    public long getTicketId() {
        return ticketId;
    }
    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }
    public EStatus getTicketStatus() {
        return ticketStatus;
    }
    public void setTicketStatus(EStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
    public List<Comment> getCommentList() {
        return commentList;
    }
    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
    @Override
    public String toString() {
        return "UpdateTicketDTOin [ticketId=" + ticketId 
                + ", ticketStatus=" + ticketStatus 
                + ", commentList=" + commentList + "]";
    }
    public UpdateTicketDTOin(long ticketIdd, 
		    EStatus ticketStatuss, 
		    List<Comment> commentListt) {
        super();
        this.ticketId = ticketIdd;
        this.ticketStatus = ticketStatuss;
        this.commentList = commentListt;
    }
    public UpdateTicketDTOin() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public int hashCode() {
        return Objects.hash(commentList, ticketId, ticketStatus);
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
        return Objects.equals(commentList, other.commentList) && ticketId == other.ticketId
                && ticketStatus == other.ticketStatus;
    }

    
    
}
