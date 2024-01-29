package ch04;

import java.util.Scanner;

public class MultiTable2 {
	public static void main(String[] args) {
		for (int i = 2; i <= 9; i++) {
			System.out.println("[table " + i + "]");
			for (int j = 1; j <= 9; j++) { 
				System.out.println(i + "X" + j + "=" + i * j);  
			}
			System.out.println(); // 줄바꿈만 실행 -> 한줄 여백
		}
		
	Scanner sc = new Scanner(System.in);
	System.out.print("2~9 사이 숫자를 입력하세요 -> ");
	int user = sc.nextInt();
	
	System.out.println(user + "단?");
	for (int i = 1; i<=9; i++) {
		System.out.println(user + " X " + i + " = " + user*i);
	}
	
	}
}
