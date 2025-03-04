package com.company.java011;

//4. final class FicalEx extends Object {상속받지마
class FinalEx extends Object{ // 1. Object- 자바팀이 객체를 만들어놈 2. extend 상속 (앞에 객체 그대로 사용)
//	static String tree = "4-5"; //3-1. 식목일 - 나무심는날 기념일
	final static String tree = "4-5"; //3-3. static,final 주로 같이 사용
	String name;
	
	final void show() {System.out.println(FinalEx.tree+"/"+name);}
}

class MyDate extends FinalEx{
//	@Override void show() { super.show(); }//5.오버라이드
}

public class Final001 {

	public static void main(String[] args) {
//		FinalEx.tree="4-6"; //3-2. static 공용 ,,, 아래서에서 변경가능 
							//3-4. final 변경이 안되 - cannot be assigned
		System.out.println("식목일 - 나무심는날, 기념일(공유,변경안되는값) > "+FinalEx.tree);
		
	}

}
