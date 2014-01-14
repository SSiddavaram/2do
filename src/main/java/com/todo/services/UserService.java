package com.todo.services;

import java.util.Date;

import com.todo.dto.User;

public interface UserService {

	User getUser(String username, String password);
	
	User createUser(String username, String password, Date date, String name);
}
