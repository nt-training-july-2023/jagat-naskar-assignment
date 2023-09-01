package com.feedback.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a ticket entity in the system.
 */
@Entity
@Table(name = "Ticket")
public class Ticket {
    /**
     * The Id of the ticket.
     */
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ticketId;

    /**
     * The title of the ticket.
     */
    @Column
    private String ticketTitle;

    /**
     * The type of the ticket.
     */
    @Column
    private String ticketType;

    /**
     * The status of the ticket.
     */
    @Column
    private EStatus ticketStatus;

    /**
     * The user who assigned the ticket.
     */
    @Column
    private String ticketAssignedBy;

    /**
     * The creation time of the ticket.
     */
    @Column
    private String ticketCreationTime;

    /**
     * The last updated time of the ticket.
     */
    @Column
    private String lastUpdatedTime;

    // Description
    // Comments (Can be a tabular representation)

    /**
     * Default constructor.
     */
    public Ticket() {
        // Empty constructor
    }

    /**
     * Parameterized constructor to initialize ticket details.
     *
     * @param ticketIdd       The id of the ticket.
     * @param ticketTitlee       The title of the ticket.
     * @param ticketTypee       The type of the ticket.
     * @param ticketStatuss      The status of the ticket.
     * @param ticketAssignedByy  The user who assigned the ticket.
     * @param ticketCreationTimee The creation time of the ticket.
     * @param lastUpdatedTimee   The last updated time of the ticket.
     */
    public Ticket(
            final String ticketIdd,
            final String ticketTitlee,
            final String ticketTypee,
            final EStatus ticketStatuss,
            final String ticketAssignedByy,
            final String ticketCreationTimee,
            final String lastUpdatedTimee
    ) {
    	this.ticketId = ticketIdd;
        this.ticketTitle = ticketTitlee;
        this.ticketType = ticketTypee;
        this.ticketStatus = ticketStatuss;
        this.ticketAssignedBy = ticketAssignedByy;
        this.ticketCreationTime = ticketCreationTimee;
        this.lastUpdatedTime = lastUpdatedTimee;
    }

    /**
     * Get the id of the ticket.
     *
     * @return The ticket title.
     */
    public String getTicketId() {
        return ticketId;
    }

    /**
     * Set the id of the ticket.
     *
     * @param ticketTitlee The new ticket title.
     */
    public void setTicketId(final String ticketIdd) {
        this.ticketId = ticketIdd;
    }
    
    /**
     * Get the title of the ticket.
     *
     * @return The ticket title.
     */
    public String getTicketTitle() {
        return ticketTitle;
    }

    /**
     * Set the title of the ticket.
     *
     * @param ticketTitlee The new ticket title.
     */
    public void setTicketTitle(final String ticketTitlee) {
        this.ticketTitle = ticketTitlee;
    }

    /**
     * Get the type of the ticket.
     *
     * @return The ticket type.
     */
    public String getTicketType() {
        return ticketType;
    }

    /**
     * Set the type of the ticket.
     *
     * @param ticketTypee The new ticket type.
     */
    public void setTicketType(final String ticketTypee) {
        this.ticketType = ticketTypee;
    }

    /**
     * Get the status of the ticket.
     *
     * @return The ticket status.
     */
    public EStatus getTicketStatus() {
        return ticketStatus;
    }

    /**
     * Set the status of the ticket.
     *
     * @param ticketStatuss The new ticket status.
     */
    public void setTicketStatus(final EStatus ticketStatuss) {
        this.ticketStatus = ticketStatuss;
    }

    /**
     * Get the user who assigned the ticket.
     *
     * @return The user who assigned the ticket.
     */
    public String getTicketAssignedBy() {
        return ticketAssignedBy;
    }

    /**
     * Set the user who assigned the ticket.
     *
     * @param ticketAssignedByy The user who assigned the ticket.
     */
    public void setTicketAssignedBy(final String ticketAssignedByy) {
        this.ticketAssignedBy = ticketAssignedByy;
    }

    /**
     * Get the creation time of the ticket.
     *
     * @return The ticket creation time.
     */
    public String getTicketCreationTime() {
        return ticketCreationTime;
    }

    /**
     * Set the creation time of the ticket.
     *
     * @param ticketCreationTimee The new ticket creation time.
     */
    public void setTicketCreationTime(final String ticketCreationTimee) {
        this.ticketCreationTime = ticketCreationTimee;
    }

    /**
     * Get the last updated time of the ticket.
     *
     * @return The ticket's last updated time.
     */
    public String getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    /**
     * Set the last updated time of the ticket.
     *
     * @param lastUpdatedTimee The new ticket's last updated time.
     */
    public void setLastUpdatedTime(final String lastUpdatedTimee) {
        this.lastUpdatedTime = lastUpdatedTimee;
    }

}
