/**
 * 
 */
package com.development.spring.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.development.spring.constants.ApplicationConstants;
import com.development.spring.error.ProductNotFoundException;
import com.development.spring.model.Product;
import com.development.spring.service.ProductService;

/**
 * @author Sanjib Bhadra
 *
 */
@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping(path = ApplicationConstants.CREATE_PROD_ENDPOINT)
	public ResponseEntity<Object> createProduct(@Valid @RequestBody Product p){
		Product product = service.saveProduct(p);
		URI location = ServletUriComponentsBuilder
		               .fromCurrentRequest()
		               .path("/{id}")
		               .buildAndExpand(product.getId())
		               .toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path = ApplicationConstants.GET_PRODUCTS_ALL)
	public ResponseEntity<List<Product>> retrieveProducts()
	{ 
		List<Product> products = service.retrieveProducts();
	     if (products.isEmpty()) {
             return new ResponseEntity(HttpStatus.NO_CONTENT);
	     }
		 return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@PutMapping(path = ApplicationConstants.UPDATE_PRODUCT_ENDPOINT)
	public ResponseEntity<?> updateEmployee(@RequestBody Product p, @PathVariable(name = "id") int id)
	{
		 Product currentProduct = service.getProduct(id);
		 
	        if (currentProduct == null) {
	         return new ResponseEntity<Object>(new ProductNotFoundException("Unable to upate. User with id " + id + " not found."),
	                    HttpStatus.NOT_FOUND);
	        }
	 
	        currentProduct.setProdCode(p.getProdCode());
	        currentProduct.setCategory(p.getCategory());
	        currentProduct.setName(p.getName());
	        currentProduct.setProdDesc(p.getProdDesc());
	        currentProduct.setPrice(p.getPrice());
	 
	        service.updateProduct(currentProduct);
	        return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
		
	}
	
	@GetMapping(path = ApplicationConstants.GET_PRODUCT_ENDPOINT)
	public ResponseEntity<?> getProduct(@PathVariable(name = "id")int id)
	{
		Product prod = service.getProduct(id);
		if(prod == null)
			
		{
			throw new ProductNotFoundException("Product with id ==> "+id+"was not found in database");
		}
		 return new ResponseEntity<Product>(prod, HttpStatus.OK) ;
	}
	
	 @DeleteMapping(path = ApplicationConstants.DELETE_PRODUCT_ID)
	    public ResponseEntity<?> deleteProduct(@PathVariable("id") int id) {
	       
		    Product product = service.getProduct(id);
	        if (product == null) {
	            return new ResponseEntity<Object>(new ProductNotFoundException("Unable to delete. User with id " + id + " not found."),
	                    HttpStatus.NOT_FOUND);
	        }
	        service.deleteProduct(id);
	        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
	    }

}
