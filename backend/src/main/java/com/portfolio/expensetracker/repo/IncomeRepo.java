package com.portfolio.expensetracker.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.expensetracker.model.Income;

@Repository
public interface IncomeRepo extends JpaRepository<Income, Integer> {
	
	List<Income> findByusername(String username);

}
