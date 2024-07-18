package com.TradeTracker.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TradeTracker.entity.User;
import com.TradeTracker.exception.UserIdNotFoundException;
import com.TradeTracker.repository.UserRepository;
import com.TradeTracker.service.UserService;

@Service
public class UserServiceimpl  implements UserService{
	
	@Autowired
	UserRepository userRepo;

	@Override
	public User addUser(User user) {
		
		return userRepo.save(user);
	}

	@Override
	public User getUser(int userId) {
		
		return userRepo.findById(userId).
				orElseThrow(()-> new UserIdNotFoundException("user id is not corrected"));
	}

	@Override
	public User updateUser(User user, int userId) {
		
		User UpdateUser = userRepo.findById(userId).
				orElseThrow(()-> new UserIdNotFoundException("user id is not corrected"));
		        UpdateUser.setPhoneNo(user.getPhoneNo());
		        //UpdateUser.setAddress(user.getAddress());
		        userRepo.save(UpdateUser);
		return UpdateUser;
	}

	@Override
	public void deleteUser(int userId) {
		User deleteUser = userRepo.findById(userId).
				orElseThrow(()-> new UserIdNotFoundException("user id is not corrected"));
		       userRepo.delete(deleteUser);
		
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepo.findAll();
	}
	

	

}
