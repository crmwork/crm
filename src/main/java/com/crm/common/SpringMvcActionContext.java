package com.crm.common;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class SpringMvcActionContext extends SpringMvcContextHolder {

//	public SpringMvcActionContext getActionContext() {
//		return RequestContextHolder.
//	}
	
	public static HttpServletRequest getRequest() {
//		return (HttpServletRequest)currentRequestAttributes();
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	public static HttpServletResponse getResponse() {
		return ((ServletWebRequest) RequestContextHolder.getRequestAttributes()).getResponse();
	}
	public static Map<String, Object> getApplication() {
		return new HashMap<String,Object>();
//		return ActionContext.getContext().getApplication();
	}

	public static HttpSession getSession() {
		return getRequest().getSession();
	}

}
