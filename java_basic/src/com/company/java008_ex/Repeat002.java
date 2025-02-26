package com.company.java008_ex;

public class Repeat002 {

	public static void main(String[] args) {
		//ver_for
		for(int i=1;i<=3;i++) {System.out.print(100*i+"\t");}
		System.out.println();
		
		//ver_while
		int i=1; while(i<=3) {System.out.print(100*i+"\t"); i++;}
		System.out.println();
		
		//ver_dowhile
		i=100; do {System.out.print(i+"\t"); i+=100;} while(i<=300);
	}

}
