package com.project.Project.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Project.bean.ResponseBean;
import com.project.Project.jdbc.Admin;
import com.project.Project.jdbc.FindUser;
import com.project.Project.bean.LoginBean;
import com.project.Project.bean.RegisterBean;

@RestController
@CrossOrigin("*")
public class FindController {
	@RequestMapping(value="Find",method = RequestMethod.POST)
	public ResponseBean findUser(@RequestBody RegisterBean registerBean) {
		
		System.out.println("RegisterBean:"+registerBean);
		FindUser findObj=new FindUser();
		System.out.println("FindUser"+registerBean);
		return findObj.findUser(registerBean);
		
	}
	@RequestMapping(value="admin",method = RequestMethod.POST)
	public ResponseBean admin(@RequestBody RegisterBean registerBean) {
		
		System.out.println("RegisterBean:"+registerBean);
		Admin adminObj=new Admin();
		System.out.println("FindUser"+registerBean);
		return adminObj.admin(registerBean);
		
	}
}
