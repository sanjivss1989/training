/**
 * 
 */
package com.development.spring.error;

/**
 * @author Sanjib Bhadra
 *
 */
public class ResourceNotFoundException extends Exception {
	
	private String message;

	public ResourceNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	

}
