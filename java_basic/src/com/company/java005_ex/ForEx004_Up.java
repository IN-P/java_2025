package com.company.java005_ex;

public class ForEx004_Up {

	public static void main(String[] args) {
		int pieces =0;
		String result="";
		for (int i=1;i<=10;i++) {
			if(i%3==0) {
				pieces+=1;
				result+=""+i;
				if(i<9) {result+=",";}
			}
			
		}
		System.out.println("3의배수 : "+result);
		System.out.println("갯수 : "+pieces+"개");
	}

}
