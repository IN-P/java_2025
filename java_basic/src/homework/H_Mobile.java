package homework;

class Mobile{
	String company,product;
	float price;
	
	public Mobile() {
		this.company="Samsung";
		this.price=1200000;
		this.product="NOTE9";
	}
	
	public Mobile(String company, int price, String product) {
		this.company = company;
		this.price = price;
		this.product = product;
	}
	
	void sale() {this.price = this.price*9/10;}
	void show() {
		System.out.println("=== Mobile ===");
		System.out.println("회사 : "+this.company);
		System.out.println("제품 : "+this.product);
		System.out.println("가격 : "+this.price);
		System.out.println();
		System.out.println();
	}
}

public class H_Mobile {
	public static void main(String[] args) {
		Mobile m3 = new Mobile("Samsung",10000,"NOTE20");
		m3.show();
		Mobile m2 = new Mobile();
		m2.show();
		Mobile m1 = new Mobile();
		m1.company="Samsung";
		m1.price=1000000;
		m1.product="NOTE20";
		m1.sale();
		m1.show();
		
	}
}
