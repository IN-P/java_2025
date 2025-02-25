package com.company.java007_ex;

import java.util.Arrays;

public class ArrayEx008 {

	public static void main(String[] args) {
	    //변수
		String[] name={"아이언맨","헐크","캡틴","토르","호크아이"};
	    int[] kor={100,20,90,70,35};   
	    int[] eng={100,50,95,80,100};
	    int[] mat={100,30,90,60,100};
	    int[] aver=new int[5];
	    int[] rank=new int[5];
	    String[] star={"★","★★","★★★","★★★★","★★★★★","★★★★★★","★★★★★★★","★★★★★★★★","★★★★★★★★★","★★★★★★★★★★"}; 
	    String star1="★"; // star.repeat(aver[i]/10-1)
	    //처리
	    for(int i=0;i<name.length;i++) {aver[i]=(kor[i]+eng[i]+mat[i])/3;}
	    for(int i=0;i<name.length;i++) {
	    	int k =1;
	    	for(int j=0;j<name.length;j++) {
	    		if(aver[i]<aver[j]) k++;
	    	}
	    	rank[i]=k;
	    }
	    
	    //처리+출력
	    System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	    System.out.println("이름\t국어\t영어\t수학\t평균\t합격여부\t장학생\t등수\t스티커");
	    System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	    for(int i=0;i<name.length;i++) {
	    	System.out.printf("%s\t%d\t%d\t%d\t%d\t%s\t%s\t%d\t%s\n",name[i],kor[i],eng[i],mat[i],aver[i],aver[i]<60?"불합격":"합격",aver[i]<95?"----":"장학생",rank[i],star[aver[i]/10-1]);
	    }
	    System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");	    
	}
}
