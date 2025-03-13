package com.company.java018;

import java.io.File;
import java.io.IOException;

public class Repeat003 {
	public static void main(String[] args) {
		String folder_rel = "src/com/company/java018/";
		String file_rel = "JavaIO002.txt";
		
		File folder = new File(folder_rel); // 경로가있어
		File file = new File(folder_rel+file_rel); //경로 안에 파일이름이 있어
		
		try {
			if(!folder.exists()) {folder.mkdir();} //폴더 없으면 만들어줘
			if(!file.exists()) {file.createNewFile();} //파일 없으면 만들어줘 
			System.out.println("ok");
		} catch(IOException e) { e.printStackTrace(); }
	}

}
