package com.company.java019_ex;

import javax.swing.JOptionPane;

class QuestionCount extends Thread {//#1) Thread
	@Override public void run() {//#2)run
		for (int i=10;i>0;i--) {
			System.out.println(i);
			try { Thread.sleep(1000); } catch (InterruptedException e) { break; }
		}
	}
}
//count.interrupt(); 방해하고 catch에 break
public class ThreadEx001_1 {

	public static void main(String[] args) {
		Thread count = new QuestionCount(); count.start();//#3) start 실행 
		
		String answer = JOptionPane.showInputDialog("사과알파벳을 입력하세요.");
//		System.out.println(answer);
		if (answer.toLowerCase().equals("apple")) {System.out.println("정답"); count.interrupt();}
		else {System.out.println("노답"); count.interrupt();}
		
	}

}
// 문제점 1) 문제풀었는데도 count 계속 실행 2) main이 끝나도 count 계속 실행 