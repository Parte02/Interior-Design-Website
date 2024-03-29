package com.project.Project.rest;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.Project.bean.ImageBean;
import com.project.Project.bean.ResponseBean;
import com.project.Project.jdbc.InsertImage;

@RestController
@CrossOrigin("*")
public class ImageRestController {
	@PostMapping("/uploadFile/{id}")
    public String uploadFile(@RequestParam("file") MultipartFile file,@PathVariable int id) throws IllegalStateException, IOException {
        
		String fileName = file.getResource().getFilename();
		file.transferTo(new File("E:\\apache-tomcat-9.0.78\\webapps\\id-images\\"+fileName));
		
		System.out.println("ID="+id);
		
		InsertImage imageObj=new InsertImage();
		int pkid = 0;
		imageObj.insertImage(new ImageBean(pkid, fileName, id));
		
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return fileName + "<===>"+fileDownloadUri;
    }
}
