/**
 * 
 */
package com.development.spring.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author Sanjib Bhadra
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	 @Bean
	 public Docket postsApi() {
	        return new Docket(DocumentationType.SWAGGER_2).apiInfo(metadata()).select().paths(regex("/product.*")).build();
	    }
	 
	 @SuppressWarnings("deprecation")
	 private ApiInfo metadata() {
	        return new ApiInfoBuilder().title("Dev Academy").description("API reference guide for developers").termsOfServiceUrl("https://www.google.com/").contact("Bhadra,Sanjib").version("1.0").build();  
	    }
}
