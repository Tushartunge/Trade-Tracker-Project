package com.TradeTracker.service;

import java.util.List;


import com.TradeTracker.entity.User;

public interface UserService {

	User addUser (User user);
	
	List<User> getAllUser();
	
	User getUser(int userId);
	
	User updateUser(User user, int userId );
	
	void deleteUser(int userId);
}
