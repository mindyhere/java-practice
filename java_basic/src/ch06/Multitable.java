package ch06;

public class Multitable {
	static void table(int n) {
		System.out.println("====Table " + n + "====");
		for (int i = 1; i <= 9; i++) {
			System.out.println(n + "X" + i + "=" + (n * i));
		}
	}

	static void allTable() {
		for (int i = 2; i <= 9; i++) {
			System.out.println("====Table " + i + "====");
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + "X" + j + "=" + i * j);
			}
		}
	}

	public static void main(String[] args) { // <-main에서부터 프로그램 시작
//함수호출 : 함수이름(입력값)
		table(3); 
		table(5);
		System.out.println();
		for (int i = 2; i <= 9; i++) {
			table(i);
		}
		System.out.println();
		allTable();
	}
}
