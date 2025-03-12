package com.company.miniproject;

import java.util.Scanner;
// 회원정보
class Bank{
	private String id;
	private String pass;
	private double balance;
	static String Company="(주)PIN_BANK";
	
	public Bank() { super(); }
	public Bank(String id, String pass, double balance) {
		super();
		this.id = id;
		this.pass = pass;
		this.balance = balance;
	}
	
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getPass() { return pass; }
	public void setPass(String pass) { this.pass = pass; }
	public double getBalance() { return balance; }
	public void setBalance(double balance) { this.balance = balance; }
	
}
//뱅크기능
interface Bank_Controller{ void exec(Bank[] user, Scanner sc, int index); }
//회원가입
class Input implements Bank_Controller{
	@Override public void exec(Bank[] user, Scanner sc, int index) { 
		for (int i=0;i<3;i++) {
			if (user[i]==null) {
				user[i] = new Bank();
				System.out.print("\n아이디를 입력하세요. > "); user[i].setId(sc.next());
				System.out.print("비밀번호를 입력하세요. > "); user[i].setPass(sc.next());
				System.out.print("잔액을 입금하세요. > ");
				try { // 음수와 문자를 넣은경우 예외처리
					double temp = sc.nextDouble();
					if (temp<0) {System.out.println("음수는 입금할 수 없습니다."); user[i]=null; break;}
					user[i].setBalance(temp);
				} catch(Exception e) { System.out.println("숫자만 입력하세요."); user[i]=null; sc.next(); break; }
				break;
			} else if(i==2) {
				System.out.println("더이상 가입이 불가능합니다.");
			}
		}
	}
}
//조회
class Show implements Bank_Controller{
	@Override public void exec(Bank[] user, Scanner sc, int index) { 
		System.out.printf("\n== 계좌조회\nID : %s\nPASS : %s\n잔액 : %s\n",
				user[index].getId(),user[index].getPass(),user[index].getBalance());
	} 
} 
//입금
class Deposit implements Bank_Controller{
	@Override public void exec(Bank[] user, Scanner sc, int index) {
		System.out.print("입금 : ");
		try {
			Double limit = sc.nextDouble();
			if (limit<=0) {System.out.println("0 또는 음수는 입금할 수 없습니다."); return;}
			user[index].setBalance(user[index].getBalance()+limit);
			System.out.println("==입금완료\n잔액 : "+user[index].getBalance());
		} catch(Exception e) { System.out.println("숫자만 입력하세요."); sc.next(); return; }
	} 
} 
//출금
class Withdraw implements Bank_Controller{
	@Override public void exec(Bank[] user, Scanner sc, int index) {
		System.out.print("출금 : "); 
		try {
			Double limit = sc.nextDouble();
			if (limit<=0) {System.out.println("0 또는 음수는 출금할 수 없습니다."); return;}
			if (limit>user[index].getBalance()) {System.out.println("잔액을 초과한 금액은 출금할수 없습니다."); return;}
			user[index].setBalance(user[index].getBalance()-limit);
			System.out.println("==출금완료\n잔액 : "+user[index].getBalance());
		} catch(Exception e) { System.out.println("숫자만 입력하세요."); sc.next(); return; }
	} 
} 
//삭제
class Delete implements Bank_Controller{
	@Override public void exec(Bank[] user, Scanner sc, int index) {
		System.out.println("계좌를 삭제하시겠습니까? (Y/N)");char select = sc.next().charAt(0);
		if(select=='y'||select=='Y') {user[index]=null;}
	} 
}
//체크
class Check {
	int chk(Bank[] user, Scanner sc) { 
		System.out.print("\n아이디 입력 : "); String tempid = sc.next();
		System.out.print("비밀번호 입력 : "); String temppass = sc.next();
		int chk=-1;
		for(int i=0;i<3;i++) {
			if (user[i]==null) {continue;} //배열이 비어있으면 건너뛰기
			else if (user[i].getId().equals(tempid)&&user[i].getPass().equals(temppass)) {chk=i; break;}
			else if (user[i].getId().equals(tempid)&&!user[i].getPass().equals(temppass)) {chk=-2; break;}
		} 
		if(chk==-2) {System.out.println("비밀번호가 틀렸습니다.");}
		else if(chk==-1) {System.out.println("정보를 확인해주세요.");}
		return chk;
	} 
}
//메뉴
class Menu{
	Bank[] user;
	
	public Menu() { super(); user = new Bank[3];  } //회원3명만 갖게 배열 크기3 고정
	
	public void exec() {
		System.out.println("WELCOME! "+Bank.Company); //머릿말
		Scanner sc = new Scanner(System.in); //스캐너
		while(true) {
			show(); int num = sc.nextInt(),index=-1;
			Bank_Controller control = null;
			switch(num) {
			case 1: control = new Input(); control.exec(user, sc, index); break; //가입
			case 2: case 3: case 4: case 5:
				Check chk = new Check(); index = chk.chk(user,sc); 
				if(index<0) { break; }
				else if(num==2) {control = new Show(); control.exec(user, sc, index); break;} //조회
				else if(num==3) {control = new Deposit(); control.exec(user, sc, index); break;} //입금
				else if(num==4) {control = new Withdraw(); control.exec(user, sc, index); break;} //출금
				else if(num==5) {control = new Delete(); control.exec(user, sc, index); break;} //삭제
			case 9: sc.close(); return; //종료
			}
			System.out.println();
		}
	}
	
	void show() { //메뉴판
		System.out.println("===== "+Bank.Company+" =====");
		System.out.println(" 1. 가입\t\t2. 조회");
		System.out.println(" 3. 입금\t\t4. 출금");
		System.out.println(" 5. 삭제\t\t9. 종료");
		System.out.println("-----------------------");
		System.out.print(" 번호 입력 > ");
	}
}
//메인
public class BankProject_v3_0_1 {
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.exec();
	}
}

