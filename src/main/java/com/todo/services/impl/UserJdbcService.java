package com.todo.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.dao.UserDao;
import com.todo.dto.User;
import com.todo.services.UserService;

@Service
public class UserJdbcService implements UserService{

	@Autowired
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public User getUser(String username, String password) {
		return userDao.getUser(username, password);
	}


	@Override
	public User createUser(String username, String password, Date date, String name) {
		return userDao.createUser(username, password, date, name);
	}

}
