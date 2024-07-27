package com.xische.retailstore.exceptions;

/**
 * Exception thrown when a user is found to be invalid within the retail store
 * system. This exception extends {@link RuntimeException} and is used to signal
 * errors related to user validation that should be handled by the runtime
 * environment.
 * 
 * 
 * 
 * @author shanmugamr
 */
public class InvalidUserException extends RuntimeException {

	/**
	 * Unique identifier for Serializable classes.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new InvalidUserException with the specified detail message.
	 * 
	 * @param message the detail message. The detail message is saved for later
	 *                retrieval by the {@link #getMessage()} method.
	 */
	public InvalidUserException(String message) {
		super(message);
	}
}
