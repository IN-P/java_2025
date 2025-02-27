package com.company.miniproject;

import java.util.Arrays;
import java.util.Scanner;

public class BankProject_v_1_0_1_T {

	public static void main(String[] args) {
		System.out.println("WELCOME! (주)CODEJOHNS_BANK");
		Scanner scan = new Scanner(System.in);
		//회원정보 3명 배열로 만들어보기
		int[] age = new int[3]; 
		long[] cash = new long[3];
		String[] id = new String[3];
		String[] pwd = new String[3];
		while(true) {
			System.out.println(Arrays.toString(id));
			System.out.println(Arrays.toString(cash));
			System.out.println("=====BANK=====\n* 1.추가\n* 2.조회\n* 3.입금\n* 4.출금\n* 5.삭제\n* 9.종료");
			System.out.print("입력>>> ");
			int input=scan.nextInt();
			
			switch(input) {
			case 1: {
				//관리할 수 있는 데이터수가 정해져있으므로
				//1. 데이터가 비어있느지 확인
				int find=-1;//비어있는 공간 확인 없다면 가입불가 출력
				for(int i=0;i<3;i++) { if(id[i]==null) { find=i; break;} }
				if(find ==-1) {  System.out.println("더이상 가입할 수 없습니다.");  break;  }
					
				//2. 입력받기
				System.out.print("아이디 입력 : ");id[find]=scan.next();
				System.out.print("비밀번호 입력 : ");pwd[find]=scan.next();
				System.out.print("나이 입력 : ");age[find]=scan.nextInt();
				System.out.print("잔액 입력 : ");cash[find]=scan.nextInt();
			}break;
			
			case 2: case 3: case 4: case 5: {
				System.out.print("\n아이디 입력 : ");String tempid=scan.next();
				System.out.print("비밀번호 입력 : ");String temppwd=scan.next();
				
				int find=-1;//임시로 받은 temp들을 순차적으로 비교
				for(int i=0;i<3;i++){ if(id[i].equals(tempid)&& pwd[i].equals(temppwd)) { find=i; break; } }

				if(find ==-1) {  System.out.println("정보를 확인해주세요.");  break;  }		
						//temp와 정보가 일치하면 개별기능들 실행
				switch(input) {
				case 2: 
					System.out.printf("==계좌조회\nID : %s\nPASS : %s\n나이 : %d\n잔액 : %d\n",
							id[find],pwd[find],age[find],cash[find]);
				break;
				
				case 3: 
					System.out.print("입금 : ");cash[find]+=scan.nextInt();
					System.out.println("==입금완료\n잔액 : "+cash[find]);
				break;
				
				case 4:
					System.out.print("출금 : ");long under=scan.nextInt();
					if(under>cash[find]) {System.out.println("잔액보다 많은 금액은 출금할수 없습니다.");break;}
					cash[find]-=under;//출금시 마이너스가 안될수 있게 조건 추가
					System.out.println("==출금완료\n잔액 : "+cash[find]);
				break;
				
				case 5: 
					System.out.println("계좌를 삭제하시겠습니까? (Y/N)");char select = scan.next().charAt(0);
					if(select=='y'||select=='Y') {id[find]=null;pwd[find]=null;age[find]=0;cash[find]=0;}
				break; 
				}//switch END 회원정보 맞았을때 개별실행
			  	
			}//for END 회원여부 확인(반복) 
			break; //case 2,3,4,5 끝	
			case 9: return;
			}//end switch
		}//end while
	}
}

