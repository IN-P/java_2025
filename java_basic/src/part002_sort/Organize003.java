package part002_sort;

class Sawon005{
	int pay=10000; 
	static int su=10;
	//static int basicpay=pay; 
	static int basicpay2;
	static {basicpay2=20000;}
	
	public static void showSu() {System.out.println(su);}
	//public static void showPay() {System.out.println(this.pay);}
	public void showAll001() {
		System.out.println(su);
		System.out.println(this.pay);
	}
	public static void showAll002() {
	//	showAll001();
	//	System.out.println(this.pay);
	}
	// 클래스변수,메서드에는 인스턴스변수,메서드를 담을 수 없다.
	// 컴파일러가 진행되면 먼저 클래스변수와 메서드가 method 영역에 올라가고 
	// 그다음 인스턴스변수와 메서드가 heap 영역에 올라오므로 에러발생
}

public class Organize003 {
	public static void main(String[] args) {
		Sawon005 sola = new Sawon005();
		sola.showAll001();
	}
}
