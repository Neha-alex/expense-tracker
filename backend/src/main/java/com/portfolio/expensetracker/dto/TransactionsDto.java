package com.portfolio.expensetracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class TransactionsDto {
	
    private Long expense;
    private Long income;
    private Long savings;
    private Long investments;
    
    
    
	public Long getExpense() {
		return expense;
	}



	public void setExpense(Long expense) {
		this.expense = expense;
	}



	public Long getIncome() {
		return income;
	}



	public void setIncome(Long income) {
		this.income = income;
	}



	public Long getSavings() {
		return savings;
	}



	public void setSavings(Long savings) {
		this.savings = savings;
	}



	public Long getInvestments() {
		return investments;
	}



	public void setInvestments(Long investments) {
		this.investments = investments;
	}

	
	


	public TransactionsDto() {
		super();
	}



	@Override
	public String toString() {
		return "TransactionsDto [expense=" + expense + ", income=" + income + ", savings=" + savings + ", investments="
				+ investments + "]";
	}



	public TransactionsDto(Long expense, Long income, Long savings, Long investments) {
		super();
		this.expense = expense;
		this.income = income;
		this.savings = savings;
		this.investments = investments;
	}
    
    

}
