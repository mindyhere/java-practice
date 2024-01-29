package ch07;

public class Student {
	private String name;
	private double point;
	private int tuition;
	private int scholarship;

	public void input(String name, double point, int tuition) {
//		this.변수 -> 프로퍼티변수
		this.name = name;
		this.tuition = tuition;
		this.point = point;

		if (point >= 4.3) {
			scholarship = tuition;
		} else if (point >= 4.0) {
			scholarship = 2500000;
		} else if (point >= 3.5) {
			scholarship = 1000000;
		}
	}

	@Override
//@~ -> 어노테이션 annotation 코드에 대한 설명문
//오버라이드 -> 함수재정의
	public String toString() {
		String str = "Name : " + name + "\n";
		str += "Point : " + point + "\n";
		str += "Tuition : " + tuition + "\n";
		str += "Scholarship : " + scholarship + "\n";
// a += b -> a = a+b 을 간단히

		return str;
	}
}
