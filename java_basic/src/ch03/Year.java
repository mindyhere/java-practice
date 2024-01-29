package ch03;

import java.util.Scanner;

public class Year {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Year : ");

		int year = sc.nextInt();
	//				키입력 값 ->정수로
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
	//	검사	조건 ; 	4의 배수		100의 배수가 아님			400의 배수 -> 인 연도 : 윤년			
			System.out.println(year + " is a leap year.");
		} else {
			System.out.println(year + " is not a leap year.");
		}
	}
}
