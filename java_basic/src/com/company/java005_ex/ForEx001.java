package com.company.java005_ex;

public class ForEx001 {

	public static void main(String[] args) {
		for (int i=1;i<=5;i++) {System.out.print(i+" ");}
		System.out.println();
		
		for (int i=5;i>=1;i--) {System.out.print(i+" ");}
		System.out.println();
		
		for (int i=1;i<=3;i++) {System.out.print("JAVA"+i+" ");}
		System.out.println();
		
		for (int i=3;i>=1;i--) {System.out.print("HAPPY"+i+" ");}
		System.out.println();
		
		for (int i=0;i<=2;i++) {
			System.out.print(i);
			if(i<2) {System.out.print(",");}
			}
		System.out.println();
		
		for (int i=0;i<=99;i++) {
			if(i<=2) {
				System.out.print(i);
				if(i<2) {System.out.print(",");}
			}
			if(i==4) {System.out.print(" ,,,중간생략 ,,,");}
			if(i==99) {System.out.print(i);}
		}
		System.out.println();
		
		for (int i=10;i>=1;i--) {
			if(i<10) {System.out.print(",");}
			System.out.print(i);
		}
		System.out.println();
		
		for(int i=0;i<=8;i+=2) {
			System.out.print(i);
			if(i<8) {System.out.print(",");}
			}
		System.out.println();
		
		for(int i=0;i<=18;i+=2) {
			System.out.print(i);
			if(i<18) {System.out.print(",");}
		}
		System.out.println();
		 
	}

}
