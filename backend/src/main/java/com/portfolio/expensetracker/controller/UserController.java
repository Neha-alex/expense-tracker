package com.portfolio.expensetracker.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.expensetracker.model.User;
import com.portfolio.expensetracker.repo.UserRepo;
import com.portfolio.expensetracker.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	UserRepo repo;
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		System.out.println("Inside controller");
		return service.register(user);		
	}
	
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            String token = service.verify(user);
            User verifiedUser = repo.findByusername(user.getUsername());
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            response.put("username", verifiedUser.getUsername());

            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", e.getMessage()));
        }
    } 
    
}
    
	
	


