package ch10;

class A {
	int n = 10;

	public void print() {
		System.out.println(n);
	}
}

class B extends A {
	int n = 20;

	@Override
	public void print() {
		System.out.println(n);
	}

	public void print2() {
		System.out.println(n * n);
	}
}

public class Poly {
	public static void main(String[] args) {
		B b = new B();
		b.print();
		b.print2();
		System.out.println();
		A a = new B(); // 상위클래스의 참조변수 a로 하위클래스 B의 객체를 참조
		System.out.println(a.n);
		a.print();
		//a.print2(); -> A클래스에서는 print2 가 선언되어 있지 않음. 예외발생
	}
}
