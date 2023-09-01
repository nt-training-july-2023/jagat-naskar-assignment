package com.feedback.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class representing roles for users.
 */
@Entity
@Table(name = "roles")
public class Role {
    /**
     * The unique identifier for the role.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * MAX_ROLE_NAME_LENGTH for length of name.
     */
    private static final int MAX_ROLE_NAME_LENGTH = 25;

    /**
     * The name of the role.
     */
    @Enumerated(EnumType.STRING)
    @Column(length = MAX_ROLE_NAME_LENGTH)
    private ERole name;

    /**
     * Default constructor.
     */
    public Role() {
        // Empty constructor
    }

    /**
     * Constructor to initialize a role with a given name.
     *
     * @param namee The name of the role.
     */
    public Role(final ERole namee) {
        this.name = namee;
    }

    /**
     * Get the unique identifier of the role.
     *
     * @return The role's identifier.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the unique identifier of the role.
     *
     * @param idd The new identifier for the role.
     */
    public void setId(final int idd) {
        this.id = idd;
    }

    /**
     * Get the name of the role.
     *
     * @return The role's name.
     */
    public ERole getName() {
        return name;
    }

    /**
     * Set the name of the role.
     *
     * @param namee The new name for the role.
     */
    public void setName(final ERole namee) {
        this.name = namee;
    }
}
