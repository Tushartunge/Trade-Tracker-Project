package com.TradeTracker.exception;

public class UserIdNotFoundException extends RuntimeException{

	public UserIdNotFoundException(String message) {
		super(message);
	}
}
