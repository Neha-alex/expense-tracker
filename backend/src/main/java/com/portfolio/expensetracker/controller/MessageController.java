package com.portfolio.expensetracker.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	
	@GetMapping("/message")
	public ResponseEntity<List<String>> messages(){
		return ResponseEntity.ok(Arrays.asList("first","second"));
		
	}

}
