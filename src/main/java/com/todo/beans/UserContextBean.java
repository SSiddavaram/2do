package com.todo.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.todo.dto.User;

@ManagedBean(name = "userContextBean")
@SessionScoped
public class UserContextBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User userContext;

	public User getUserContext() {
		return userContext;
	}

	public void setUserContext(User userContext) {
		this.userContext = userContext;
	}
	
	
}
