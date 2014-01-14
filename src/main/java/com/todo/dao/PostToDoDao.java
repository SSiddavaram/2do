package com.todo.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.todo.dto.Post;

public interface PostToDoDao {

	void createPost(String post_title, String post_desc, Date date_created, Date post_due_date, Integer user_id) throws ParseException;
	
	List<Post> getAllPosts(Integer user_id);
}
