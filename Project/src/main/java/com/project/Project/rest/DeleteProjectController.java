package com.project.Project.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Project.bean.ImageBean;
import com.project.Project.bean.ProjectBean;
import com.project.Project.bean.ResponseBean;
import com.project.Project.jdbc.DeleteProject;
import com.project.Project.jdbc.FindImage;

@RestController
@CrossOrigin("*")
public class DeleteProjectController {
	@RequestMapping(value="deleteProject/{id}",method = RequestMethod.POST)
	public ResponseBean deleteProject(@PathVariable String id) {
		
		DeleteProject deleteObj=new DeleteProject();
		System.out.println("deleteProject");
		List<ProjectBean> projectBeans= (List<ProjectBean>) deleteObj.deleteProject(id);
		ResponseBean responseBean=new ResponseBean();
		responseBean.setProjectBeans(projectBeans);
		return responseBean;
	}

}
