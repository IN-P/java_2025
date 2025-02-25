package com.company.java007_ex;

public class Array2Ex003 {

	public static void main(String[] args) {
		int[][] arr = new int[2][3];
		for(int y=0,a=101;y<arr.length;y++) {
			for(int x=0;x<arr[0].length;x++) {
				arr[y][x]=a;
				a++;				
				System.out.print(arr[y][x]+"\t");
			}
			System.out.println();
		}
	}

}
