package com.company.boot008.util5_kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Component
public class KaKaoLogin {
	@Value("${kakao_redirect_url}")
	private String kakao_redrirect_url;
	
	@Value("${kakao_api}")
	private String kakao_api;
	
	// 1. login - 인증(사용자신원확인), 인가(접근권한)
	public String step1() {
		return "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id="
				+ kakao_api
				+"&redirect_uri="
				+ kakao_redrirect_url;
	}
	
	// 2. code - 인가코드를 토큰으로
	public List<String> step2(String code) { // code 
		System.out.println("..........step1)"+code);
		String tokenUrl="https://kauth.kakao.com/oauth/token";
		tokenUrl +="?grant_type=authorization_code"
					+"&client_id="+kakao_api
					+"&redirect_uri="+kakao_redrirect_url
					+"&code="+code;
		//POST
		//Content-Type: application/x-www-form-urlencoded;charset=utf-8
		URL url = null;
		HttpURLConnection conn = null;
		BufferedReader br = null;
		String line="";
		StringBuffer buffer = new StringBuffer();
		String resultToken="";
		
		try {
			url = new URL(tokenUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
			
			if(conn.getResponseCode() == 200) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			}else {
				br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			
			while((line=br.readLine())!=null) {
				buffer.append(line);
			}
			
			br.close();
			conn.disconnect();
			resultToken = buffer.toString();
			System.out.println("..........."+resultToken);
			
		} catch (MalformedURLException e) { e.printStackTrace();
		} catch (IOException e) { e.printStackTrace(); }
		
		//..........step1)hFDPWolwbcff-duuEYClG4407bknWfuR3xEGa2k2si6Mv6ep2uutjgAAAAQKDSCbAAABlkbPhC1b9Pmr5eg_ZA
		//...........{"access_token":"uWHahHAcZW0kZpIl5sfYXLi_RvCBz_hQAAAAAQoNDSEAAAGWRs-Fn5QkbXeV0h_w","token_type":"bearer","refresh_token":"XJtLiX92XcaNDueMMhg_9egQKZ8O3ZoXAAAAAgoNDSEAAAGWRs-FlpQkbXeV0h_w","expires_in":21599,"scope":"profile_image profile_nickname","refresh_token_expires_in":5183999}
		JsonObject job = JsonParser.parseString(resultToken).getAsJsonObject();
		String token = job.get("access_token").getAsString();
		
		System.out.println("........"+token);
		
		return step3(token);//마지막수정
	}
	
	//사용자정보가져오기
	// nickname, profile_img
	/*
	curl -v -X POST "https://kapi.kakao.com/v2/user/me" \
    -H "Content-Type: application/x-www-form-urlencoded;charset=utf-8" \
    -H "Authorization: Bearer ${ACCESS_TOKEN}" \
    --data-urlencode 'property_keys=["kakao_account.email"]'
	*/
	public List<String> step3(String token) { // code 
		
		System.out.println("..........step2)"+token);
		List<String> userinfos = new ArrayList<>();
		
		String userUrl="https://kapi.kakao.com/v2/user/me";
	
		URL url = null;
		HttpURLConnection conn = null;
		BufferedReader br = null;
		String line="";
		StringBuffer buffer = new StringBuffer();
		String result="";
		
		try {
			url = new URL(userUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
			conn.setRequestProperty("Authorization","Bearer "+token); //Bearer 띄어쓰기 확인
			
			if(conn.getResponseCode() == 200) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			}else {
				br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			
			while((line=br.readLine())!=null) {
				buffer.append(line);
			}
			
			br.close();
			conn.disconnect();
			
		} catch (MalformedURLException e) { e.printStackTrace();
		} catch (IOException e) { e.printStackTrace(); }
		
		result = buffer.toString();
		JsonObject job = JsonParser.parseString(result).getAsJsonObject();
		
		System.out.println("........"+result);
		//step2)Fq3swBDkpN3tJrCKUDXLojOjxdSKdY9kAAAAAQoXC9cAAAGWRwK6OpQkbXeV0h_w
		//{"id":4221817530,"connected_at":"2025-04-18T02:52:07Z","properties":{"nickname":"박인","profile_image":"http://img1.kakaocdn.net/thumb/R640x640.q70/?fname=http://t1.kakaocdn.net/account_images/default_profile.jpeg","thumbnail_image":"http://img1.kakaocdn.net/thumb/R110x110.q70/?fname=http://t1.kakaocdn.net/account_images/default_profile.jpeg"},"kakao_account":{"profile_nickname_needs_agreement":false,"profile_image_needs_agreement":false,"profile":{"nickname":"박인","thumbnail_image_url":"http://img1.kakaocdn.net/thumb/R110x110.q70/?fname=http://t1.kakaocdn.net/account_images/default_profile.jpeg","profile_image_url":"http://img1.kakaocdn.net/thumb/R640x640.q70/?fname=http://t1.kakaocdn.net/account_images/default_profile.jpeg","is_default_image":true,"is_default_nickname":false}}}
		
		userinfos.add(job.getAsJsonObject("properties").get("nickname").getAsString());
		userinfos.add(job.getAsJsonObject("properties").get("profile_image").getAsString());
		
		
		
		return userinfos;//마지막수정
	}
	
	
	
	
}

/*
curl -v -X POST "https://kauth.kakao.com/oauth/token" \
    -H "Content-Type: application/x-www-form-urlencoded;charset=utf-8" \
    -d "grant_type=authorization_code" \
    -d "client_id=${REST_API_KEY}" \
    --data-urlencode "redirect_uri=${REDIRECT_URI}" \
    -d "code=${AUTHORIZE_CODE}" 
*/
