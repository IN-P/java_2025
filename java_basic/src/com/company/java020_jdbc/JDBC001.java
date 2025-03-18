package com.company.java020_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC001 {
	public static void main(String[] args) {
		try {
			//1) 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2) jdbc 연동
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
			if (conn != null) {System.out.println("db연동성공!");}
			conn.close();
		} catch (Exception e) {e.printStackTrace();}
		//mysql -uroot -p
	}
}
