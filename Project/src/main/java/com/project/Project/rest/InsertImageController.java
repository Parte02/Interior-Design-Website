package com.project.Project.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Project.bean.ImageBean;
import com.project.Project.bean.ResponseBean;
import com.project.Project.jdbc.InsertImage;


@RestController
@CrossOrigin("*")
public class InsertImageController {

	@RequestMapping(value="insertImage",method = RequestMethod.POST)
	public ResponseBean insertImage(@RequestBody ImageBean imageBean , @PathVariable String fkid) {
		


		InsertImage imageObj=new InsertImage();
		System.out.println("insertImage="+imageBean);
		return imageObj.insertImage(imageBean);
}
}
