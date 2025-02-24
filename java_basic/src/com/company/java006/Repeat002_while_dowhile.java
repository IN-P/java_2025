package com.company.java006;

public class Repeat002_while_dowhile {

	public static void main(String[] args) {
		//1. for (반복횟수를 알때)
		// 1 2 3 
		for (int i=1;i<=3;i++) {System.out.print(i+"\t");} System.out.println();
		
		//2. while 반복횟수를 모를때 - 게시판
		int i=1;
		while (i<=3) {
			System.out.print(i+"\t");
			i++;
		} System.out.println();
		
		//3. do while (무조건 한번은 실행)
		
		int a=1;
		do {
			System.out.print(a+"\t");
			a++;
		}while (a<=3); 
		
	}

}
