package com.company.java010_ex;

import java.util.Scanner;

//1. 클래스는 부품객체
//2. 클래스는 상태(멤버변수)와 행위(멤버함수)
//3. 생성자호출 초기화
class TV{
	//상태-멤버변수 채널/볼륨 
	String channel; int volume;
	//행위-멤버함수
	TV(){}
	TV(String channel,int volume){
		this.channel=channel;
		this.volume=volume;
	}
	//채널, 볼륨 입력 : input() /출력 : show()
	void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(":::::::::MYTV");
		System.out.print("channel입력 > "); this.channel=scanner.next();
		System.out.print("volume입력 > "); this.volume=scanner.nextInt();
		System.out.println();
		scanner.close();
	}
	
	void show() {
		System.out.println("===== TV");
		System.out.println("TV채널 : "+this.channel);
		System.out.println("TV볼륨 : "+this.volume);
		System.out.println();
	}
}

public class ClassEx004 {
	public static void main(String[] args) {
		TV t1 = new TV("JDBC",8); t1.show();
		TV t2 = new TV(); t2.input(); t2.show();
	}
}
/*

*/
