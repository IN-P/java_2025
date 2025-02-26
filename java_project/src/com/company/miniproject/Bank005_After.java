package com.company.miniproject;

import java.util.Arrays;
import java.util.Scanner;

public class Bank005_After {
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
			case 1:
				//배열을 처음부터 순차대로 확인; 비어있는 배열을 발견하면 정보 입력후 반복문 종료;   
				for(int i=0,count=0;i<3;i++) {
					if(id[i]==null) {
						System.out.print("아이디 입력 : ");id[i]=scan.next();
						System.out.print("비밀번호 입력 : ");pwd[i]=scan.next();
						System.out.print("나이 입력 : ");age[i]=scan.nextInt();
						System.out.print("잔액 입력 : ");cash[i]=scan.nextInt();
						break;
					}
					count++;//차있는 배열마다 카운트 증가 시키고 카운트가 한계에 도닥하면 비어있는 배열이 존재하지 않음
					if(count==3) System.out.println("더이상 가입할 수 없습니다.");	
				}
				
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
