package com.company.miniproject;

import java.util.Arrays;
import java.util.Scanner;

public class Bank005 {
	//회원정보 전역변수로 설정
	static Scanner scan = new Scanner(System.in);
	static int[] age = new int[3]; 
	static long[] cash = new long[3];
	static String[] id = new String[3];
	static String[] pwd = new String[3];
	
	public static void manu() {
		System.out.println("=====BANK=====\n* 1.추가\n* 2.조회\n* 3.입금\n* 4.출금\n* 5.삭제\n* 9.종료");
		System.out.print("입력>>> ");
	}
	
	public static void a(){}
	
	public static void main(String[] args) {

		System.out.println("WELCOME! (주)CODEJOHNS_BANK");

		while(true) {
			System.out.println(Arrays.toString(id));
			manu();
			int input=scan.nextInt();
			
			switch(input) {
			case 1:
				//배열을 처음부터 순차대로 확인; 비어있는 배열을 발견하면 정보 입력후 반복문 종료;   

				
			break; //END case 1
			
			case 2: case 3: case 4: case 5: 
				System.out.print("\n아이디 입력 : ");String tempid=scan.next();
				System.out.print("비밀번호 입력 : ");String temppwd=scan.next();
				int index=-1;//회원정보관리와 마찬가지로 틀리거나 없으면 수량 증가시키고 한계점 도달하면 출력
				for(int i=0;i<3;i++){if(id[i]!=null&&id[i].equals(tempid)&&pwd[i].equals(temppwd)) {index=i; break;}}//null인 문자열은 비교할 수 없다.
				if(index==-1) {System.out.println("정보를 다시 확인해주세요."); break;}
				
				switch(input) {
				case 2: 
					System.out.printf("==계좌조회\nID : %s\nPASS : %s\n나이 : %d\n잔액 : %d\n",id[index],pwd[index],age[index],cash[index]);
				break;
				
				case 3: 
					System.out.print("입금 : ");cash[index]+=scan.nextInt();
					System.out.println("==입금완료\n잔액 : "+cash[index]);
				break;
				
				case 4:
					System.out.print("출금 : ");long under=scan.nextInt();
					if(under>cash[index]) {System.out.println("잔액을 초과한 금액은 출금할수 없습니다.");break;}
					cash[index]-=under;//출금시 마이너스가 안될수 있게 조건 추가
					System.out.println("==출금완료\n잔액 : "+cash[index]);
				break;
				
				case 5: 
					System.out.println("계좌를 삭제하시겠습니까? (Y/N)");char select = scan.next().charAt(0);
					if(select=='y'||select=='Y') {id[index]=null;pwd[index]=null;age[index]=0;cash[index]=0;}
				break; 
				}//END switch 
			break; //END case 2,3,4,5
			
			case 9: scan.close(); return;
			} 
		}
	}
}

///메서드버전으로 고쳐보기
///1.메뉴판
///2.회원가입
///3.입금
///4.출금
///5.삭제
///6.유저확보가능검사
///7.유저인증기능
