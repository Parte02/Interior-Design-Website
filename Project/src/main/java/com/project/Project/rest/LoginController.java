package com.project.Project.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Project.auth.UserSessionsInfo;
import com.project.Project.bean.AuthBean;
import com.project.Project.bean.LoginBean;
import com.project.Project.bean.ProjectBean;
import com.project.Project.bean.Project_ImageBean;
import com.project.Project.bean.RegisterBean;
import com.project.Project.bean.ResponseBean;
import com.project.Project.jdbc.DisplayImage;
import com.project.Project.jdbc.FindProject;
import com.project.Project.jdbc.LoginForm;


@RestController
@CrossOrigin("*")
public class LoginController {
	@RequestMapping(value="LoginForm",method = RequestMethod.POST)
	public ResponseBean insertLogin(@RequestBody LoginBean loginBean) {
		
		LoginForm loginObj=new LoginForm();
		System.out.println("insertLogin"+loginBean);
		return loginObj.insertLogin(loginBean);
	
	}
	
	





}
