package ch03;

import java.util.Scanner;

public class EvenOdd {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Number : ");
		int num = sc.nextInt();
	//			  정수 입력
		if (num %2 ==0) {
	/*  검사     조건
				% 나머지
			*/
			System.out.println(num + " is even.");
		} else {
			System.out.println(num + " is odd. ");
		}
			
	}
}
