package com.company.miniproject;

import java.util.Scanner;

public class BankProject_v_0_0_0 {

	public static void main(String[] args) {
		System.out.println("WELCOME! (주)CODEJOHNS_BANK");
		Scanner scan = new Scanner(System.in);
		int input=0,age=0;
		long cash=0;
		String id="",pwd="",tempid="",temppwd="";
		while(true) {
			System.out.println("=====BANK=====\n* 1.추가\n* 2.조회\n* 3.입금\n* 4.출금\n* 5.삭제\n* 9.종료");
			System.out.print("입력>>> ");
			input=scan.nextInt();
			switch(input) {
			case 1:
				System.out.print("아이디 입력 : ");
				id=scan.next();
				System.out.print("비밀번호 입력 : ");
				pwd=scan.next();
				System.out.print("나이 입력 : ");
				age=scan.nextInt();
				System.out.print("잔액 입력 : ");
				cash=scan.nextInt();
				break;
			case 2: 
				System.out.print("\n아이디 입력 : ");
				tempid=scan.next();
				System.out.print("비밀번호 입력 : ");
				temppwd=scan.next();
				if(!tempid.equals(id)||!temppwd.equals(pwd)) {System.out.println("다시 확인해주세요.");break;}
				System.out.printf("==계좌조회\nID : %s\nPASS : %s\n나이 : %d\n잔액 : %d\n",id,pwd,age,cash);
				break;
			case 3: 
				System.out.print("\nid : ");
				tempid=scan.next();
				System.out.print("pass : ");
				temppwd=scan.next();
				if(!tempid.equals(id)||!temppwd.equals(pwd)) {System.out.println("다시 확인해주세요.");break;}
				System.out.print("입금 : ");
				cash+=scan.nextInt();
				System.out.println("==입금완료\n잔액 : "+cash);
				break;
			case 4: 
				System.out.print("\nid : ");
				tempid=scan.next();
				System.out.print("pass : ");
				temppwd=scan.next();
				if(!tempid.equals(id)||!temppwd.equals(pwd)) {System.out.println("다시 확인해주세요.");break;}
				System.out.print("출금 : ");
				cash-=scan.nextInt();
				System.out.println("==출금완료\n잔액 : "+cash);
				break;
			case 5: 
				System.out.print("\nid : ");
				tempid=scan.next();
				System.out.print("pass : ");
				temppwd=scan.next();
				if(!tempid.equals(id)||!temppwd.equals(pwd)) {System.out.println("다시 확인해주세요.");break;}
				System.out.println("계좌를 삭제하시겠습니까? (Y/N)");
				char select = scan.next().charAt(0);
				if(select=='y'||select=='Y') {id="";pwd="";age=0;cash=0;}
				break;
			case 9: scan.close(); return;
			}
		}
	}
}

///입력,아이디,비번,나이,잔액
