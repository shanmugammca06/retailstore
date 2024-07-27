/**
 * 
 */
package com.xische.retailstore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author shanmugamr
 *
 */
@RestControllerAdvice
public class Exceptions {

	@ExceptionHandler(value = InvalidUserException.class)
	ResponseEntity<String> userNotFoundException(InvalidUserException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = ProductQuantityCannotBeZeroException.class)
	ResponseEntity<String> productQuantityCannotBeZeroException(ProductQuantityCannotBeZeroException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = InvalidProductException.class)
	ResponseEntity<String> invalidProductException(InvalidProductException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
}
