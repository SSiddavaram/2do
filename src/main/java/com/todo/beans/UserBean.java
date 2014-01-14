package com.todo.beans;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import com.todo.dto.User;
import com.todo.services.UserService;
import com.todo.util.WebAppUtil;

@ManagedBean(name = "userBean")
@ViewScoped
public class UserBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
    private String password;
   // private String user_display_name;
    private String name;
    
   /* @ManagedProperty(value="#{userJdbcService}")
    private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}*/

	public static UserService getUserService(){
		
		return (UserService)WebAppUtil.getSpringBean("userJdbcService");
	}
	
	private UserContextBean getUserSessionContext(){
		return (UserContextBean)WebAppUtil.getManagedBean("userContextBean");
	}

	public void doLogin(String username, String password){
		User userContext = new User();
		userContext = getUserService().getUser(username, password);
		getUserSessionContext().setUserContext(userContext);
		//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userContext", userContext);
	}
	
	public String loginAction(){
		doLogin(getUsername(), getPassword());
		if(getUserSessionContext().getUserContext()!=null){
			return "success";
		}else{
			FacesMessage msg = new FacesMessage();
			msg.setSummary("Invalid username or password");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "";
		}
		
	}
	
	public String signUpAction(){
		Date date = new Date();
		User userContext = new User();
		userContext = getUserService().createUser(username, password, date, name);
		getUserSessionContext().setUserContext(userContext);
		if(getUserSessionContext().getUserContext()!=null){
			return "success";
		}else{
			FacesMessage msg = new FacesMessage();
			msg.setSummary("Invalid username or password");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "";
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
