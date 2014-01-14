package com.todo.beans;

import java.io.Serializable;
import com.todo.util.TodoWebConstants;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "commonNavigationBean")
@SessionScoped
public class CommonNavigationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String selected_menu;
	
	@PostConstruct
	public void initCommonNavigationBean(){
		setSelected_menu(TodoWebConstants.HOME_MENU_SELECTED);
	}
	
	public void setSelectedMenuOnPageLoad(){
		String viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
		setSelected_menu(TodoWebConstants.viewToSelectedMenuMapping.get(viewId));
		System.out.println("selected menu -----------" +getSelected_menu()+"view ID ----------"+viewId);
	}

	public String getSelected_menu() {
		return selected_menu;
	}

	public void setSelected_menu(String selected_menu) {
		this.selected_menu = selected_menu;
	}
	
}
