package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class DataStorage {
	
	
	
	public static void storingData() {

		UserRepo userRepo = null;
		
		userRepo.save(new User());
	}
	
	
	
	
	

}
