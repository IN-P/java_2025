package com.company.java008_ex;

import java.util.Scanner;

public class MethodEx004{
	
	public static int process_total(int a, int b, int c) {return a+b+c;}  	
	public static float process_avg(int a) {return a/3.0f;}  	
	public static String process_pass(float a, int b, int c, int d) {
//		if(a<60) {return "불합격";}
//		else if(b<40||c<40||d<40) {return "재시험";}
//		return "합격";
		return a<60?"불합격":b<40||c<40||d<40?"재시험":"합격"; //삼항버전
		}
	public static String process_scholar(float a) {return a<95?"":"장학생";}
	public static String process_star(float a) {String star = "★"; return star.repeat((int)a/10);}
	public static void process_show(String name,int kor,int eng,int math,int total,float avg,String pass,String jang,String star) {
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학생\t랭킹");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s\n",name,kor,eng,math,total,avg,pass,jang,star);
		System.out.println("--------------------------------------------------------------------------------");
		}
	
	public static void main(String[] args) {
	  /////////////////////(1)  변수
	  String name  = ""; 
	  int kor, eng, math, total ;
	  float avg = 0.0f; 
	  String pass = "";
	  String jang = "";
	  String star= ""; 
//	  String level_kor="" , level_eng="" , level_math=""; 
//	  String re = "";
	  Scanner scanner = new Scanner(System.in);	  
	  /////////////////////(2) 입력 : 이름, 국어, 영어, 수학점수를 입력받으시오.
	  System.out.print("이름 > "); name=scanner.next();
	  System.out.print("국어 > "); kor=scanner.nextInt();
	  System.out.print("영어 > "); eng=scanner.nextInt();
	  System.out.print("수학 > "); math=scanner.nextInt();
	  scanner.close();
	  /////////////////////(3) 처리 : 
	  total = process_total(kor , eng, math);    // 1. 총점처리
	  
	  avg = process_avg(total);    //2.  평균처리
	  
	  ////////3.  합격  평균이60이상이고, 각각 국어, 영어, 수학40이상/불합격/재시험-각각 40미만인게 있다면  
	  pass = process_pass(avg , kor, eng, math);  
	  
	  //////// 4. 평균이 95점이상이면 장학생
	  jang = process_scholar(  avg  ); 
	  
	  //////// 5. 평균점수대로 별표 붙이기 , 예) 70점대이면 별7개, 80점대이면 별8개, 90점대이면 별9개 , 100점이면 별10개 
	  star = process_star(avg);  
	  
	  
	  /////////////////////(4) 출력
	  process_show(name, kor, eng, math, total, avg, pass, jang, star);
	
	  
	   }// end main
	 
	   
	}// end class

