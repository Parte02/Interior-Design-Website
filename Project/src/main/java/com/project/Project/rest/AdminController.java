package com.project.Project.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Project.bean.BookBean;
import com.project.Project.bean.ContactBean;
import com.project.Project.bean.RegisterBean;
import com.project.Project.bean.ResponseBean;
import com.project.Project.jdbc.DeleteBook;
import com.project.Project.jdbc.DeleteContact;
import com.project.Project.jdbc.DeleteUser;
import com.project.Project.jdbc.DisplayBook;
import com.project.Project.jdbc.DisplayContact;
import com.project.Project.jdbc.DisplayRegister;
import com.project.Project.jdbc.GetUser;
import com.project.Project.jdbc.UpdateUser;


@RestController
@CrossOrigin("*")
public class AdminController {

	@RequestMapping(value="getUser",method = RequestMethod.POST)
	public ResponseBean displayRegister () {	

		
		DisplayRegister displayObj=new DisplayRegister();
		System.out.println("findUser");
		List<RegisterBean> registerBeans= (List<RegisterBean>) displayObj.displayRegister();
		ResponseBean responseBean=new ResponseBean();
		responseBean.setRegisterBeans(registerBeans);
		return responseBean;

}

	@RequestMapping(value="deleteUser/{id}",method = RequestMethod.POST)
	public ResponseBean deleteUser(@PathVariable String id) {
		
		DeleteUser deleteObj=new DeleteUser();
		System.out.println("deleteUser");
		List<RegisterBean> registerBeans= (List<RegisterBean>) deleteObj.deleteUser(id);
		ResponseBean responseBean=new ResponseBean();
		responseBean.setRegisterBeans(registerBeans);
		return responseBean;
	}
	
	@RequestMapping(value="updateUser/{id}",method = RequestMethod.POST)
	public ResponseBean updateUser(@RequestBody RegisterBean registerBean, @PathVariable String id) {
		

		UpdateUser updateObj=new UpdateUser();
		System.out.println("updateProject"+registerBean);
		return updateObj.updateUser(registerBean,id);
	}
	
	@RequestMapping(value="getUser/{id}",method = RequestMethod.POST)
	public ResponseBean getUser (@PathVariable String id ) {	

		
		GetUser getObj=new GetUser();
		System.out.println("getUser");
		List<RegisterBean> registerBeans= (List<RegisterBean>) getObj.getUser(id);
		ResponseBean responseBean=new ResponseBean();
		responseBean.setRegisterBeans(registerBeans);
		return responseBean;
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="getContact",method = RequestMethod.POST)
	public ResponseBean displayContact () {	

		
		DisplayContact displayObj=new DisplayContact();
		System.out.println("findContact");
		List<ContactBean> contactBeans= (List<ContactBean>) displayObj.displayContact();
		ResponseBean responseBean=new ResponseBean();
		responseBean.setContactBeans(contactBeans);
		return responseBean;

}
	

	@RequestMapping(value="deleteContact/{id}",method = RequestMethod.POST)
	public ResponseBean deleteContact(@PathVariable String id) {
		
		DeleteContact deleteObj=new DeleteContact();
		System.out.println("deleteContact");
		List<ContactBean> contactBeans= (List<ContactBean>) deleteObj.deleteContact(id);
		ResponseBean responseBean=new ResponseBean();
		responseBean.setContactBeans(contactBeans);
		return responseBean;
	}
	

	
	@RequestMapping(value="getBook",method = RequestMethod.POST)
	public ResponseBean displayBook() {	

		
		DisplayBook displayObj=new DisplayBook();
		System.out.println("findContact");
		List<BookBean> bookBeans= (List<BookBean>) displayObj.displayBook();
		ResponseBean responseBean=new ResponseBean();
		responseBean.setBookBeans(bookBeans);
		return responseBean;

}
	@RequestMapping(value="deleteBook/{id}",method = RequestMethod.POST)
	public ResponseBean deleteBook(@PathVariable String id) {
		
		DeleteBook deleteObj=new DeleteBook();
		System.out.println("deleteContact");
		List<BookBean> bookBeans= (List<BookBean>) deleteObj.deleteBook(id);
		ResponseBean responseBean=new ResponseBean();
		responseBean.setBookBeans(bookBeans);
		return responseBean;
	}
	
	
	
}