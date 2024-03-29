package com.project.Project.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Project.bean.BookBean;
import com.project.Project.bean.ResponseBean;
import com.project.Project.jdbc.BookForm;

@RestController
@CrossOrigin("*")
public class BookController {
	@RequestMapping(value="BookForm",method = RequestMethod.POST)
	public ResponseBean insertBook(@RequestBody BookBean bookBean) {
		
		

		BookForm bookObj=new BookForm();
		System.out.println("insertBook="+bookBean);
		return bookObj.insertBook(bookBean);
}
}
