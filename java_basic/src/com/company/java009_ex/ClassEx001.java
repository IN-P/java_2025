package com.company.java009_ex;

class Student001{
	String name; int no,kor,eng,math;
	void info() {
		int total = kor+eng+math;
		double avg = total/3.0;
		System.out.printf("이름 : %s\n학번 : %d\n총점 : %d\n평균 : %.2f",this.name,this.no,total,avg);
	}
}

public class ClassEx001 {

	public static void main(String[] args) {
		Student001 s1 = new Student001();
		s1.name="first";
		s1.no=11;
		s1.kor=100;
		s1.eng=100;
		s1.math=99;
		s1.info();
		
		Student001 s2 = new Student001(); 
		Student001 s3 = new Student001();
		
	}

}
