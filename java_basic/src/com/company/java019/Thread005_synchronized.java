package com.company.java019;

//synchronized 공유자원을 사용하는 경우 한 쓰레드가 작업하는 동안 다른 쓰레드는 접근 못하도록
//#1. 공유자원
class Rank{
	int num=0;
	public synchronized void plusnum() {
		int rank=num;
		try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
		num=rank+1;//3초뒤에 등수올리기
	}
}
//#2. 실행클래스
class User extends Thread{
	Rank rank; // 각유저마다 몇등이야.
	public User(Rank rank) {this.rank=rank;}
	@Override public void run() {
		rank.plusnum();
		System.out.println(rank.num+"등 >> "+super.getName()); // Thread name
	}
}

public class Thread005_synchronized {
	public static void main(String[] args) {
		Rank rank = new Rank(); //공유자원 num=1, num=2 등수
		
		Thread user1 = new User(rank); user1.setName("A"); user1.start();
		try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		
		Thread user2 = new User(rank); user2.setName("B"); user2.start();
		
	}
}