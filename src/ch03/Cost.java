package ch03;

import java.util.Scanner;

public class Cost {
	public static void main(String[] args) {
	//변수선언 ; 자료형 변수명;
		int point_use = 0;
		int fee = 0;
		int pay = 0;
	//초기값 '0'으로 변수를 초기화
		
	//클래스.변수  or  클래스.함수()
		Scanner sc = new Scanner(System.in);
		System.out.print("Name : ");
		String name = sc.next();
	/*Stirng "문자열"
	  character 'A' */
		
		System.out.print("Price: ");
		int price = sc.nextInt();

		System.out.print("Point: ");
		int point = sc.nextInt();

		if (price < 20000) {
	// 검사	조건
			fee = 2000; //조건이 true 일 때, 배송료 추가
		}
		
		if (point >= 10000) {
			if (point > price) {
				point_use = price;
			} else {
				point_use = point;
			}
			pay = price + fee - point;
		} else {
			pay = price + fee;
		}

		System.out.println("Name: " + name);
		System.out.println("Price: " + price);
		System.out.println("Fee: " + fee);
		System.out.println("Point used: " + point_use);
		System.out.println("Pay: " + String.format("%,d",pay));
	// 												%d 십진수
	//												%,d 천단위 구분기호 표시

	}
}
