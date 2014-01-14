package com.todo.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.todo.dto.Post;
import com.todo.services.PostToDoService;
import com.todo.util.WebAppUtil;

@ManagedBean(name = "postsBean")
@ViewScoped
public class PostsBean {

	private int listOfPostsSize=0;
	private List<Post> todoPostsList = new ArrayList<Post>();
	
	@ManagedProperty("#{postToDoJdbcService}")
	private PostToDoService postToDoService;
	
	public void setPostToDoService(PostToDoService postToDoService) {
		this.postToDoService = postToDoService;
	}

	@PostConstruct
	public void initPostsBean(){
		getAllPosts();
	}
	
	/*public static PostToDoService getPostToDoService(){
		return (PostToDoService)WebAppUtil.getSpringBean("postToDoJdbcService");
	}*/
	
	private UserContextBean getUserSessionContext(){
		return (UserContextBean)WebAppUtil.getManagedBean("userContextBean");
	}
	
	public List<Post> getAllPosts(){
		todoPostsList = postToDoService.getAllPosts(getUserSessionContext().getUserContext().getUser_id());
		if(todoPostsList.isEmpty()){
			listOfPostsSize = 0;
		}else{
			listOfPostsSize = todoPostsList.size();
		}
		
		System.out.println("LIST OF SIZEEEEE ____________________________"+ todoPostsList.size() +todoPostsList.toString());
		
		return todoPostsList;
	}

	public List<Post> getTodoPostsList() {
		return todoPostsList;
	}

	public void setTodoPostsList(List<Post> todoPostsList) {
		this.todoPostsList = todoPostsList;
	}

	public int getListOfPostsSize() {
		return listOfPostsSize;
	}

	public void setListOfPostsSize(int listOfPostsSize) {
		this.listOfPostsSize = listOfPostsSize;
	}
	
}
