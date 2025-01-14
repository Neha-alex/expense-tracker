package com.portfolio.expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.expensetracker.dto.TransactionsDto;
import com.portfolio.expensetracker.model.Expense;
import com.portfolio.expensetracker.model.Income;
import com.portfolio.expensetracker.service.TransactionsService;

@RestController
public class TransactionsController {
	
	@Autowired
	private TransactionsService service;
	
    @GetMapping(value = "/getTransactions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionsDto> getUserDetails( @RequestParam String username) {    	
    	return ResponseEntity.ok(service.getUserTransactionDetails(username));   	
    }
    
    @GetMapping("/getIncomeDetails")
    public ResponseEntity<List<Income>> getIncomeDetails(@RequestParam String username){
    	return(ResponseEntity.ok(service.getIncomeDetails(username)));
    	
    }
    
    @GetMapping("/getExpenseDetails")
    public ResponseEntity<List<Expense>> getExpenseDetails(@RequestParam String username){
    	return(ResponseEntity.ok(service.getExpenseDetails(username)));
    	
    }

	@PostMapping("/addIncome")
	public ResponseEntity<Income> addIncomeDetails(@RequestParam String username, @RequestBody Income income) {

		return ResponseEntity.ok(service.addIncomeDetails(income, username));

	}

	@PostMapping("/addExpense")
	public ResponseEntity<Expense> addExpenseDetails(@RequestParam String username, @RequestBody Expense expense) {

		return ResponseEntity.ok(service.addExpenseDetails(expense, username));
	}
	
	@DeleteMapping("/deleteExpense/{Id}")
	public ResponseEntity<Void>deleteExpense(@PathVariable int Id){
		service.deleteExpense(Id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/deleteIncome/{Id}")
	public ResponseEntity<Void>deleteIncome(@PathVariable int Id){
		service.deleteIncome(Id);
		return ResponseEntity.noContent().build();
	}


}
