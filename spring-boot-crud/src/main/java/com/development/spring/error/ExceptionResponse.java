/**
 * 
 */
package com.development.spring.error;

import java.util.Date;
import java.util.List;

/**
 * @author Sanjib Bhadra
 *
 */
public class ExceptionResponse {

	private Date timestamp;
	private String message;
	private List<String> details;
	
	public ExceptionResponse(Date timestamp, String message, List<String> details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public List<String> getDetails() {
		return details;
	}
	
	
}
