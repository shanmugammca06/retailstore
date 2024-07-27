/**
 * 
 */
package com.xische.retailstore.dtos;

import java.util.Date;

/**
 * The UserDto class represents a Data Transfer Object (DTO) for users. It
 * encapsulates the data related to a user, including their ID, name, type, and
 * subscription date.
 * 
 * This class is used to transfer user data between different layers of the
 * application.
 * 
 * @author shanmugamr
 * 
 */
public class UserDto {

	private int id;
	private String name;
	private String type;
	private Date subscriptionDate;

	/**
	 * Gets the ID of the user.
	 * 
	 * @return the user ID.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the ID of the user.
	 * 
	 * @param id the user ID to set.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the name of the user.
	 * 
	 * @return the user name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the user.
	 * 
	 * @param name the user name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the type of the user.
	 * 
	 * @return the user type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type of the user.
	 * 
	 * @param type the user type to set.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the subscription date of the user.
	 * 
	 * @return the subscription date.
	 */
	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	/**
	 * Sets the subscription date of the user.
	 * 
	 * @param subscriptionDate the subscription date to set.
	 */
	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}
}