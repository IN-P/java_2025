package com.company.java005_ex;

public class ForEx003_Up {

	public static void main(String[] args) {
		int sum=0;
		String result="";
		for(int i=1;i<=10;i++) {
			sum+=i;
			result+=""+i;
			if(i<10) {result+="+";}
			}
		System.out.println(result+"="+sum);
	}

}
