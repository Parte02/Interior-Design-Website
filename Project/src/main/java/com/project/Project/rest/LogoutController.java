package com.project.Project.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Project.auth.UserSessionsInfo;
import com.project.Project.bean.ResponseBean;

@RestController
@CrossOrigin("*")
public class LogoutController {
	
	@RequestMapping(value="Logout/{token}",method = RequestMethod.POST)
	public ResponseBean logout(@PathVariable String token) {
		ResponseBean responseBean=new ResponseBean();
		System.out.println("=="+UserSessionsInfo.getUserSessionInfo());
		
		if(UserSessionsInfo.getUserSessionInfo().containsKey(token)) {
			
		UserSessionsInfo.getUserSessionInfo().remove(token);
		responseBean.setErrId(-1);
		responseBean.setMsg("Succesfully Removed");
		}
		else {
			responseBean.setErrId(401);
			responseBean.setMsg("Unable to Logout");
		}
		return responseBean;
	}
}