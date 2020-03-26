/**
 * 
 */
package com.development.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.development.spring.error.ResourceNotFoundException;
import com.development.spring.model.User;
import com.development.spring.repository.UserRepository;

/**
 * @author Sanjib Bhadra
 *
 */
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepo.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with id " + usernameOrEmail));

		return UserPrincipal.create(user);
	}

	@Transactional
	public UserDetails loadUserById(Long id) throws ResourceNotFoundException {
		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found" + id));

		return UserPrincipal.create(user);
	}
}
