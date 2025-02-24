package com.company.java006_ex;

public class Repeat009 {

	public static void main(String[] args) {
		//#for
		for(char ch='A';ch<='Z';ch++) {
			System.out.print(ch);
			switch(ch) {
				case 'E':case 'J':case 'O':case 'T':case 'Y':System.out.println(); break; 
			}
		}
		System.out.println();
		
		//#while
		char x=65;
			while(x<=90) {
				if (x%5==4) System.out.print(x+"\n");
				else System.out.print(x);
				x++;
			}
		System.out.println();
		
		//#dowhile
		char y='A'; String z="";
		do {
			for(char i=y;i<=y+4;i++) {
				z+=i;
				if(i==90) break;
			}
			System.out.println(z);
			z="";
			y+=5;
		} while(y<='Z');
		
	}
}

