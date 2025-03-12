package com.company.miniproject;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
//정보
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
//기능 인터페이스
interface Bank_Controller{ void exec(Set<Bank> user); }
//가입
class Input implements Bank_Controller{
	@Override public void exec(Set<Bank> user) { 
		Scanner sc = new Scanner(System.in);
		Bank temp = new Bank();
		
		System.out.print("\n아이디를 입력하세요. > "); temp.setId(sc.next());
		if (user.contains(temp)) {System.out.println("이미 존재하는 아이디 입니다."); sc.close(); return;}
		System.out.print("비밀번호를 입력하세요. > "); temp.setPass(sc.next());
		System.out.print("잔액을 입금하세요. > ");
		try { // 음수와 문자를 넣은경우 예외처리
			double cash = sc.nextDouble();
			if (cash<0) {System.out.println("음수는 입금할 수 없습니다."); sc.close(); return;}
			temp.setBalance(cash);
			user.add(temp);	
		} catch(Exception e) { System.out.println("숫자만 입력하세요."); sc.next();}
		sc.close();
	}
}
//조회
class Show implements Bank_Controller{
	@Override public void exec(Set<Bank> user) {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력하세요."); String tempid = sc
		System.out.printf("\n== 계좌조회\nID : %s\nPASS : %s\n잔액 : %s\n",
				user[index].getId(),user[index].getPass(),user[index].getBalance());
	} 
} 
//입금
class Deposit implements Bank_Controller{
	@Override public void exec(Set<Bank> user) {
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
	@Override public void exec(Set<Bank> user) {
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
	@Override public void exec(Set<Bank> user) {
		System.out.println("계좌를 삭제하시겠습니까? (Y/N)");char select = sc.next().charAt(0);
		if(select=='y'||select=='Y') {user[index]=null;}
	} 
}
//메뉴
class Menu{
	Set<Bank> user;
	Bank_Controller[] ctrl;

	public Menu() { // controller 배열화 및 초기화 Set 초기화
		super(); 
		user = new HashSet<>();
		ctrl = new Bank_Controller[] {new Input(),new Show(),new Deposit(),new Withdraw(),new Delete()};
	}
	
	public void exec() { //뱅크 시작
		System.out.println("WELCOME! "+Bank.Company); 
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				show(); int num = sc.nextInt();
				if(num==9) {sc.close(); return;} //종료
				if(num>=1&&num<=5) {ctrl[num-1].exec(user);} //controller
			} catch(Exception e) { //예외처리
				System.out.println("정확한 메뉴의 번호를 입력해주세요.");
				sc.nextLine();
			}
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
public class BankProject_v4_0_0 {
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.exec();
	}
}

