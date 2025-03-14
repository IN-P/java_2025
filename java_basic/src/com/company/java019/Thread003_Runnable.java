package com.company.java019;

//1. 프로세스 - 실행중인 프로그램
//2. 프로세스 - 자원+Thread(작업)
//3. 작업수행클래스 1)상속, Runnable 2) run() 해야할일 3) start() 실행
class Animal {}
//class CatSound extends Animal ,Thread {} 단일상속이므로 불가능
class CatSound extends Animal implements Runnable {
	@Override public void run() {
		try { Thread.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }//약간의 딜레이
		for (int i=0;i<5;i++) {
			System.out.println("먀옹먀옹!");
			try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
		} // 1000이 1초
	}
}

public class Thread003_Runnable {// (^._.^)ﾉ 
	public static void main(String[] args) {
		Thread sound = new Thread(new CatSound()); sound.start();
		
		Thread count = new Thread(new Runnable() { //#1 runnable
			@Override public void run() { //2. run todo
				for (int i=0;i<5;i++) {
					System.out.print((i+1)+"마리");
					try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
				}
			}
		}); count.start();
		
		for (int i=0;i<5;i++) {
			System.out.print("(^._.^)ﾉ  ");
			try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}
