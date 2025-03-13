package com.company.java018;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;




public class JavaIO002 {
	public static void main(String[] args) {
		//#1. 경로
		String folder_rel = "src/com/company/java018/"; //경로
		String file_rel = "JavaIO002.txt"; //파일이름
		
		// 경로를 선언!(객체화) : 나이런거 쓸꺼야
		File folder = new File(folder_rel);
		// 경로의 파일이름을 선언! (객체화) : 나이런거 쓸꺼야
		File file = new File(folder_rel+file_rel); 

		//#2. 폴더+파일만들기
		try {
			//경로가 없으면 폴더를 만들어줘
			if(!folder.exists()) {folder.mkdir();} 
			//해당 경로의 해당파일이름이 없으면 파일을 만들어줘 
			if(!file.exists()) {file.createNewFile();} 
			System.out.println("ok");
		} catch(Exception e) { e.printStackTrace(); }
		
		//#3. byte 파일쓰기 InputStream > [프로그램] > OutputStream[#] 프로그램기준으로생각 나는 입력할때 프로그램은 출력
		try {
			OutputStream output = new FileOutputStream(file);
			output.write('j');
			output.write('a');
			output.write('v');
			output.write('a');
			output.flush();
			output.close();//닫기
			System.out.println("OutputStream 쓰기완료!");
		} catch (Exception e) {e.printStackTrace();}
		
		//#4. byte 파일읽기 InputStream[#] > [프로그램] > OutputStream 
		try {
			InputStream input = new FileInputStream(file);
			//System.out.println(input.read()); // 문자 - 저장시 숫자, 출력시 문자
			int cnt =0;
			
			while((cnt=input.read())!=-1) {
				System.out.println((char)cnt);
			}
			
			input.close(); //닫기
			
		} catch (Exception e) {e.printStackTrace();}
		
	}

}
