package com.todo.util;

import java.util.HashMap;
import java.util.Map;

public class TodoWebConstants {
	
	public static final String HOME_MENU_SELECTED = "home";
	public static final String POSTS_MENU_SELECTED = "posts";
	public static final String POST_TO_DO_MENU_SELECTED = "postToDo";
	public static final String ABOUT_MENU_SELECTED = "about";
	
	public static final String HOME_VIEW_ID="/common/homePage.xhtml";
	public static final String POSTS_VIEW_ID="/common/posts.xhtml";
	public static final String POST_TODO_VIEW_ID="/common/postToDo.xhtml";
	public static final String ABOUT_VIEW_ID="/common/about.xhtml";
	
	public static final Map<String, String> viewToSelectedMenuMapping = new HashMap<String, String>(15);
	static
	{
		viewToSelectedMenuMapping.put(HOME_VIEW_ID, HOME_MENU_SELECTED);
		viewToSelectedMenuMapping.put(POSTS_VIEW_ID, POSTS_MENU_SELECTED);
		viewToSelectedMenuMapping.put(POST_TODO_VIEW_ID, POST_TO_DO_MENU_SELECTED);
		viewToSelectedMenuMapping.put(ABOUT_VIEW_ID, ABOUT_MENU_SELECTED);
	}

}
