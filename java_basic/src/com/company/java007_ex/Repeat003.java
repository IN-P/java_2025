package com.company.java007_ex;

public class Repeat003 {
	public static void main(String[] args) {
		for(int i=1;i<=3;i++) {System.out.print(i*10+"\t");}
		System.out.println();
		int a=1; while(a<=3) {System.out.print(a*10+"\t"); a++;}
		System.out.println();
		a=1; do {System.out.print(a*10+"\t"); a++;} while(a<=3);
	}
}
