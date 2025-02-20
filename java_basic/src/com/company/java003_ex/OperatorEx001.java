package com.company.java003_ex;

public class OperatorEx001 {

	public static void main(String[] args) {
		int a=3,b=10;
        System.out.println(b+=10-a--);
        ///a(3)
        ///10-a(3)=7
        ///b(10)
        ///b=b(10)+7 출력 b(17)
        ///a-- a(2)
        System.out.println(a+=5);
        ///a(2)
        ///a=a(2)+5 출력 a(7)
        System.out.println(a>=10||a<0&&a>3);
        ///a(7),b(17)
        ///[1]a>=10 : false
        ///[2]a<0 : false
        ///[3]a>3 ; ture
        ///[4] [2]&&[3] : false //||(또는)보다 &&(그리고)가 우선순위 더 높음
        ///[1]||[4] : false
	}

}
