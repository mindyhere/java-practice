package ch02;

import java.util.Scanner;

public class Condition {
	public static void main(String[] args) {
//		int num = -5;
//		System.out.println(num > 0 ? num : -num);
//		// 삼항연산자 -> 조건? true : false
//
//		// if 조건문 활용
//		if (num > 0) {
//			System.out.println(num); // 조건이 true일 때
//		} else {
//			System.out.println(-num); // 조거이 false 일 때
//		}
//
//		System.out.println(Math.abs(num)); // Math 클래스 내 메서드를 활용

		Scanner sc = new Scanner(System.in); 
			//변수선언 : 자료형 변수이름 ; (ex) Scanner sc
			// 값 value 저장 (ex. int a= 100 -> a의 값으로 100을 저장)
			// 주소 address 저장(ex. String a = "hello" -> 문자열이 저장된 주소가 참조변수 a에 저장된다)
		System.out.print("점수를 입력하세요. Point : ");
		int p = sc.nextInt(); //키 입력값을 정수로 변환하는 함수(메서드)
			//참조변수.변수
			//참조변수.함수()

		System.out.println("결과는 " + (p >= 70 ? "합격" : "불합격") + "입니다.");
		
		if (p >= 70) {
			System.out.println(p + "점 으로 합격입니다.");
		} else {
			System.out.println(p +"점 으로 불합격입니다.");
					}
		
	}

}
