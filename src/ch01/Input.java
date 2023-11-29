package ch01;

import java.util.Scanner;

//		ㄴ패키지명
public class Input {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 자료형 변수 새로생성 자료형 키입력장치

//데이터 -> 변수 & 기능 -> 메서드 함수

		System.out.print("이믈을 입력하세요 : "); // print -> 줄바꿈 안함
		String name = sc.next();
		System.out.println("Name : " + name); // println -> 줄바꿈
//		System.out.print("나이를 입력하세요 : ");
//		int age = sc.nextInt();
//						//키보드 정수 입력
//		System.out.println("Age: " + age); //스트링 + 정수 -> 연결자

//	String name1 = "김철수";
		System.out.print("출생년도를 입력하세요 : ");
		int year = sc.nextInt();
		// 청수를 입력
		int age = 2023 - year;

		System.out.println(name + "님의 나이는 만 " + age + "세 입니다.");

	}

}
