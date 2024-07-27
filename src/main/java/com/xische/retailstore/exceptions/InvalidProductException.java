package com.xische.retailstore.exceptions;

/**
 * Exception thrown when an invalid product is encountered in the retail store
 * system. This exception extends {@link RuntimeException} and is used to signal
 * errors related to invalid products that should be handled by the runtime
 * environment.
 * 
 * @author shanmugamr
 */
public class InvalidProductException extends RuntimeException {

	/**
	 * Unique identifier for Serializable classes.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new InvalidProductException with the specified detail message.
	 * 
	 * @param message the detail message. The detail message is saved for later
	 *                retrieval by the {@link #getMessage()} method.
	 */
	public InvalidProductException(String message) {
		super(message);
	}
}
