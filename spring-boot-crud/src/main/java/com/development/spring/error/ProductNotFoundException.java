/**
 * 
 */
package com.development.spring.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Sanjib Bhadra
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {
	
	private String message;
	
	public ProductNotFoundException() {
		super();
	}

	public ProductNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
	

}
