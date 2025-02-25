package com.company.java007_ex;

public class Array2Ex005 {

	public static void main(String[] args) {
		//변수
		int[][] arr = {
				   { 1, 1, 1,},
				   { 2, 2, 2,},
				   { 3, 3, 3,},
				   { 4, 4, 4,},
				 };
		int total=0; 
		double avg=0;
		//처리
		for(int y=0;y<arr.length;y++) {
			for(int x=0;x<arr[0].length;x++) {
				total+=arr[y][x];
			}
		}
		avg=(double)total/(arr.length*arr[0].length);
		//출력
		System.out.println("총점 : "+total);
		System.out.println("평균 : "+avg);
	}

}
