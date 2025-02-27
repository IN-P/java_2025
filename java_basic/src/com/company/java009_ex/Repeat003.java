package com.company.java009_ex;

public class Repeat003 {

	public static void main(String[] args) {
		for(int i=1;i<4;i++) {System.out.print(i*100+"\t");} System.out.println();
		int i=1; while(i<4) {System.out.print(i*100+"\t"); i++;} System.out.println();
		i=1; do {System.out.print(i*100+"\t"); i++;} while(i<4); System.out.println();
	}

}
