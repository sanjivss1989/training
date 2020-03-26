/**
 * 
 */
package com.development.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.development.spring.model.Role;
import com.development.spring.model.RoleName;

/**
 * @author Sanjib Bhadra
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Optional<Role> findByName(RoleName roleName);

}
