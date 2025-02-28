package com.company.java010_ex;

import java.util.Scanner;

class Calc{
	//멤버변수
	static String name = "calculator";
	int num1,num2;
	char op;
	double result;
	
	//기본생성자
	public Calc(){}
	//수동생성자
	public Calc(int num1,int num2,char op){
		this.num1=num1;
		this.num2=num2;
		this.op=op;
	}
	//입력파트 멤버함수
	void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자1 > "); this.num1=scanner.nextInt();
		System.out.print("숫자2 > "); this.num2=scanner.nextInt();
		System.out.print("연산자 > "); this.op=scanner.next().charAt(0);
		scanner.close();
	}
	//계산파트 멤버함수
	void opcalc() {
		switch (this.op) {
		case '+': this.result=this.num1+this.num2; break;
		case '-': this.result=this.num1-this.num2; break;
		case '*': this.result=this.num1*this.num2; break;
		case '/': this.result=(double)this.num1/this.num2; break;
		}
	}
	//출력파트 멤버함수
	void show() {
		opcalc();
		if(op=='/') System.out.printf("%d%s%d=%.2f\n",this.num1,this.op,this.num2,this.result);
		else {System.out.printf("%d%s%d=%d\n",this.num1,this.op,this.num2,(int)this.result);}
	}
	
}

public class ClassEx007 {

	public static void main(String[] args) {
		System.out.println(Calc.name); //클래스명.static변수 (new없이 사용 가능)
		Calc  c1= new Calc(10,3,'+');  
		c1.show();
		
		System.out.println(c1.name); // 정적변수(클래스변수)는 클래스명.클래스변수로 호출하는게 좋다.
	   
		Calc  c2= new Calc();  
		c2.input();   
		c2.show(); 
	}

}
