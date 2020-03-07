/**
 * 
 */
package com.development.spring.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.development.spring.model.Product;

/**
 * @author Sanjib Bhadra
 *
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
	

}
