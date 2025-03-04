package com.company.java011_ex;

//public(아무데서나 사용) > protected(extends:상속) > package(같은폴더내에서) > private(클래스내에서)

public class Milk {
	private int mno;
	private String mname;
	private int mprice;
	
	public void setMprice(int mprice) { this.mprice = mprice; }
	
	@Override
	public String toString() {
		return "Milk [mno=" + mno + ", mname=" + mname + ", mprice=" + mprice + "]";
	}
}
