package ch03;

import java.util.Scanner;

public class Quiz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("거리를 입력하세요(km) : ");

		double km = sc.nextDouble();
		double m = km * 1000;
		int fee = 0; 

		if (m <= 2000) {
			fee = 4000; 	//2km 까지, 기본요금
		} else {
			double tmp = m - 2000; //기본요금거리 2km를 초과하여 이동한 거리
			fee = 4000 + ((int) Math.ceil(tmp / 1000.0)) * 1000; //추가금 계산 : 1km 마다 1000원 추가
	// 올림함수 : Math.ceil
	// 반올림 : Math.round
	// 버림 : Math.floor
		}
		System.out.println("요금 : " + fee);
	}
}