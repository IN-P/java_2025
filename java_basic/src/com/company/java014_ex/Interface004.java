package com.company.java014_ex;

import java.util.Arrays;
import java.util.Calendar;

interface Launch{int MONEY = 10000; void eat();}
class Burger implements Launch{
	int price;
	public Burger() {this.price=3900;}
	@Override public void eat() { System.out.println("Burger 냠냠!"); }
	@Override public String toString() { return "Burger"; }
}
class KimchiStew implements Launch{
	int price;
	public KimchiStew() {this.price=4000;}
	@Override public void eat() { System.out.println("KimchiStew 냠냠!"); }
	@Override public String toString() { return "KimchiStew"; }
}

class User{
	int money; int cnt; int sum;
	Launch[] plate;
	User(){
		money=Launch.MONEY;
		plate = new Launch[3];
		cnt=0;
		}
	void order(Launch launch) {
//		plate[cnt++]=launch; //주문받아서 배열에 넣기
//		
//		if(cnt%3==0) { //주문3개이상이되면 배열 확장하기
//			Launch[] temp = new Launch[cnt];
//			for(int i=0;i<cnt;i++) {temp[i]=plate[i];}
//			plate = new Launch[plate.length+3];
//			for(int i=0;i<cnt;i++) {plate[i]=temp[i];}
//		}
		if (cnt == plate.length) { // 배열이 꽉 찼으면 크기 확장
		        plate = Arrays.copyOf(plate, plate.length + 3);
		    }

	    plate[cnt++] = launch;
		
		sum=0;//주문들어올때마다 초기화시킨후
		for(int i=0;i<cnt;i++) { //주문받은 금액 정산
			if(plate[i] instanceof Burger) sum+=((Burger)plate[i]).price;
			else sum+=((KimchiStew)plate[i]).price;
		}
	}
	void show() {
		for(int i=0;i<cnt;i++) {
			if(plate[i] instanceof Burger) System.out.println("버거하나요~!");
			else System.out.println("김치찌개하나요~!");
		}
		if(sum>money) { //한도초과 출력
			System.out.println(">> 잔액이 부족해 더이상 주문이 불가능합니다.");
		}
		else {
			System.out.print("주문\t: ");
			for(int i=0;i<cnt;i++) {System.out.print(plate[i]+(i<cnt-1?",":"\n"));}
			System.out.println("주문금액\t: "+sum);
			System.out.println("잔액\t: "+(money-sum));
//			System.out.println("2025년 3월 7일");
			Calendar today = Calendar.getInstance(); 
			// Calendar 변수이름 = Calendar.getInstance(); 날짜를 가져오는 메서드 
			// get(1):년 get(2)+1:월(0~11인덱스로 나옴 그래서 +1 해줌) get(5):일  
			System.out.println(today.get(1)+"년 "+(today.get(2)+1)+"월 "+today.get(5)+"일");
			for(int i=0;i<cnt;i++) { plate[i].eat(); }
		}
	}
}
public class Interface004 {
	public static void main(String[] args) {
		User launchorder = new User();
		launchorder.order(new Burger());
		launchorder.order(new KimchiStew());
//		launchorder.order(new Burger());
		launchorder.show();
	}

}
