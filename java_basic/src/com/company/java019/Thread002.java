package com.company.java019;

import java.awt.Toolkit;

//1. 프로세스 - 실행중인 프로그램
//2. 프로세스 - 자원+Thread(작업)
//3. 작업수행클래스 1)상속, Runnable 2) run() 해야할일 3) start() 실행
class PigSound extends Thread{ //#1.상속 Thread(작업수행클래스)
	@Override public void run() {//#2. run 해야할일
		try {Thread.sleep(10);} catch (Exception e) {e.printStackTrace();}
		
		Toolkit tool = Toolkit.getDefaultToolkit();
		for (int i=0;i<5;i++) {
			tool.beep();
			System.out.println("꿀꿀");
			try {Thread.sleep(1000);} catch (Exception e) {e.printStackTrace();}
		}
	}
	
}

class PigCount extends Thread{
	@Override public void run() {
		for (int i=0;i<5;i++) {
			System.out.print(i+"마리");
			try {Thread.sleep(1000);} catch (Exception e) {e.printStackTrace();}
		}
	}
}
public class Thread002 {
	public static void main(String[] args) {
		//여러가지 일을 동시에
		//#3. 작업스레드 ##3단계
		Thread sound = new PigSound(); sound.start(); 
		Thread count = new PigCount(); count.start(); 
		
		for (int i=0;i<5;i++) {
			System.out.println("˙Ꙫ˙ ");
			try {Thread.sleep(1000);} catch (Exception e) {e.printStackTrace();}
		}
		
	}
}
