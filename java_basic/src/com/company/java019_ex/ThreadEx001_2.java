package com.company.java019_ex;

import javax.swing.JOptionPane;

class QuestionCount2 implements Runnable {//#1) Thread
	@Override public void run() {//#2)run
		for (int i=10;i>0;i--) {
			System.out.println(i);
			try { Thread.sleep(1000); } catch (InterruptedException e) { return; }
		}
	}
}

public class ThreadEx001_2 {

	public static void main(String[] args) {
		Thread count = new Thread(new QuestionCount2()); count.start();//#3) start 실행 
		
		String answer = JOptionPane.showInputDialog("사과알파벳을 입력하세요.");
		if (answer.toLowerCase().equals("apple")) {System.out.println("정답"); count.interrupt();}
		else {System.out.println("노답"); count.interrupt();}
		
	}

}
