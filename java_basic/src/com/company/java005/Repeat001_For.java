package com.company.java005;

public class Repeat001_For {
	public static void main(String[] args) {
		//step1
		System.out.println("step1) ");
		System.out.print(1+"\t");
		System.out.print(2+"\t");
		System.out.print(3+"\t");
		
		
		//step2
		System.out.println("\n\nstep2");
		//{반복}	{변수}	for(시작;종료;변화)
		for(int i=1;i<4;i++){System.out.print(i+"\t");}
		
		//step3
		System.out.println("\n\nstep3");
		for(int i=11;i<=20;i++){System.out.print(i+"\t");} System.out.println();
		for(int i=3;i<=8;i++){System.out.print(i+"\t");} System.out.println();
		for(int i=1;i<11;i++){System.out.print(i+"\t");} System.out.println();
		for(int i=1;i<6;i+=2){System.out.print(i+"\t");} System.out.println();
	}
}
