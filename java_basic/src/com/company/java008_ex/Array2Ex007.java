package com.company.java008_ex;

public class Array2Ex007 {

	public static void main(String[] args) {
		int[][] arr = new int[5][5];
		
		for (int y=0,n=1;y<arr.length;y++) {
			for(int x=0;x<arr[0].length;x++) {
				arr[y][x]=n; n++;
				System.out.print(arr[y][x]+"\t");
			}
			System.out.println();
		}
	}

}
