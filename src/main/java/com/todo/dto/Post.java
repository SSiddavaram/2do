package com.todo.dto;

import java.util.Date;

public class Post {

	private Integer post_id;
	private String post_title;
	private String post_desc;
	private Date date_created;
	private Date post_due_date;
	
	public Integer getPost_id() {
		return post_id;
	}
	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
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
	public Date getDate_created() {
		return date_created;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	public Date getPost_due_date() {
		return post_due_date;
	}
	public void setPost_due_date(Date post_due_date) {
		this.post_due_date = post_due_date;
	}
	
}
