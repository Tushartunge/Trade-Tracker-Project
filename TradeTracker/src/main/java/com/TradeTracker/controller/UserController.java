package com.TradeTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TradeTracker.entity.Transaction;
import com.TradeTracker.entity.User;
import com.TradeTracker.service.UserService;


import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class UserController {

	@Autowired
	UserService uservice;
	
	User user;
	
	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
		
		return new  ResponseEntity<User>(uservice.addUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/users")
    public List<User> getAllUser() {
		
		return uservice.getAllUser();
	}
	
	@GetMapping("/users/{userId}")
    public ResponseEntity<User> getUser(@PathVariable ("userId") int userId) {
		
		return new  ResponseEntity<User>(uservice.getUser(userId),HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable ("userId") int userId)
	{
		uservice.deleteUser(userId);
		return new ResponseEntity<String>("User Deleted Sucessfully", HttpStatus.OK);
	}
	
	@PutMapping("/users/{tid}")
	public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable ("userId") int userId){
		
		 uservice.updateUser(user, userId);
		 return new ResponseEntity<String>("User update Sucessfully", HttpStatus.OK);
	}
	
}
