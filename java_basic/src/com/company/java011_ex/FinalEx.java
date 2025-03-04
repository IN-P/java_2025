package com.company.java011_ex;

class User002 {
	   final String nation = "Korea";   
	   final String jumin;   
	   String name;

	   public User002() { jumin="00000"; }
	   public User002(String jumin, String name) { 
	      this.jumin = jumin;
	      this.name = name;
	   }
	@Override
	public String toString() {
		return "User002 [nation=" + nation + ", jumin=" + jumin + ", name=" + name + "]";
	}
	   
	   
	}
	 public class FinalEx {
	   public static void main(String[] args) {
	      User002 user1 = new User002("123456-1234567", "아이유");
	    //수동생성자 사용시 기본생성자는 사용하지 않음
	      System.out.println(user1);   
	      
//	      user1.nation = "USA";   // nation 상수 이므로 오버라이딩 불가   
//	      user1.jumin  = "123123-1234321"; //위와 동일
	      user1.name = "IU"; 
	      System.out.println(user1);   
	   }
	}