package ch06;

import java.util.Scanner;

public class Ex {

	static double length(double r) {
		return 2 * Math.PI * r;
	}

	static double area(double r) {
		return Math.PI * r * r;
	}

	public static void main(String[] args) {
		double r = 10.5;
		double l = length(r);
		double a = area(r);
		System.out.println(String.format("%.1f", l));
		System.out.println(String.format("%.1f", a));

//(Q) 반지름을 화면에서 입력받아 원 둘레, 넓이를 계산
		Scanner sc = new Scanner(System.in);
		System.out.print("반지름 r을 입력하세요 : ");
		double r2 = sc.nextDouble();
		double l2 = length(r);
		double a2 = area(r);
		System.out.println(String.format("%.1f", l2));
		System.out.println(String.format("%.1f", a2));
	}
}