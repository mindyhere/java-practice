package ch07;
public class Point {
//함수 오픈
//변수 보호 -> private 외부 직접사용이 금지됨
	private String name;
	private int java;
	private int db;
	private int math;
	private int tot;
	private double avg;
	private String grade;
//getter 값을 읽어오는 함수
//setter 값을 저장하는 함수
	public String getName() {
		return name;
//메서드를 호출한 곳으로 되돌려주는 코드
	}

	public void setName(String name) {
		this.name = name;
//this. ->멤버변수 프로퍼티 필드 전역변수(클래스 전체에서 사용) -> 현재 클래스의 멤버를 가리키는 변수
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getDb() {
		return db;
	}

	public void setDb(int db) {
		this.db = db;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void calc() {
		tot = java + db + math;
		avg = tot / 3.0;

		if (avg >= 90) {
			grade = "A";
		} else if (avg >= 80) {
			grade = "B";
		} else if (avg >= 70) {
			grade = "C";
		} else if (avg >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}
	}

	public void print() {
		System.out.println("Name : " + name);
		System.out.println("Java : " + java);
		System.out.println("DB : " + db);
		System.out.println("Math : " + math);
		System.out.println("Total : " + tot);
		System.out.println("Average : " + String.format("%.2f", avg));
		System.out.println("Grade : " + grade);
	}
}
