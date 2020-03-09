/**
 * 
 */
package com.development.spring.error;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Sanjib Bhadra
 *
 */

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleCustomException(Exception ex, WebRequest request)
	{
		List<String> details = new ArrayList<String>();
		details.add(ex.getLocalizedMessage());
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(new Date(), ex.getMessage(),details );
		return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public final ResponseEntity<Object> handleEmployeeNotFoundException(Exception ex, WebRequest request)
	{
		List<String> details = new ArrayList<String>();
		details.add(ex.getLocalizedMessage());
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(new Date(), ex.getMessage(), details);
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> details = ex.getBindingResult().getFieldErrors().stream().
		                                                            map(x -> x.getDefaultMessage()).
		                                                            collect(Collectors.toList());
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(new Date(), ex.getMessage(), details);
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
