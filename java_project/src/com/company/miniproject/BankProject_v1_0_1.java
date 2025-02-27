package com.company.miniproject;

import java.util.Arrays;
import java.util.Scanner;

public class BankProject_v1_0_1 {

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
			System.out.println("=====BANK=====\n* 1.추가\n* 2.조회\n* 3.입금\n* 4.출금\n* 5.삭제\n* 9.종료");
			System.out.print("입력>>> ");
			int input=scan.nextInt();
			
			switch(input) {
			case 1: //관리할 수 있는 데이터수가 정해져있으므로
				for(int i=0,full=0;i<3;i++) {//비어있는 공간 확인 없다면 가입불가 출력
					if(id[i]!=null) full++;//확인할때 비어있지 않으면 증가 시켜서 한계점이 되면 출력
					if(full==3) System.out.println("더이상 가입할 수 없습니다.");
					}
				for(int i=0;i<3;i++) {//비어있는 공간을 순차적으로 찾고 가입정보 배열로 저장
					if(id[i]==null) {
						System.out.print("아이디 입력 : ");id[i]=scan.next();
						System.out.print("비밀번호 입력 : ");pwd[i]=scan.next();
						System.out.print("나이 입력 : ");age[i]=scan.nextInt();
						System.out.print("잔액 입력 : ");cash[i]=scan.nextInt();
						break;
					}
					
				}
			break;
			
			case 2: case 3: case 4: case 5: 
				System.out.print("\n아이디 입력 : ");String tempid=scan.next();
				System.out.print("비밀번호 입력 : ");String temppwd=scan.next();
				int count=0;//회원정보관리와 마찬가지로 틀리거나 없으면 수량 증가시키고 한계점 도달하면 출력
				
				for(int i=0;i<3;i++){//임시로 받은 temp들을 순차적으로 비교
					if(id[i].equals(tempid)&&pwd[i].equals(temppwd)) {//temp와 정보가 일치하면 개별기능들 실행
						switch(input) {
						case 2: 
							System.out.printf("==계좌조회\nID : %s\nPASS : %s\n나이 : %d\n잔액 : %d\n",id[i],pwd[i],age[i],cash[i]);
						break;
						
						case 3: 
							System.out.print("입금 : ");cash[i]+=scan.nextInt();
							System.out.println("==입금완료\n잔액 : "+cash[i]);
						break;
						
						case 4:
							System.out.print("출금 : ");long under=scan.nextInt();
							if(under>cash[i]) {System.out.println("잔액보다 많은 금액은 출금할수 없습니다.");break;}
							cash[i]-=under;//출금시 마이너스가 안될수 있게 조건 추가
							System.out.println("==출금완료\n잔액 : "+cash[i]);
						break;
						
						case 5: 
							System.out.println("계좌를 삭제하시겠습니까? (Y/N)");char select = scan.next().charAt(0);
							if(select=='y'||select=='Y') {id[i]=null;pwd[i]=null;age[i]=0;cash[i]=0;}
						break; 
						}//switch END 회원정보 맞았을때 개별실행
					}else{count++;}//if END 확인했는데 맞으면 실행 맞지 않으면 카운트++ 3번다 실패하면 카운트=3
				}//for END 회원여부 확인(반복)
				if(count==3) {System.out.println("다시 확인해주세요.");}//카운트=3되면 출력(정보가없거나 틀렸다.)
			break; //case 2,3,4,5 끝
			
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
