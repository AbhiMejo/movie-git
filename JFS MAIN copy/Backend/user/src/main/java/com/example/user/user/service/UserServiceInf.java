package com.example.user.user.service;

import com.example.user.user.entity.User;

public interface UserServiceInf {

	public User addingUser(User u);
	public String validateLogin(Long loginID, String password);
}
