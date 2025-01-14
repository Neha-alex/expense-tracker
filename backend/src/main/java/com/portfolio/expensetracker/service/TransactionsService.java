package com.portfolio.expensetracker.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.expensetracker.dto.TransactionsDto;
import com.portfolio.expensetracker.model.Expense;
import com.portfolio.expensetracker.model.Income;
import com.portfolio.expensetracker.model.Transactions;
import com.portfolio.expensetracker.repo.ExpenseRepo;
import com.portfolio.expensetracker.repo.IncomeRepo;
import com.portfolio.expensetracker.repo.TransactionsRepo;

@Service
public class TransactionsService {
	
	@Autowired
	private TransactionsRepo repo;
	
	@Autowired
	private IncomeRepo incomeRepo;
	
	@Autowired
	private ExpenseRepo expenseRepo;

	public TransactionsDto getUserTransactionDetails(String username) {
	    Long expense = Optional.ofNullable(repo.getTotalExpenseAmountByUsername(username)).orElse(0L);
	    Long income = Optional.ofNullable(repo.getTotalIncomeAmountByUsername(username)).orElse(0L);
	    Long investments = Optional.ofNullable(repo.getTotalInvestmentAmountByUsername(username)).orElse(0L);
	    Long savings = income - expense;

	    return new TransactionsDto(expense, income, savings, investments);
	}
	
	public List<Income> getIncomeDetails(String username) {
		return incomeRepo.findByusername(username);	
	}
	
	public List<Expense> getExpenseDetails(String username) {
		return expenseRepo.findByusername(username);	
	}

	public Income addIncomeDetails(Income income,String username) {
		Income newIncome = new Income();
		newIncome.setName(income.getName());
		newIncome.setAmount(income.getAmount());
		newIncome.setCategory(income.getCategory());
		newIncome.setDate(income.getDate());
		newIncome.setDescription(income.getDescription());
		newIncome.setType("Income");
		newIncome.setUsername(username);
		incomeRepo.save(newIncome);
		
		Transactions newTransaction = new Transactions();
		newTransaction.setId(newIncome.getId());
		newTransaction.setName(newIncome.getName());
		newTransaction.setAmount(newIncome.getAmount());
		newTransaction.setCategory(newIncome.getCategory());
		newTransaction.setMonth(newIncome.getDate());
		newTransaction.setDescription(newIncome.getDescription());
		newTransaction.setType(newIncome.getType());
		newTransaction.setUsername(newIncome.getUsername());
		newTransaction.setIncome(newIncome);
		
		repo.save(newTransaction);

		return newIncome;
	}

	public Expense addExpenseDetails(Expense expense, String username) {
		
		Expense newExpense = new Expense();
		newExpense.setName(expense.getName());
		newExpense.setAmount(expense.getAmount());
		newExpense.setCategory(expense.getCategory());
		newExpense.setDate(expense.getDate());
		newExpense.setDescription(expense.getDescription());
		newExpense.setType("Expense");
		newExpense.setUsername(username);
		expenseRepo.save(newExpense);
		
		Transactions newTransaction = new Transactions();
		newTransaction.setId(newExpense.getId());
		newTransaction.setName(newExpense.getName());
		newTransaction.setAmount(newExpense.getAmount());
		newTransaction.setCategory(newExpense.getCategory());
		newTransaction.setMonth(newExpense.getDate());
		newTransaction.setDescription(newExpense.getDescription());
		newTransaction.setType(newExpense.getType());
		newTransaction.setUsername(newExpense.getUsername());
		newTransaction.setExpense(newExpense);		
		repo.save(newTransaction);		
		return newExpense;
	}

	public void deleteExpense(int id) {
		expenseRepo.deleteById(id);	
	}
	
	public void deleteIncome(int id) {
		incomeRepo.deleteById(id);	
	}

}
