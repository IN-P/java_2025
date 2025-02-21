package com.company.java005_ex;

public class ForEx003_Up {

	public static void main(String[] args) {
//		int sum=0;
//		String result="";
//		for(int i=1;i<=10;i++) {
//			sum+=i;
//			result+=""+i;
//			if(i<10) {result+="+";}
//			}
//		System.out.println(result+"="+sum);
		
		//삼항 연산자로 압축해보기
		for(int i=1,sum=0;i<=10;i++) {sum+=i; System.out.print(i+(i==10?"="+sum:"+"));}
	}

}
