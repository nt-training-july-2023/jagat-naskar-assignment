package com.feedback.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity class to make a blueprint of a user
 */
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	int userId;
	@Column
	String name;
	@Column
	String userName;
	@Column
	String password;
	@Column
	String userType;
}
