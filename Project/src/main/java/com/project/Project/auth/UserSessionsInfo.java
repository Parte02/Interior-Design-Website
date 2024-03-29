package com.project.Project.auth;

import java.util.HashMap;
import java.util.Map;

import com.project.Project.bean.AuthBean;

public class UserSessionsInfo {

	private static Map<String,AuthBean> userSession=new HashMap<String,AuthBean>();
	
	public static Map<String,AuthBean> getUserSessionInfo(){
		return userSession;
	}
	
	private  UserSessionsInfo() {
		// TODO Auto-generated constructor stub
	}

	public static AuthBean getLoggedUser(String authToken) {
		AuthBean authBean=null;
		if(authToken!=null) {
		 authBean=	UserSessionsInfo.getUserSessionInfo().get(authToken);
		}
		return authBean;
	}
	
}
