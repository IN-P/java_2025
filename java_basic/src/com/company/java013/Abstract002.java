package com.company.java013;

abstract class Shape002{
	abstract void showArea(int x,int y);
	abstract void showArea(int r);
}

class Rectangle002 extends Shape002{
	@Override void showArea(int x, int y) { System.out.println("사각형의 넓이 : "+x*y); }
	@Override void showArea(int r) {  }
}
class Triangle002 extends Shape002{
	@Override void showArea(int x, int y) { System.out.println("삼각형의 넓이 : "+x*y/2); }
	@Override void showArea(int r) {  }
}
class Circle002 extends Shape002{
	@Override void showArea(int x, int y) {  }
	@Override void showArea(int r) { System.out.println("원의 넓이 : "+(double)r*r*Math.PI); }
}//Math.PI <원주율

public class Abstract002 {
	public static void main(String[] args) {
//		Rectangle002 rec = new Rectangle002();
//		rec.showArea(10,10);
//		
//		Triangle002 tri = new Triangle002();
//		tri.showArea(10,10);
//		
//		Circle002 cir = new Circle002();
//		cir.showArea(10);
//---------------------------------------------
//		Shape002 shape = null;
//		
//		shape = new Rectangle002();
//		shape.showArea(10,3);
//		
//		shape = new Triangle002();
//		shape.showArea(10,3);
//		
//		shape = new Circle002();
//		shape.showArea(10);
//---------------------------------------------
		Shape002 shape = null;
		Shape002[] s = {new Rectangle002(),new Triangle002(),new Circle002()};
		for(int i=0;i<3;i++) {
			if (s[i] instanceof Circle002) {s[i].showArea(10);}
			else {s[i].showArea(10, 3);}
		} // instanceof - 객체가 어떤클래스인지 어떤클래스를 상속받았는지 확인
		
		Shape002[] arr = {new Rectangle002(),new Triangle002(),new Circle002()};
		arr[0].showArea(10,10);
		arr[1].showArea(10,10);
		arr[2].showArea(10);
	}

}
