package com.todo.beans;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.todo.services.PostToDoService;
import com.todo.util.WebAppUtil;

@ManagedBean(name = "todoPostBean")
@ViewScoped
public class TodoPostBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String post_title;
	private String post_desc;
	private Date post_due_date;
	
	public static PostToDoService getPostToDoService(){
		return (PostToDoService)WebAppUtil.getSpringBean("postToDoJdbcService");
	}
	
	private UserContextBean getUserSessionContext(){
		return (UserContextBean)WebAppUtil.getManagedBean("userContextBean");
	}
	
	public void createTodoPost() throws ParseException{
		Date date = new Date();
		getPostToDoService().createPost(post_title, post_desc, date, post_due_date, getUserSessionContext().getUserContext().getUser_id());
	}
	
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_desc() {
		return post_desc;
	}
	public void setPost_desc(String post_desc) {
		this.post_desc = post_desc;
	}
	public Date getPost_due_date() {
		return post_due_date;
	}
	public void setPost_due_date(Date post_due_date) {
		this.post_due_date = post_due_date;
	}
	
	

}
