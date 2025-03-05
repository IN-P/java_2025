package com.company.java012;
//오버라이드(@Override) - 부모메서드 나한테 맞게 수정
class MoblieNote7{
	private String iris;
	public String getIris() { return iris; }
	public void setIris(String iris) { this.iris = iris; }
	void newshow(){
		System.out.println(":::: NOTE7새로운기능");
		System.out.println("* iris 홍채인식기능!");
		System.out.println("* myiris : "+ this.iris);
	}
}

class MoblieNote8 extends MoblieNote7{
	private String face;
	public String getFace() { return face; }
	public void setFace(String face) { this.face = face; } 
	@Override //부모와 같은 메서드를 사용시 같은다른지 검사해줌 
	void newshow(){
		super.newshow();
		System.out.println(":::: NOTE8새로운기능");
		System.out.println("* face 안면인식기능!");
		System.out.println("* myFace : "+ this.face);
	}
}

class MoblieNote9 extends MoblieNote8{
	private int battery;
	public int getBattery() { return battery; }
 	public void setBattery(int battery) { this.battery = battery; }
 	@Override 
 	void newshow(){ //부모접근자보다 이상인 접근자만 사용가능
 		super.newshow();
		System.out.println(":::: NOTE9새로운기능");
		System.out.println("* battery 하루종일 사용가능!");
		System.out.println("* battery : "+ this.battery);
	}
}

public class Extends003 {
	public static void main(String[] args) {
		MoblieNote9 my9 = new MoblieNote9();
		my9.setIris("brown");
		my9.setFace("pretty");
		my9.setBattery(24);
		my9.newshow();
	}
}
