package com.portfolio.expensetracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.portfolio.expensetracker.model.User;
import com.portfolio.expensetracker.model.UserPrincipal;
import com.portfolio.expensetracker.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = repo.findByusername(username);
		if (user==null) {
			System.out.println("user not found");
			throw new UsernameNotFoundException("user not found");
		}
		

		return new UserPrincipal(user);
	}

}
