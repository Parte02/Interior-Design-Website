package com.project.Project.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Project.bean.ImageBean;
import com.project.Project.bean.ProjectBean;
import com.project.Project.bean.ResponseBean;
import com.project.Project.jdbc.FindImage;
import com.project.Project.jdbc.FindProject;
import com.project.Project.jdbc.ShowImage;

@RestController
@CrossOrigin("*")
public class FindImageController {

	@RequestMapping(value="findImage/{id}",method = RequestMethod.POST)
	public ResponseBean findImage(@PathVariable String id) {
		
		FindImage findObj=new FindImage();
		System.out.println("findImage");
		List<ImageBean> imageBeans= (List<ImageBean>) findObj.findImage(id);
		ResponseBean responseBean=new ResponseBean();
		responseBean.setImageBeans(imageBeans);
		return responseBean;
	}
	

	
}
