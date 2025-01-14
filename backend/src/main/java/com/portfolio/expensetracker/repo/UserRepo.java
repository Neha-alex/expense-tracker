package com.portfolio.expensetracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.expensetracker.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	User findByusername(String username);

}
