package com.project.Project.rest;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Project.auth.UserSessionsInfo;
import com.project.Project.bean.AuthBean;
import com.project.Project.bean.ProjectBean;
import com.project.Project.bean.ResponseBean;
import com.project.Project.jdbc.ShowProject;

@RestController
@CrossOrigin("*")
public class ShowProjectController {
	@RequestMapping(value="getAllProjectDetails/{authToken}",method = RequestMethod.POST)
	public ResponseBean showProject(@PathVariable String authToken ) {	

		AuthBean authBean=UserSessionsInfo.getLoggedUser(authToken);
		
		if(authBean==null) {
			ResponseBean responseBean=new ResponseBean();
			responseBean.setErrId(401);
			responseBean.setMsg("Authentication Failed");
			return responseBean;
		}
		
		ShowProject showObj=new ShowProject();
		System.out.println("showProject");
		List<ProjectBean> projectBeans= showObj.showProject(null);
		ResponseBean responseBean=new ResponseBean();
		responseBean.setProjectBeans(projectBeans);
		return responseBean;
	}

}
