package com.company.java011_ex;

public class Score2Process {
	public void process_avg(Score2[] std) {
		for(Score2 a:std) {a.setAvg((a.getKor()+a.getEng()+a.getMath())/3.0);}
	}
	public void process_pass(Score2[] std) {
		for(Score2 p:std) {p.setPass(p.getAvg()<60?"불합격":"합격");}
	}
}
