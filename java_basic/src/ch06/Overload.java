package ch06;

public class Overload {
	public static void main(String[] args) {
		print(10);
		print(100.5);
		print("java");
	}
//F 메서드가 정의 된 위치로 이동
	static void print(String str) {
		System.out.println(str);
	}

	static void print(double d) {
		System.out.println(d);
	}

	static void print(int i) {
		System.out.println(i);
	}
}
