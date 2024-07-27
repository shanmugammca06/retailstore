package com.xische.retailstore.exceptions;

/**
 * Exception thrown when an operation involving a product is attempted with a
 * quantity of zero. This exception extends {@link RuntimeException} and is used
 * to indicate that the product quantity must be greater than zero for the
 * operation to proceed.
 * 
 * 
 * @author shanmugamr
 */
public class ProductQuantityCannotBeZeroException extends RuntimeException {

	/**
	 * Unique identifier for Serializable classes.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new ProductQuantityCannotBeZeroException with the specified
	 * detail message.
	 * 
	 * @param message the detail message. The detail message is saved for later
	 *                retrieval by the {@link #getMessage()} method.
	 */
	public ProductQuantityCannotBeZeroException(String message) {
		super(message);
	}
}
