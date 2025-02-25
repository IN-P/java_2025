package com.company.java008_ex;

public class Repeat001 {

	public static void main(String[] args) {
		byte b1=1, b2=2;
		byte result = (byte)(b1+b2); 
		// byte타입이지만 연산시에는 기본타입인 int로 계산을 하기 때문에 에러가난다.
		// 그러므로 연산을 묶어 형변환을 진행시켜준다.
	}

}
