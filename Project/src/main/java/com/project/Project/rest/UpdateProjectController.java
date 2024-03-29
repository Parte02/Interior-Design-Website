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
import com.project.Project.jdbc.RegisterForm;
import com.project.Project.jdbc.UpdateProject;

@RestController
@CrossOrigin("*")
public class UpdateProjectController {
	@RequestMapping(value="updateProject/{id}",method = RequestMethod.POST)
	public ResponseBean updateProject(@RequestBody ProjectBean projectBean, @PathVariable String id) {
		

		UpdateProject updateObj=new UpdateProject();
		System.out.println("updateProject"+projectBean);
		return updateObj.updateProject(projectBean,id);
	}

}
