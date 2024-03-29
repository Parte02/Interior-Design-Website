package com.project.Project.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Project.bean.ContactBean;
import com.project.Project.bean.ResponseBean;
import com.project.Project.jdbc.ContactForm;

@RestController
@CrossOrigin("*")
public class ContactController {
	@RequestMapping(value="ContactForm",method = RequestMethod.POST)
	public ResponseBean insertContact(@RequestBody ContactBean contactBean) {
		

		ContactForm contactObj=new ContactForm();
		System.out.println("insertContact"+contactBean);
		return contactObj.insertContact(contactBean);
}
}
