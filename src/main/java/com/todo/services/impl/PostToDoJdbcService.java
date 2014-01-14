package com.todo.services.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.dao.PostToDoDao;
import com.todo.dto.Post;
import com.todo.services.PostToDoService;

@Service
public class PostToDoJdbcService implements PostToDoService {

	@Autowired
	private PostToDoDao postToDoDao;
	
	public void setPostToDoDao(PostToDoDao postToDoDao) {
		this.postToDoDao = postToDoDao;
	}

	@Transactional
	@Override
	public void createPost(String post_title,
			String post_desc, Date date_created, Date post_due_date, Integer user_id) throws ParseException{
		postToDoDao.createPost(post_title, post_desc, date_created, post_due_date, user_id);
	}

	@Transactional
	@Override
	public List<Post> getAllPosts(Integer user_id) {
		
		return postToDoDao.getAllPosts(user_id);
	}

}
