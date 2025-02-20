package com.company.java003;

public class Casting001 {

	public static void main(String[] args) {
		//#1. 형변환 - 자동타입변환
		//byte < short < int < long < float < double
		byte by=1;
		short sh=2;
		int in=4;
		long l=8L;
		float f= 3.14f;
		double d=3.14;
		
		sh= by;	// 정수(2byte)-정수(1byte)
		in=by;	// 정수(4byte)-정수(1byte)
		l=by;	// 정수(8byte)-정수(1byte)
		
//		l=f; 	// 정수(8byte)-실수(4byte) 정수<실수 이므로 error
				// Type mismatch: cannot convert from float to long
		f=l;	// 실수(4byte)-정수(8byte)
		
		//boolean bl = true; //논리(1byte)
		//in = bl; boolean은 형변환안됨.
		
		//#2. 형변환 - 강제타입변환
		by=(byte) in; 	// 정수(1byte)-정수(4byte)
		
		int in2 = (int)1.2; 	// 정수(4byte)-실수(double:8byte)
//		float f12=3.14;	// 실수(4byte)-실수(double:8byte)
		float f12=(float)3.14;	// 실수(4byte)-실수(double:8byte)
								//float:소숫점7자리 double:소숫점15자리
		System.out.println(in2);
		System.out.println(f12);
		
		//Q1) System.out.println( 1.5+2.7 ); 결과 3으로 출력하기
		double a=1.5, b=2.7;
		System.out.println((int)a+(int)b);
		System.out.println((int)1.5+(int)2.7);
		
		

	}

}
