package com.company.java014;

abstract class Fruit{
	@Override public String toString() { return "Fruit"; }
	public abstract void myfruit();
}

class Apple extends Fruit{
	@Override public void myfruit() { System.out.println("사과는 빨갛다"); }
}
class Banana extends Fruit{
	@Override public void myfruit() { System.out.println("바나나는 노랗다"); }
}
class Coconut extends Fruit{
	@Override public void myfruit() { System.out.println("코코넛은 코코하다"); }
}

public class Abstract005 {

	public static void main(String[] args) {
		Fruit[] fruits = {new Apple(),new Banana(),new Coconut()};
		for (Fruit f : fruits) {f.myfruit();}
	}

}
