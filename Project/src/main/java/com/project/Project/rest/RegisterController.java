package com.project.Project.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Project.bean.RegisterBean;
import com.project.Project.bean.ResponseBean;
import com.project.Project.jdbc.RegisterForm;

@RestController
@CrossOrigin("*")
public class RegisterController {
	@RequestMapping(value="RegisterForm",method = RequestMethod.POST)
	public ResponseBean insertRegister(@RequestBody RegisterBean registerBean) {
		
		RegisterForm registerObj=new RegisterForm();
		System.out.println("insertRegister"+registerBean);
		return registerObj.insertRegister(registerBean);
	
	}
}

