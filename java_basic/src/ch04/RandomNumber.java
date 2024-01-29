package ch04;

import java.util.Random;
import java.util.Scanner;

public class RandomNumber {
	public static void main(String[] args) {
		Random rn = new Random();
		int num =rn.nextInt(100)+1; //1~100 사이의 난수
		System.out.println(num);
		
		
//		Random r = new Random();
//		int com = r.nextInt(10);
//
//		System.out.println("컴퓨터의 숫자 : " + com);
//		Scanner sc = new Scanner(System.in);
//		int user;
//		int count = 0;
//
//		while (true) {
//			System.out.print("숫자를 입력하세요. :");
//			user = sc.nextInt();
//			count++;
//			if (com == user) {
//				System.out.println("맞았습니다.");
//				System.out.println(count + "회");
//				break;
//			} else if (com > user) {
//				System.out.println("더 큰수를 입력하세요.");
//			} else if (com < user) {
//				System.out.println("더 작은 수를 입력하세요.");
//			}
		
	}
}