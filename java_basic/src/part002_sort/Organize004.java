package part002_sort;

class User004{
	char division;
	String jumin;
	public User004() {
		super();
		this.division = 'A';
		this.jumin = "123456-1234567";
	}
	public User004(char division, String jumin) {
		super();
		this.division = division;
		this.jumin = jumin;
	}
	@Override public String toString() {
		return "User004 [division=" + division + ", jumin=" + jumin + "]";
	}
}

public class Organize004 {
	public static void main(String[] args) {
		User004 c1 = new User004('B',"200101-1234567");
		User004 c2 = new User004();
		System.out.println(c1);
		System.out.println(c2);
	}
}
//public > protected > package(default) > private 