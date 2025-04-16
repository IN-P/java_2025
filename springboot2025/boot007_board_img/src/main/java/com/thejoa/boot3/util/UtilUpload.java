package com.thejoa.boot3.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UtilUpload {
	
	//application.properties 변수 recource.path
	@Value("${resource.path}")
	private String uploadPath;
	
	public String fileUpload(MultipartFile file) throws IOException {
		//1. 파일이름 중복안되게 설정
		String save=UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
		//2. 파일업로드기능
		File target=new File(uploadPath, save);
		FileCopyUtils.copy(file.getBytes(),target); //실제파일업로드
		return save;
	}
	
}
