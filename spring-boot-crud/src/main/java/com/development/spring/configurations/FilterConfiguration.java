/**
 * 
 */
package com.development.spring.configurations;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.development.spring.filters.RequestResponseLoggerFilter;
import com.development.spring.filters.TransactionFilter;

/**
 * @author Sanjib Bhadra
 *
 */
@Configuration
public class FilterConfiguration {

	@Bean
	public FilterRegistrationBean<RequestResponseLoggerFilter> loggingFilter(){
	    FilterRegistrationBean<RequestResponseLoggerFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	         
	    registrationBean.setFilter(new RequestResponseLoggerFilter());
	    registrationBean.addUrlPatterns("/product/*");
	         
	    return registrationBean;  
}
	
	@Bean
	public FilterRegistrationBean<TransactionFilter> transactionFilter(){
	    FilterRegistrationBean<TransactionFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	         
	    registrationBean.setFilter(new TransactionFilter());
	    registrationBean.addUrlPatterns("/product/*");
	       return registrationBean;  
}
}
