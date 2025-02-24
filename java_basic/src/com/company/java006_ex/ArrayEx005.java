package com.company.java006_ex;

import java.util.Arrays;

public class ArrayEx005 {

	public static void main(String[] args) {
		char[] ch = {'B','a','n','a','n','a'};
		int up=0,low=0;
		for (int i=0;i<ch.length;i++) {
			up+=ch[i]>=65&&ch[i]<=90?1:0;
			low+=ch[i]>='a'&&ch[i]<='z'?1:0;
		}
		System.out.println("대문자의 갯수 : "+up+"\n소문자의 갯수 : "+low);
		
		//번외 : 대소문자를 바꿔서 출력
		char[] ch1 = {'B','a','n','a','n','a'};
		for (int i=0;i<ch1.length;i++) {
			System.out.print(ch1[i]>='a'&&ch[i]<='z'?(char)(ch1[i]-32)+"\t":(char)(ch1[i]+32)+"\t");
		}
		System.out.println(Arrays.toString(ch));//배열안의 원소들을 문자열로 출력
		
	}

}
