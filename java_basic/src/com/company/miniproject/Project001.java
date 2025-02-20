package com.company.miniproject;

import java.util.Scanner;

public class Project001 {

	public static void main(String[] args) {
		//변수
		Scanner scan = new Scanner(System.in);
		int input=0,age=0;
		long cash=0;
		String id="",pwd="";
		while(true) {
			System.out.println("=====BANK=====\\n* 1.추가\\n* 2.조회\\n* 3.입금\\n* 4.출금\\n* 5.삭제\\n* 9.종료");
			System.out.print("입력>>> ");
			input=scan.nextInt();
			switch(input) {
			case 1:
				System.out.print("아이디 입력 : ");
				id+=scan.next();
				System.out.print("비밀번호 입력 : ");
				pwd+=scan.next();
				System.out.print("나이 입력 : ");
				age+=scan.nextInt();
				System.out.print("잔액 입력 : ");
				cash+=scan.nextInt();
				break;
			case 2: 
				System.out.print("아이디 입력 : ");
				String tempid=scan.next();
				System.out.print("비밀번호 입력 : ");
				String temppwd=scan.next();
				if(tempid!=id||temppwd!=pwd) {}
				break;
			case 3: 
				
				break;
			case 4: 
				
				break;
			case 5: 
				
				break;
			case 9: 
				
				return;
			}
		}
	}
}

///입력,아이디,비번,나이,잔액
