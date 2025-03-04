package com.company.java011;

import com.company.java011_ex.Score;

public class ModifierEx2 {
	public static void main(String[] args) {
		Score iron = new Score();
		Score hulk = new Score("hulk",20,50,30);
		
		iron.setName("iron");
		iron.setKor(100);
		iron.setEng(100);
		iron.setMath(100);
		
		Score.info();
		iron.show();
		hulk.show();
	}
}
