package com.portfolio.expensetracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.portfolio.expensetracker.model.User;
import com.portfolio.expensetracker.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JWTService jwt;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public User register(User user) {
	    if (user.getPassword() != null && !user.getPassword().isEmpty() && 
	        user.getUsername() != null && !user.getUsername().isEmpty()) {
	        System.out.println("username and password are not null or empty");
	        user.setPassword(encoder.encode(user.getPassword()));
	        return repo.save(user);
	    } else {
	        throw new IllegalArgumentException("Username or Password cannot be null or empty");
	    }
	}

	public String verify(User user) {	
		Authentication authentication =
				authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if (authentication.isAuthenticated())
			return jwt.generateToken(user.getUsername());
		
		return "fail";
	}

}
