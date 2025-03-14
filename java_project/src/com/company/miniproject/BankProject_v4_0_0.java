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
	//id만 체크
	@Override public int hashCode() { return Objects.hash(id); }
	@Override public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Bank [id=" + id + ", pass=" + pass + ", balance=" + balance + "]";
	}
	
}
//기능 인터페이스
interface Bank_Controller{ void exec(Set<Bank> user); }
//가입
class Input implements Bank_Controller{
	@Override public void exec(Set<Bank> user) { 
		Scanner sc = new Scanner(System.in);
		Bank temp = new Bank();
		
		System.out.print("\n아이디를 입력하세요. > "); temp.setId(sc.next());
		if (user.contains(temp)) { //id 중복체크
			System.out.println("이미 존재하는 아이디 입니다.");  
			return;
		} //id만 체크하면 문제없이 진행
		System.out.print("비밀번호를 입력하세요. > "); temp.setPass(sc.next());
		System.out.print("금액을 입금하세요. > ");
		try { // 잔액에 음수와 문자를 넣은경우 예외처리
			double cash = sc.nextDouble();
			if (cash<0) {System.out.println("음수는 입금할 수 없습니다."); return;}
			temp.setBalance(cash);
			user.add(temp);	
		} catch(Exception e) { System.out.println("금액만 입력하세요."); sc.next();}
	}
}
//조회
class Show implements Bank_Controller{
	@Override public void exec(Set<Bank> user) {
		for(Bank u : user) {
			if(u.getId().equals(Menu.chk.getId())) {
				System.out.printf("\n== 계좌조회\nID : %s\nPASS : %s\n잔액 : %s\n",
						u.getId(),u.getPass(),u.getBalance());
			}
		}
	} 
} 
//입금
class Deposit implements Bank_Controller{
	@Override public void exec(Set<Bank> user) {
		Scanner sc = new Scanner(System.in);
		for(Bank u : user) {
			if(u.getId().equals(Menu.chk.getId())) {
				System.out.print("입금 : ");
				try {
					Double limit = sc.nextDouble();
					if (limit<=0) {System.out.println("0 또는 음수는 입금할 수 없습니다."); return;}
					u.setBalance(u.getBalance()+limit);
					System.out.println("==입금완료\n잔액 : "+u.getBalance());
				} catch(Exception e) { System.out.println("숫자만 입력하세요."); sc.next(); return; }
			}
		}
	} 
} 
//출금
class Withdraw implements Bank_Controller{
	@Override public void exec(Set<Bank> user) {
		Scanner sc = new Scanner(System.in);
		for(Bank u : user) {
			if(u.getId().equals(Menu.chk.getId())) {
				System.out.print("출금 : "); 
				try {
					Double limit = sc.nextDouble();
					if (limit<=0) {System.out.println("0 또는 음수는 출금할 수 없습니다."); return;}
					if (limit>u.getBalance()) {System.out.println("잔액을 초과한 금액은 출금할수 없습니다."); return;}
					u.setBalance(u.getBalance()-limit);
					System.out.println("==출금완료\n잔액 : "+u.getBalance());
				} catch(Exception e) { System.out.println("숫자만 입력하세요."); sc.next(); return; }
			}
		}
	} 
} 
//삭제
class Delete implements Bank_Controller{
	@Override public void exec(Set<Bank> user) {
		Scanner sc = new Scanner(System.in);
		for(Bank u : user) {
			if(u.getId().equals(Menu.chk.getId())) {
				System.out.println("계좌를 삭제하시겠습니까? (Y/N)");String select = sc.next();
				if(select.equals("y")||select.equals("Y")) {Menu.chk=null; user.remove(u);}
				else if (select.equals("n")||select.equals("N")) {System.out.println("취소하셧습니다.");}
				else {System.out.println("잘못된 입력으로 메뉴로 돌아갑니다.");}
			}
		}
	} 
}
//메뉴
class Menu{
	Set<Bank> user;
	Bank_Controller[] ctrl;
	Scanner sc;
	static Bank chk; //각 controller 에서 정보를 전달하기 위한 추적 뱅크
	
	public Menu() { // controller 배열화 및 초기화 Set 초기화
		super(); 
		user = new HashSet<>();
		ctrl = new Bank_Controller[] {new Input(),new Show(),new Deposit(),new Withdraw(),new Delete()};
		sc = new Scanner(System.in);
	}
	
	public void exec() { //뱅크 시작
		System.out.println("WELCOME! "+Bank.Company); 
		while(true) {
			try {
				System.out.println(chk);
				show(); int num = sc.nextInt();
				if(num==9) {sc.close(); return;} //종료
				if(num==1) { ctrl[0].exec(user); }
				if(num>1&&num<6) { //본인확인이 필요한 기능들
					chk = check(user); //체크 실행 리턴 -1(실패) or 0(성공)
					if(chk!=null) {ctrl[num-1].exec(user);} // 체크성공시 실행
				}
			} catch(Exception e) { //예외처리
				System.out.println("정확한 메뉴의 번호를 입력해주세요.");
				sc.next();
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
	
	Bank check (Set<Bank> user) { //체크 메서드 
		Bank temp = new Bank(); //질문1 여기서 새로만든 temp는 check 메서드에서 사용하고 사라지는가?
		System.out.print("\n아이디를 입력하세요. > "); temp.setId(sc.next());
		if (!user.contains(temp)) { //id 중복체크 실패 -1
			System.out.println("존재하지 않는 아이디 입니다."); return null;
		} else {
			System.out.print("\n비밀번호를 입력하세요. > "); temp.setPass(sc.next());
			for(Bank u : user) {
				if(u.getId().equals(temp.getId())&&u.getPass().equals(temp.getPass()))
				return u; // 아이디와 비번이 일치하면 성공 0 성공하면  chk에 주소 보내서 추적
			}
		}
		System.out.println("비밀번호가 틀렸습니다."); return null;
	}
	
}//END Menu
//메인
public class BankProject_v4_0_0 {
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.exec();
		
	}
}

