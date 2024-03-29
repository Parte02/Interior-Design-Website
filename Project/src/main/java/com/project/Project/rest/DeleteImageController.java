package com.project.Project.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Project.bean.ImageBean;
import com.project.Project.bean.ResponseBean;
import com.project.Project.jdbc.DeleteImage;

@RestController
@CrossOrigin("*")
public class DeleteImageController {

	@RequestMapping(value="deleteImage/{id}",method = RequestMethod.POST)
	public ResponseBean deleteImage(@PathVariable String id) {
		
		DeleteImage deleteObj=new DeleteImage();
		System.out.println("deleteImage");
		List<ImageBean> imageBeans= (List<ImageBean>) deleteObj.deleteImage(id);
		ResponseBean responseBean=new ResponseBean();
		responseBean.setImageBeans(imageBeans);
		return responseBean;
	}

}
