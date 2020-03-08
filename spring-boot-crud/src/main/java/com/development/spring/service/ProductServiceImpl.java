/**
 * 
 */
package com.development.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.development.spring.model.Product;
import com.development.spring.repository.ProductRepository;

/**
 * @author Sanjib Bhadra
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;
	
	
	@Override
	public Product saveProduct(Product p) {
		// TODO Auto-generated method stub
		return repo.save(p);
	}

	@Override
	public List<Product> retrieveProducts() {
		// TODO Auto-generated method stub
		List<Product> pList = new ArrayList<Product>();
		pList = (List<Product>) repo.findAll();
		return pList;
	}

	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		Optional<Product> optional = repo.findById(id);
		Product emp = optional.get();
		return emp;
	}

	@Override
	public void updateProduct(Product p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
   
}
