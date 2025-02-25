package com.company.java007_ex;

import java.util.Arrays;

public class Array2Ex006 {

	public static void main(String[] args) {
		int[][] datas = {  
			{  10, 10, 10 ,10}, 
            {  20, 20, 20 ,20}, 
            {  30, 30, 30 ,30},  
		};
		int[][] result = new int[datas.length+1][datas[0].length+1];
		int lx=datas[0].length,ly=datas.length;

		for (int y=0;y<ly;y++) {
			for(int x=0;x<lx;x++) {
				result[y][x]=datas[y][x];//각항에 덮어쓰기
				result[y][lx]+=datas[y][x];//가로줄 합 누적
				result[ly][x]+=datas[y][x];//세로줄 합 누적
//				result[ly][lx]+=datas[y][x]; //총합으로도 표현가능
			}
			result[ly][lx]+=result[y][lx];//마지막열 세로줄 합 누적
		}
		for (int y=0;y<ly+1;y++) {
			for (int x=0;x<lx+1;x++) {
				System.out.print(result[y][x]+"\t");
			}
			System.out.println();
		}
		
	}

}
