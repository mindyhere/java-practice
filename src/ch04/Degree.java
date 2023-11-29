package ch04;

import java.util.Scanner;

public class Degree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("섭씨온도를 입력하세요.(끝내려면 0을 입력하세요.) : ");
			double input = sc.nextDouble();
			if (input == 0)
				break;
			double output = (input * 1.8) + 32;
			System.out.println(output);
		}
		System.out.println("종료되었습니다.");

	}
}