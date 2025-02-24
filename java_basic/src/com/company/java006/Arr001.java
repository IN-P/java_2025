package com.company.java006;

public class Arr001 {
	public static void main(String[] args) {
		int[] arr=null; //int자료형 [] 연달아서 입력받을께요~!
				   		//null 공간은 존재 값이 없음
		int[] arr2= {1,2,3}; 
		/* heap area(동적메모리)      stack(임시공간)
		       1번지{1,2,3}     ←    arr2:1번지
		 */
		System.out.println(arr);
		System.out.println(arr2); //주소가 출력됨 
		System.out.println("1꺼내기 : "+arr2[0]);
		System.out.println("2꺼내기 : "+arr2[1]);
		System.out.println("3꺼내기 : "+arr2[2]);
		
		// 배열명 : arr3  1,2,3,4,5
		int[] arr3= {1,2,3,4,5};
		System.out.println(arr3[0]);
		
		int[] arr4 = {100,200,300};
		System.out.println(arr4[2]);
		
		double[] arr5 = {1.1,1.2,1.3};
		System.out.println(arr5[1]);
		
		// arr6: 'a', 'b', 'c'
		
		char[] arr6 = {'a','b','c'};
		System.out.println(arr6[0]);
		System.out.println(arr6[1]);
		System.out.println(arr6[2]);
		
		for (int i=0;i<arr6.length;i++) {
			System.out.println(arr6[i]);
		}
		
	}
}
