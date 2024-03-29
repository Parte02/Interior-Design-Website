package com.project.Project.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Project.auth.UserSessionsInfo;
import com.project.Project.bean.AuthBean;
import com.project.Project.bean.ProjectBean;
import com.project.Project.bean.ResponseBean;
import com.project.Project.jdbc.Project;
import com.project.Project.jdbc.ShowProject;


@RestController
@CrossOrigin("*")
public class ProjectRestController {

	@RequestMapping(value="createProject/{authToken}",method = RequestMethod.POST)
	public ResponseBean insertProject(@RequestBody ProjectBean projectBean , @PathVariable String authToken) {	

		
		
		AuthBean authBean=UserSessionsInfo.getLoggedUser(authToken);
		
		if(authBean==null) {
			ResponseBean responseBean=new ResponseBean();
			responseBean.setErrId(401);
			responseBean.setMsg("Authentication Failed");
			return responseBean;
		}
			
			Project projectObj=new Project();
			System.out.println("insertProject"+projectBean);
			return projectObj.insertProject(projectBean);
			
	}
		
}
	
	