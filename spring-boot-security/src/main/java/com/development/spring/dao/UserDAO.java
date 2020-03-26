/**
 * 
 */
package com.development.spring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.development.spring.model.DaoUser;

/**
 * @author Sanjib Bhadra
 *
 */
@Repository
public interface UserDAO extends CrudRepository<DaoUser, Integer> {

}
