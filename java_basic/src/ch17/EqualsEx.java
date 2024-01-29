package ch17;

import java.util.Scanner;

//A.equals(b) => A와 B의 내용을 비교
//A == B     => A와 B의 주소를 비교

public class EqualsEx {
	public static void main(String[] args) {
		String a = "hello";
		Scanner sc = new Scanner(System.in);
		System.out.print("내용을 입력하세요 : ");
		String b = sc.next();
		System.out.println(a == b);
		System.out.println(a.equals(b));
	}
}
