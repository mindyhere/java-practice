package ch04; //1~10까지의 수에 대해 짝수 또는 홀수 여부 확인

import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
		// 검사조건: i를 2로 나눈 나머지
				System.out.println(i + " : 짝수입니다.");
			} else {
				System.out.println(i + " : 홀수 입니다.");
			}
		}
	}
}