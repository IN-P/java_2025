package com.company.miniproject;

import java.util.Arrays;
import java.util.Scanner;

public class BankProject_v2_0_1 {

	public static void main(String[] args) {
		System.out.println("WELCOME! (주)CODEJOHNS_BANK");
		Scanner scan = new Scanner(System.in);
		String[][] user = new String[3][3]; //{id,pwd,cash}*3
		
		while(true) {
			System.out.println(Arrays.deepToString(user));//상태확인
			showMenu(); int input=scan.nextInt(); //메뉴출력,기능번호입력
			
			switch(input) {
			case 1: signUp(user,scan); break; //회원가입 
			case 2: case 3: case 4: case 5:
				int index=infoChk(user,scan);//회원정보확인후 해당 인덱스 반환
				if(index==-77) {System.out.println("정보를 다시 확인해주세요."); break;}//특정기능:기능초기화
				switch(input) {//확인완료되면 각기능 시작
				case 2: showUser(user,index); break;
				case 3: deposit(user,index,scan); break;
				case 4: withdraw(user,index,scan); break;
				case 5: delete(user,index,scan); break; 
				} break; //END case 2,3,4,5
			case 9: scan.close(); return;
			} 
		}
	}
	//메뉴출력 메소드
	public static void showMenu() { 
		System.out.println("=====BANK=====\n* 1.추가\n* 2.조회\n* 3.입금\n* 4.출금\n* 5.삭제\n* 9.종료");
		System.out.print("입력>>> ");
	} 
	//회원가입 메소드
	public static void signUp(String[][] user,Scanner scan) { 
		for(int i=0,count=0;i<3;i++) {
			if(user[i][0]==null) {
				System.out.print("아이디 입력 : ");user[i][0]=scan.next();
				System.out.print("비밀번호 입력 : ");user[i][1]=scan.next();
				System.out.print("잔액 입력 : ");user[i][2]=scan.next();
				break;
			}
			count++;//차있는 배열마다 카운트 증가 시키고 카운트가 한계에 도닥하면 비어있는 배열이 존재하지 않음
			if(count==3) System.out.println("더이상 가입할 수 없습니다.");	
		}
	}
	//회원정보확인 메소드 : 회원정보확인후 해당 인덱스 반환
	public static int infoChk(String[][] user,Scanner scan) {
		System.out.print("\n아이디 입력 : ");String tempid=scan.next();
		System.out.print("비밀번호 입력 : ");String temppwd=scan.next();
		for(int i=0;i<3;i++){if(user[i][0]!=null&&user[i][0].equals(tempid)&&user[i][1].equals(temppwd)) return i;}//null인 문자열은 비교할 수 없다.
		return -77; //전부 확인해서 정보가 틀리거나 없으면 특정기능 인덱스 반환
	}
	//회원정보 메소드
	public static void showUser(String[][] user,int index) {
		System.out.printf("==계좌조회\nID : %s\nPASS : %s\n잔액 : %s\n",user[index][0],user[index][1],user[index][2]);
	}
	//입금 메소드
	public static void deposit(String[][] user,int index,Scanner scan) {
		long cash = Long.parseLong(user[index][2]); //문자열을 숫자로 변환
		System.out.print("입금 : ");cash+=scan.nextLong();
		user[index][2] = Long.toString(cash);
		System.out.println("==입금완료\n잔액 : "+user[index][2]);
	}
	//출금 메소드
	public static void withdraw(String[][] user,int index,Scanner scan) {
		long cash = Long.valueOf(user[index][2]);
		System.out.print("출금 : ");long under=scan.nextLong();
		if(under>cash) {System.out.println("잔액을 초과한 금액은 출금할수 없습니다.");return;}
		cash-=under;//출금시 마이너스가 안될수 있게 조건 추가
		user[index][2]=String.valueOf(cash);
		System.out.println("==출금완료\n잔액 : "+user[index][2]);
	}
	//회원탈퇴 메소드
	public static void delete(String[][] user,int index,Scanner scan) {
		System.out.println("계좌를 삭제하시겠습니까? (Y/N)");char select = scan.next().charAt(0);
		if(select=='y'||select=='Y') {user[index][0]=null;user[index][1]=null;user[index][2]=null;}
	}
}

