package com.company.java007_ex;

public class Array2Ex001 {

	public static void main(String[] args) {
		int[][] arr2={{100,200,300},{400,500,600}};		
		for (int y=0;y<arr2.length;y++) {
			for(int x=0;x<arr2[0].length;x++) {
				System.out.print(arr2[y][x]+"\t");
			}
			System.out.println();
		}
		
	}

}
