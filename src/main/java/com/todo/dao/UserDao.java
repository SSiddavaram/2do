package com.todo.dao;

import java.util.Date;

import com.todo.dto.User;

public interface UserDao {

	User getUser(String username, String password);
	
	User createUser(String username, String password, Date date, String name);
}
