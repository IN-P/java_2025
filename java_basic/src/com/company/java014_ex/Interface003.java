package com.company.java014_ex;

interface Vehicle{public void run();}

class MotorCycle implements Vehicle {
	@Override public void run() { System.out.println("오토바이가 달린다"); }
}

class Car implements Vehicle {
	@Override public void run() { System.out.println("자동차가 달린다"); }
}

class Driver {
	public Driver() { super(); }
	void drive(Vehicle vehicle) { vehicle.run();}
}


public class Interface003 {
	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Car car = new Car(); //Vehicle 준비안해도 하위 관계인 car를 초기화 하는순간 Vehicle도 준비완료
		MotorCycle mo = new MotorCycle();
		
		driver.drive(car);
		driver.drive(mo);
	}

}
