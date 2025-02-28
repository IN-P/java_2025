package com.company.java010_ex;

import java.util.Scanner;


class Card{
	int cardNum;
	boolean isMembership;
	
	public Card(){
		this.cardNum = 1;
		this.isMembership = true;
	}
		
	public Card(int cardNum, boolean isMembership) {
		super();
		this.cardNum = cardNum;
		this.isMembership = isMembership;
	}

	void input() {}
	void show() {}

	@Override
	public String toString() {
		return "Card [cardNum=" + cardNum + ", isMembership=" + isMembership + "]";
	}
	
}

public class ClassEx005 {
	public static void main(String[] args) {
		Card c1 = new Card();
		System.out.println(c1);
	}
}
