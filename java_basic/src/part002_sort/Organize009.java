package part002_sort;

interface Vehicle1b{public void run();}
class MotorCycle1b implements Vehicle1b{
	@Override public void run() { helmet(); System.out.println("오토바이가 달립니다."); }
	public void helmet() {System.out.println("헬멧을 착용합니다.");}
} 
class Car1b implements Vehicle1b{
	@Override public void run() { System.out.println("자동차가 달립니다."); }
} 
class Driver1b{
	
	void driver (Vehicle1b vehicle) {
		vehicle.run();
	}
}

public class Organize009 {
	public static void main(String[] args) {
		
		Driver1b driver1b = new Driver1b();

		MotorCycle1b MotorCycle1b = new MotorCycle1b();
		Car1b Car1b = new Car1b();
		
		driver1b.driver(Car1b);
		
		System.out.println("\n\n>>자동차가 고장나서 교통수단을 바꿉니다! ");
		
		driver1b.driver(MotorCycle1b);
		
	}
}
// 공통점 추상화클래스 객체화 할수없음
// 차이점 abstract 단일상속 interface 다중상속