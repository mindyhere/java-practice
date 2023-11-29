package ch07;

public class PointUse {
// 클래스 -> 속성(변수)+기능(함수)
	public static void main(String[] args) {
		Point p1 = new Point();
// 클래스이름 참조변수 = new 클래스이름(); ->클래스의 선언&생성
// new 생성
// new 자료형(클래스)

		p1.setName("kim");
		p1.setJava(90);
		p1.setDb(80);
		p1.setMath(89);
		p1.calc();
		p1.print();
	}
}
