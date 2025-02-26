package com.company.java008_ex;

public class Array2Ex008 {

	public static void main(String[] args) {
		int[][] arr = new int[4][4];
		
		for (int y=0;y<arr.length;y++) {
			for(int x=0,n=1;x<arr[0].length;x++) {
				arr[y][x]=n; n++;
				System.out.print(arr[y][x]+"\t");
			}
			System.out.println();
		}
	}

}
