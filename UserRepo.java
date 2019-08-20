package com.example.demo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepo extends JpaRepository<User, Integer>{

	User findByUserId(int userId);
	
	User findByUserName(String userName);
	
	User findByUserNameAndPassword(String userName, String password);
	
	@Query("select userName from User")
	public List<String> getAllUserNames();
}
