package com.portfolio.expensetracker.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.expensetracker.model.Expense;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Integer> {
	
	List<Expense> findByusername(String username);

}
