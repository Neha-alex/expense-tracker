package com.portfolio.expensetracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.portfolio.expensetracker.model.Transactions;

@Repository
public interface TransactionsRepo extends JpaRepository<Transactions, Integer> {
	
	Transactions findByUsername(String username);
	
    @Query("SELECT SUM(t.amount) FROM Transactions t WHERE t.type = 'Expense' AND t.username = :username")
    Long getTotalExpenseAmountByUsername(@Param("username") String username);
    
    @Query("SELECT SUM(t.amount) FROM Transactions t WHERE t.type = 'Income' AND t.username = :username")
    Long getTotalIncomeAmountByUsername(@Param("username") String username);
    
    @Query("SELECT SUM(t.amount) FROM Transactions t WHERE t.type = 'Investment' AND t.username = :username")
    Long getTotalInvestmentAmountByUsername(@Param("username") String username);

}
