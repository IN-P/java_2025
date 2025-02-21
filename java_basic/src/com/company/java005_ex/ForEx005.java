package com.company.java005_ex;

public class ForEx005 {

	public static void main(String[] args) {
		int pieces =0;
		for (char ch='a';ch<='z';ch++) {
			switch (ch) {
			case 'a':pieces+=1; break;
			case 'e':pieces+=1; break;
			case 'i':pieces+=1; break;
			case 'o':pieces+=1; break;
			case 'u':pieces+=1; break;
			}			
		}
		System.out.println("a~z까지 모음의 갯수는 : "+pieces+"개");
	}

}
