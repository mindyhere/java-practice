package ch02;

import java.util.Scanner;
//패ㅋ피크닉-디렉토리
//ctrl+shift + o ; import문 삽입

public class Circle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			//new 새로생성 ; new 자료형 -> 메모리에 생성	(주소를 저장)
//클래스= 변수+함수
//new 자료령 -> 메모리 동척할동
//void 출력
		
		System.out.print("반지름(r)을 입력하세요. :");
		double r = sc.nextDouble(); //실수형을 입력받는다.
		double length = 2 * Math.PI * r; // math 클래스 -> 수학계산 관련 메서드
		//Math 클래스 -> 수학계산에 필요한 내용을 포함하고 있는 클래스
		
		double area = Math.PI * r * r; //->java는 제곱연산자가 따로 없어서 풀어서 입력함
		System.out.println("반지름R : " + r);
		System.out.println("둘레(Circumference) :" + String.format("%7.2f", length));
		System.out.println("면적(Area) : " + String.format("%5.2f", area));
		System.out.println("면적(Area) : " + String.format("%5.1f", area));
		System.out.println("면적(Area) : " + String.format("%f", area));
												//format 형식을 고정
		System.out.println("면적(Area) : " + area);
	}

}
