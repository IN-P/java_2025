package com.company.java005_ex;

public class ForEx004 {

	public static void main(String[] args) {
		int pieces =0;
		for (int i=1;i<=10;i++) {
			if(i%3==0) {pieces+=1;}
		}
		System.out.println("1~10까지 3의 배수의 갯수는 : "+pieces+"개");
	}

}
