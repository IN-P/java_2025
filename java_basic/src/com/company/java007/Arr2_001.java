package com.company.java007;

import java.util.Arrays;

public class Arr2_001 {
	public static void main(String[] args) {
		int[][] arr= { {1,2,3}, //00 01 02
					   {4,5,6}	//10 11 12
					};
		System.out.println(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.deepToString(arr));
		
		//ver-1 눈에보이는대로
		System.out.print(arr[0][0]+"\t"); System.out.print(arr[0][1]+"\t"); System.out.print(arr[0][2]+"\n");
		System.out.print(arr[1][0]+"\t"); System.out.print(arr[1][1]+"\t"); System.out.print(arr[1][2]+"\n");
		
		//ver-2 칸정리
		for(int kan=0;kan<3;kan++) {System.out.print(arr[0][kan]+"\t");} System.out.println();
		for(int kan=0;kan<arr[0].length;kan++) {System.out.print(arr[1][kan]+"\t");} System.out.println();
		
		//ver-3 층정리
		for(int ch=0;ch<arr.length;ch++) {
			for(int kan=0;kan<arr[0].length;kan++) {
				System.out.print(arr[ch][kan]+"\t");
			}
			System.out.println();
		}
		
		
	}
}
