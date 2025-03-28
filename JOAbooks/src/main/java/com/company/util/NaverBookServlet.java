package com.company.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/books")
public class NaverBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NaverBookServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		
		response.setContentType("text/html; charset=UTF-8");
		try {
			//#1. URL
			//https://openapi.naver.com/v1/search/book.xml	XML
			//https://openapi.naver.com/v1/search/book.json	JSON
			
			String apiurl = "https://openapi.naver.com/v1/search/book.json?query="+URLEncoder.encode("요리","UTF-8");
			URL url = new URL(apiurl);
			
			//#2. HttpURLConnection
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			
			//#3. 요청설정
			conn.setRequestMethod("GET");
			conn.setRequestProperty("X-Naver-Client-Id", "KD2ISyTmcENZ9OM8XeIl");
			conn.setRequestProperty("X-Naver-Client-Secret", "3mM_fEX5ds");
			
			//#4. 응답확인 - 200
			int code = conn.getResponseCode();
			BufferedReader br;
			if (code==200) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			
			//#5. 응답데이터 - xml/json/csv
			String line=""; StringBuffer sb = new StringBuffer();
			while((line=br.readLine())!=null) {sb.append(line+"\n");}
			System.out.println(sb.toString());
			br.close();
			conn.disconnect();
			PrintWriter out = response.getWriter();
			out.println(sb.toString());
		} catch(Exception e) {e.printStackTrace();}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
