package com.portfolio.expensetracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Transactions {
	
	@Id
	private int id;
	
	private String username;
	
	private String name;
	
	private String type;
	
	private String category;
	
	private String description;
	
	private long amount;
	
	private String month;
	
    @OneToOne
    @JoinColumn(name = "income_id")  // Foreign key to the Income table
    private Income income;
    
    @OneToOne
    @JoinColumn(name = "expense_id")
    private Expense expense;
	  
	public Income getIncome() {
		return income;
	}

	public void setIncome(Income income) {
		this.income = income;
	}
	
	public Expense getExpense() {
		return expense;
	}

	public void setExpense(Expense expense) {
		this.expense = expense;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Transactions() {
		super();
	}

	public Transactions(int id, String username, String name, String type, String category, String description,
			long amount, String month) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.type = type;
		this.category = category;
		this.description = description;
		this.amount = amount;
		this.month = month;
	}

	@Override
	public String toString() {
		return "Transactions [id=" + id + ", username=" + username + ", name=" + name + ", type=" + type + ", category="
				+ category + ", description=" + description + ", amount=" + amount + ", month=" + month + "]";
	}	
}
