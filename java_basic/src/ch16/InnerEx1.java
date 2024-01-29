package ch16;

public class InnerEx1 { //outer 클래스
	static int x = 10;

//	내부클래스: 클래스 안에 선언된 클래스. inner 클래스
//	javac InnerEx1.java => InnerEx1.class 컴파일
//						   InnerEx1$Inner.class 컴파일
	class Inner {
		int getX() {
			return x;
		}
	}

	public static void main(String[] args) {
		System.out.println(x);
		InnerEx1 e = new InnerEx1();
		InnerEx1.Inner in = e.new Inner();
//    외부클래스.내부클래스 참조변수
		System.out.println(in.getX());
	}
}
