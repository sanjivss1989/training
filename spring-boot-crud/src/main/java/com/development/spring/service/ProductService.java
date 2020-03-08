/**
 * 
 */
package com.development.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.development.spring.model.Product;

/**
 * @author Sanjib Bhadra
 *
 */

public interface ProductService {

    public Product saveProduct(Product p);
	
	public List<Product> retrieveProducts();
	
	
	public Product getProduct(int id);
	
	
	public void updateProduct(Product p);
	
	
	public void deleteProduct(int id);
	
	
}
