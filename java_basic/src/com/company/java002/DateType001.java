package com.company.java002;

public class DateType001 {

	public static void main(String[] args) {
		//1. 자바의 자료형 : 기본형/참조형
		//2. 기본형 : 값 저장
		// 논리, 정수, 실수
		boolean bl=true; //true/false
		System.out.println("1. 논리 : "+bl);
		//정수(1,2,4,8 : byte-short-int-long:L)
		byte by=1; //bit(0,1)=8bit=1byte 
		short sh=2; int in=4; long l=8L;
		System.out.println("2 정수 byte-short-int-long"+by);
		int result = by+sh; //1+2
		// short result = by+sh;
		// 연산 시 + int보다 작은 정수형들(byte,short)은 기본자료형 int로 불러온다. <주의>
		System.out.println(result);
		// 실수 (float:f/double)
		float fl=3.14f; double d=3.14;
		System.out.println("3. 실수 float - double :"+fl+"\t"+d);
		
		System.out.println("4. 실수 > 정수");
		fl=l; //실수는 사이즈에 상관없이 정수를 담을 수 있음
		System.out.println(fl);
		
		System.out.println("5. 정밀도");
		float fper=1.123456789f; //소수점 최대 7자리 
		float f2per=1.123456749f;
		double dper=1.1234567890000123156789; //소수점 최대 16자리 
		double d2per=1.1234567890000123456789; 
		System.out.println(fper+"\t"+dper);
		System.out.printf("%.25f\n",d2per); //printf 불가능
		System.out.println(f2per);
		
		int a=2>>32;
		int b=2^33;
		System.out.println(a+"\t"+b);
		
		System.out.println("6. 문자 저장시 숫자로 - 출력시 문자로");
		char ch='A'; // 문자 ''
		System.out.println(ch); //출력
		System.out.println((int)ch); //(int) 정수표현시 65
		
	}

}
