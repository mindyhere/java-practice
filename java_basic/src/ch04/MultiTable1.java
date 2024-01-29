package ch04;

import java.util.*;

public class MultiTable1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("단을 입력하세요 : ");
		int num = sc.nextInt();

		// 정수형 변수명 값 ; 변수 선언 및 초기화
		for (int i = 1; i <= 9; i++) {
			/*
			 * 시작 검사 조건변경(1씩 증가) 조건이 참일 동안 반복
			 */
			System.out.println(num + " X " + i + " = " + num * i);
		}
	}
}
