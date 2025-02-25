package com.company.java007;

import java.util.Arrays;

public class Arr2_002 {
	public static void main(String[] args) {
		int[][] arr = new int[2][3]; // 2층 3칸 공간만 빌려옴
		
		System.out.println(Arrays.deepToString(arr));// 차원배열 문자열 Arrays.deepToString(arr)
		
//		arr[0][0]=1;
//		arr[0][1]=2;
//		arr[0][2]=3;
//		
//		arr[1][0]=4;
//		arr[1][1]=5;
//		arr[1][2]=6;

		int data=1;
		for(int y=0;y<arr.length;y++) {
			for(int x=0;x<arr[0].length;x++) {
				arr[y][x]=data; data++;
			}
		}
		System.out.println(Arrays.deepToString(arr));// 차원배열 문자열 Arrays.deepToString(arr)
		
	}
}
