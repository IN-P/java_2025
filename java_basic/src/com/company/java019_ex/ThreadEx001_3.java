package com.company.java019_ex;

import javax.swing.JOptionPane;

public class ThreadEx001_3 {

	public static void main(String[] args) {
		Thread count = new Thread(new Runnable() {
			@Override public void run() {
				for (int i=10;i>0;i--) {
					System.out.println(i);
					try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
				}
			}
		}); count.start(); 
		
		String answer = JOptionPane.showInputDialog("사과알파벳을 입력하세요.");
		if (answer.toLowerCase().equals("apple")) {System.out.println("정답");}
		else {System.out.println("노답");}
		
	}

}
