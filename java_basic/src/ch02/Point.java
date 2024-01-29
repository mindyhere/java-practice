package ch02;

import java.util.Scanner;

public class Point {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	/*	입력		참조	생성자		입력스트림
inputstream
outputstream

클래스 = 데이터(변수) + 기능(함수;method)
		*/
		System.out.print("Name : ");
		String name = sc.next();
		System.out.print("Java : ");
		int java = sc.nextInt();
	//					정수입력
		System.out.print("DB : ");
		int db = sc.nextInt();
		System.out.print("Math : ");
		int math = sc.nextInt();
		int tot = java + db + math;
		double avg = tot / 3.0; 
	/*	정수/정수 -> 결과값으로 정수형
	 *	정수/실수 -> 결과값으로 실수형
	 *	실수/실수 -> 결과값으로 실수형
	 */
		System.out.println("Name : " + name);
		System.out.println("Java : " + java);
		System.out.println("DB : " + db);
		System.out.println("Math : " + math);
		System.out.println("Total : " + tot);
		System.out.println("Average : " + String.format("%5.1f", avg));
	/*									  % 출력위치
										  5.1 ; 전체 자리수.소수이하 자리수
										  f ; float 부동 소수점
	 									  double ; 8byte
	 									  		   정수 5바이트, 소수 3바이트
	 									  		   고정소수점, 부동소수점*/
		System.out.println("Average : " + avg); //-> double ; 소수점 이하 15자리까지

	}
}
