package com.company.java006_ex;

public class Repeat007 {

	public static void main(String[] args) {
		//1.
		for (int i=1;i<=5;i++) {System.out.print(i+"\t");} System.out.println();
		
		int i=1;
		while (i<=5) {System.out.print(i+"\t"); i++;} System.out.println();
		
		int a=1;
		do {System.out.print(a+"\t"); a++;}
		while (a<=5); System.out.println();
		
		//2.
		for (int x=5;x>=1;x--) {System.out.print(x+"\t");} System.out.println();
		
		int y=5;
		while (y>=1) {System.out.print(y+"\t"); y--;} System.out.println();
		
		int z=5;
		do {System.out.print(z+"\t"); z--;}
		while (z>=1); System.out.println();
		
		//3.
		for (int p=1;p<=3;p++) {System.out.print("JAVA"+p);} System.out.println();
		
		int q=1;
		while (q<=3) {System.out.print("JAVA"+q); q++;} System.out.println();
		
		int r=1;
		do {System.out.print("JAVA"+r); r++;}
		while (r<=3); System.out.println();
	}
}
