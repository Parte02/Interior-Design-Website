package com.project.Project.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Project.bean.ProjectBean;
import com.project.Project.bean.Project_ImageBean;
import com.project.Project.bean.ResponseBean;
import com.project.Project.jdbc.DisplayImage;
import com.project.Project.jdbc.ShowImage;


@RestController
@CrossOrigin("*")
public class ShowImageController {

	@RequestMapping(value="showImage",method = RequestMethod.POST)
	public ResponseBean showImage( ) {
		
		ShowImage showObj=new ShowImage();
		System.out.println("showImage");
		List<Project_ImageBean> projectImageBeans= (List<Project_ImageBean>) showObj.showImage();
		ResponseBean responseBean=new ResponseBean();
		responseBean.setProjectImageBeans(projectImageBeans);
		return responseBean;
	}
	

	@RequestMapping(value="displayImage/{imgId}",method = RequestMethod.POST)
	public ResponseBean displayImage( @PathVariable String imgId) {
		
		DisplayImage displayObj=new DisplayImage();
		System.out.println("displayImage");
		List<Project_ImageBean> projectImageBeans= (List<Project_ImageBean>) displayObj.displayImage(imgId);
		ResponseBean responseBean=new ResponseBean();
		responseBean.setProjectImageBeans(projectImageBeans);
		return responseBean;
	}
	
}
