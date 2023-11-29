package ch14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiException {
	public static void main(String[] args) {
		int num = 50;
		Scanner sc = null; // null: 가리키는 값이 없는 상태를 의미
		try {
			System.out.print("Number: ");
			sc = new Scanner(System.in);
			int value = sc.nextInt();
			System.out.println(num / value);
		} catch (NullPointerException e) {
			System.out.println("NullPointerException"); // 참조변수(O), 내용(X)
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException"); // 산술연산 관련, 몫이 0
		} catch (InputMismatchException e) {
			System.out.println("InputMismatchException"); // 타입 불일치
		} catch (Exception e) {
			System.out.println("Other Exception"); // 모든 예외
		} finally { // 예외 발생 여부에 관계없이 항상 실행되는 블록{}
			if (sc != null) { // !=: not equal
				sc.close(); // 메모리정리
			}
		}
		System.out.println("End");
	}

}
