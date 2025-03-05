package homework;

class A122{
	int a;
	A122(int a){this.a=a;}
	void show() {System.out.println(a);}
}

public class test {

	public static void main(String[] args) {
		A122 a1 = new A122(10);//기본생성자 꼭 만들필요가 없음...
		a1.show();
	}

}
