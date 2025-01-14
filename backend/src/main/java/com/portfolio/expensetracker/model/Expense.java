package com.portfolio.expensetracker.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Expense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String username;
	
	private String name;
	
	private String type;
	
	private String category;
	
	private String description;
	
	private long amount;
	
	private String date;
	
	 @OneToOne(mappedBy = "expense", cascade = CascadeType.ALL)
	 private Transactions transaction;

	public Expense() {
		super();
	}

	public Expense(int id, String username, String name, String type, String category, String description, long amount,
			String date, Transactions transaction) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.type = type;
		this.category = category;
		this.description = description;
		this.amount = amount;
		this.date = date;
		this.transaction = transaction;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", username=" + username + ", name=" + name + ", type=" + type + ", category="
				+ category + ", description=" + description + ", amount=" + amount + ", date=" + date + "]";
	}
	 
}
