package homework;

import java.util.Scanner;

class Coffee{
	String[] coffeeName;
	int[] coffeePrice;
	String name;
	int price,num;
	
	Coffee(){
		this.coffeeName = new String[] {"아메리카노","카페라떼","카푸치노"};
		this.coffeePrice = new int[] {1000,1500,2000};
	}
	Coffee(String name,int num){
		this(); // 기본생성자 호출 수동생성자 호출시 기본생성자는 호출안됨.
		this.num=num;
		this.name=name;		
	}
	
	void show() {
		coffee_calc();
		System.out.println("===== COFFEE_SHOW");
		System.out.println("커 피 명 : "+this.name);
		System.out.println("커피잔수 : "+this.num);
		System.out.println("커피가격 : "+this.price);
		System.out.println();
		System.out.println();
	}
	
	void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("::::::::COFFEE ORDER");
		for(int i=0;i<coffeeName.length;i++) {System.out.println(coffeeName[i]+" : "+coffeePrice[i]);}
		System.out.print("::커피이름 입력 > "); this.name=scanner.next();
		System.out.print("::커피잔수 입력 > "); this.num=scanner.nextInt();
	}
	
	void coffee_calc() {
		boolean found=false;
		for(int i=0;i<coffeeName.length;i++) {
			if(this.name.equals(coffeeName[i])) {
				this.price = coffeePrice[i]*this.num;
				found=true;
				break;
			}
		}
		if (found==false) {
			System.out.println(this.name+"는 현재 없는 메뉴 입니다.");
			this.price=0;
		}
	}
}

public class H_Coffee {

	public static void main(String[] args) {
		Coffee a1 = new Coffee("아메리카노",3);
		a1.show();
		Coffee a2 = new Coffee();
		a2.input();
		a2.show();
	}

}
