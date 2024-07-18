package com.TradeTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TradeTracker.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
