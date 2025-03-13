package com.company.java018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class Network003_book {
	public static void main(String[] args) {
		try {
			//#1. URL
			//https://openapi.naver.com/v1/search/book.xml	XML
			//https://openapi.naver.com/v1/search/book.json	JSON
			
			String apiurl = "https://openapi.naver.com/v1/search/book.json?query="+URLEncoder.encode("물고기","UTF-8");
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
			
		} catch(Exception e) {e.printStackTrace();}
	}
}

/*

#1.
Client ID : KD2ISyTmcENZ9OM8XeIl
Client secret : 3mM_fEX5ds

#2. URL
https://openapi.naver.com/v1/search/book.xml	XML
https://openapi.naver.com/v1/search/book.json	JSON

#3. 요청정보
* GET
* query / UTF-8로 인코딩 쿼리 스트링 형식 - 요청사항 주쇼표시창줄로 데이터 넘기기
> X-Naver-Client-Id: {애플리케이션 등록 시 발급받은 클라이언트 아이디 값}
> X-Naver-Client-Secret: {애플리케이션 등록 시 발급받은 클라이언트 시크릿 값}

*/

