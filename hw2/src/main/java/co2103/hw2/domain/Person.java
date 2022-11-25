package co2103.hw2.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author oa194
 * Person class to set and get information about each person/user
 *
 */

@Entity
public class Person {

	/***the id and username of a Person/user */
	@Id
	private String username;
	/***the full name of the person */
	private String fullName;
	/***the password of the person */
	private String password;
	/***the kind of user the person is */
	private UserKind kind;

	public Person() {
		super();
	}

	public Person(String fullName, String username, String password, UserKind kind) {
		this.fullName = fullName;
		this.kind = kind;
		this.username = username;
		this.password = password;
	}

	public UserKind getKind() {
		return kind;
	}

	public void setKind(UserKind kind) {
		this.kind = kind;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {	
		return fullName;
	}
}
