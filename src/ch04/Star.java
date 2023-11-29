package ch04;

public class Star {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) { //중첩 for문
				System.out.print("*"); //가로방향으로 나열(반복)
			}
			System.out.println();
		}
		System.out.println(); //매개변수 없는 경우 줄바꿈

		for (int i = 5; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
