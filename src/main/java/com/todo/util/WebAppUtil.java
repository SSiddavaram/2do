package com.todo.util;

import javax.el.ELContext;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

public class WebAppUtil {
	
	public static Object getSpringBean(final String beanName){
		ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		return ctx.getBean(beanName);
	}

	public static Object getManagedBean(final String beanName) {
	    FacesContext fc = FacesContext.getCurrentInstance();
	    Object bean = null;
	    
	    try {
	    	if(fc!= null) {
		        ELContext elContext = fc.getELContext();
		        bean = elContext.getELResolver().getValue(elContext, null, beanName);
	    	}
	    } catch (RuntimeException e) {
	        throw new FacesException(e.getMessage(), e);
	    }

	    if (bean == null) {
	        throw new FacesException("Managed bean with name '" + beanName
	            + "' was not found. Check your faces-config.xml or @ManagedBean annotation.");
	    }

	    return bean;
	}
}
