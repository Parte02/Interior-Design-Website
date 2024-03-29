package com.project.Project.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Project.bean.ProjectBean;
import com.project.Project.bean.ResponseBean;
import com.project.Project.jdbc.FindProject;


@RestController
@CrossOrigin("*")
public class FindProjectController {

	@RequestMapping(value="getProject/{id}",method = RequestMethod.POST)
	public ResponseBean findProject (@PathVariable String id ) {	

		
		FindProject findObj=new FindProject();
		System.out.println("findProject");
		List<ProjectBean> projectBeans= (List<ProjectBean>) findObj.findProject(id);
		ResponseBean responseBean=new ResponseBean();
		responseBean.setProjectBeans(projectBeans);
		return responseBean;
	}
	
}
