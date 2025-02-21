package com.company.miniproject;

import java.util.Scanner;

public class Bank003 {

	public static void main(String[] args) {
		System.out.println("WELCOME! (주)CODEJOHNS_BANK");
		Scanner scan = new Scanner(System.in);
		int age=0;
		long cash=0;
		String id="",pwd="";
		while(true) {
			System.out.println("=====BANK=====\n* 1.추가\n* 2.조회\n* 3.입금\n* 4.출금\n* 5.삭제\n* 9.종료");
			System.out.print("입력>>> ");
			int input=scan.nextInt();
			
			switch(input) {
			case 1:
				System.out.print("아이디 입력 : ");id=scan.next();
				System.out.print("비밀번호 입력 : ");pwd=scan.next();
				System.out.print("나이 입력 : ");age=scan.nextInt();
				System.out.print("잔액 입력 : ");cash=scan.nextInt();
			break;
			
			case 2: case 3: case 4: case 5: 
				System.out.print("\n아이디 입력 : ");String tempid=scan.next();
				System.out.print("비밀번호 입력 : ");String temppwd=scan.next();
				if(!tempid.equals(id)||!temppwd.equals(pwd)) {System.out.println("다시 확인해주세요.");break;}
				
				switch(input) {
				case 2: 
					System.out.printf("==계좌조회\nID : %s\nPASS : %s\n나이 : %d\n잔액 : %d\n",id,pwd,age,cash);
				break;
				
				case 3: 
					System.out.print("입금 : ");cash+=scan.nextInt();
					System.out.println("==입금완료\n잔액 : "+cash);
				break;
				
				case 4:
					System.out.print("출금 : ");long under=scan.nextInt();
					if(under>cash) {System.out.println("잔액보다 많은 금액은 출금할수 없습니다.");break;}
					cash-=under;//출금시 마이너스가 안될수 있게 조건 추가
					System.out.println("==출금완료\n잔액 : "+cash);
				break;
				
				case 5: 
					System.out.println("계좌를 삭제하시겠습니까? (Y/N)");char select = scan.next().charAt(0);
					if(select=='y'||select=='Y') {id="";pwd="";age=0;cash=0;}
				break;
				}
			break;
			
			case 9: scan.close(); return;
			}
		}
	}
}

///입력,아이디,비번,나이,잔액
///반복{
///  제어1)입력
///
///  제어2,3,4,5){
///	   (공통)아이디 비번 체크
///	   (각번호제어)각처리할 일
///	 }
///
///	 제어9)종료
///}
