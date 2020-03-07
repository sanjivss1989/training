/**
 * 
 */
package com.development.spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sanjib Bhadra
 *
 */
@RestController
public class DemoController {
	
	@GetMapping(value = "/greet")
	@ResponseBody
	public String greet() {
		return "Hello How are you";
	}

}
