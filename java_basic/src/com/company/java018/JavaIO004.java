package com.company.java018;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class JavaIO004 {
	public static void main(String[] args) throws Exception {
		//#1. 경로
		String origin = "src/com/company/java018/bongocat.jpg";
		String target1 = "src/com/company/java018/bongocat1.jpg";
		String target2 = "src/com/company/java018/bongocat2.jpg";
		
		//#2. byte 단위로 이미지파일 읽어들여서 쓰기 (O)
		// bongcat.jpg → bongocat1.jpg
		// InputStream(읽기) / OutpurStream(쓰기)
		InputStream bi = new FileInputStream(origin);
		OutputStream bo = new FileOutputStream(target1);
		
		int cnt1=0;
		while ((cnt1 = bi.read())!=-1) { bo.write((byte)cnt1); }
		bo.flush(); bo.close(); bi.close();
		System.out.println(">> byte 이미지 복사완료!");
		
		//#3. char 단위로 이미지파일 읽어들여서 쓰기 (X)
		// bongcat.jpg → bongocat2.jpg
		// Reader(읽기) / Writer(쓰기)
		Reader cr = new FileReader(origin);
		Writer cw = new FileWriter(target2);
		
		int cnt2=0;
		while ((cnt2 = cr.read())!=-1) { cw.write((char)cnt2); }
		cw.flush(); cw.close(); cr.close();
		System.out.println(">> char 이미지 복사실패!");
		
	}
}
