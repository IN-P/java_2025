package part002_sort;

class Score{
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
	private String pass;
	
	public Score() { super(); }
	public Score(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getKor() { return kor; }
	public void setKor(int kor) { this.kor = kor; }
	public int getEng() { return eng; }
	public void setEng(int eng) { this.eng = eng; }
	public int getMath() { return math; }
	public void setMath(int math) { this.math = math; }
	public int getTotal() { return total; }
	public void setTotal(int total) { this.total = total; }
	public double getAvg() { return avg; }
	public void setAvg(double avg) { this.avg = avg; }
	public String getPass() { return pass; }
	public void setPass(String pass) { this.pass = pass; }
}

class ScoreProcess{
	public void process_avg(Score[] std) {
		for (Score x : std) {
			x.setAvg((x.getKor()+x.getEng()+x.getMath())/3.0);
		}
	}
	public void process_pass(Score[] std) {
		for (Score x : std) {
			x.setPass(x.getAvg()<60?"불합격":x.getKor()<40||x.getEng()<40||x.getMath()<40?"과락":"합격");
		}
	}
}

class ScorePrint{
	public void show_title() {
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("이름\t국어\t영어\t수학\t평균\t합격여부");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::");
	}
	public void show(Score std) {
		System.out.printf("%s\t%d\t%d\t%d\t%.2f\t%s\n"
				,std.getName(),std.getKor(),std.getEng(),std.getMath(),std.getAvg(),std.getPass());
	}
	public void show(Score[] std) {
		show_title();
		for (Score z : std) {
			show(z);
		}
//		for (Score z : std) {
//			System.out.printf("%s\t%d\t%d\t%d\t%.2f\t%s\n"
//					,z.getName(),z.getKor(),z.getEng(),z.getMath(),z.getAvg(),z.getPass());
//		}
	}
}

public class Organize005 {
	public static void main(String[] args) {
		Score[] std = new Score[3];
		std[0] = new Score("아이언맨",100,100,100);
		std[1] = new Score("헐크",90,60,80);
		std[2] = new Score("블랙팬서",20,60,90);
		
		ScoreProcess process = new ScoreProcess();
		process.process_avg(std);
		process.process_pass(std);
		
		ScorePrint print = new ScorePrint();
		print.show(std);
	}
}
