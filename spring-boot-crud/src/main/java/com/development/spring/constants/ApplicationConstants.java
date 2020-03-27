/**
 * 
 */
package com.development.spring.constants;

/**
 * @author Sanjib Bhadra
 *
 */
public interface ApplicationConstants {
	
	public static final String CREATE_PROD_ENDPOINT     = "/api/transaction/create";
	public static final String GET_PRODUCTS_ALL         = "api/transaction/viewAll";
	public static final String UPDATE_PRODUCT_ENDPOINT  = "/api/transaction/update/{id}";
	public static final String GET_PRODUCT_ENDPOINT     = "/api/transaction/get/{id}" ;
	public static final String DELETE_PRODUCT_ID        = "/api/transaction/delete/{id}";
	
	public static final String AUTH                     = "api/auth";
}
