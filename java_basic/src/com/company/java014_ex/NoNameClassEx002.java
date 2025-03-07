package com.company.java014_ex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class MyView implements ActionListener{
	//멤버변수 (frame:틀/button:버튼) 자바팀에서 미리 만든 객체들
	JFrame frame;
	JButton button;
	
	public MyView() {
		frame = new JFrame("BOX");
		button = new JButton("BUTTON");
	}

	//멤버함수
	public void create() {
		//2-1. frame.add(컴포넌트)
		frame.add(button);
		//2-2. frame.size(가로,세로)
		frame.setSize(300,300);
		//2-3. frame.setVisible()
		frame.setVisible(true);
		button.addActionListener(this); //이벤트대상.이벤트(헨들러);
	}

	@Override
	public void actionPerformed(ActionEvent e) {//이벤트 발생시 처리
		JOptionPane.showMessageDialog(null,"click!");
	}
}

public class NoNameClassEx002 {
	public static void main(String[] args) {
		new MyView().create();
	}

}
