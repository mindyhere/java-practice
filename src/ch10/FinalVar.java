package ch10;

public class FinalVar {
	final static int MAX_NUM = 500;
// final => 최종, 수정불가. 상수
// static => 프로그램 시작~끝
	public static void main(String[] args) {
		System.out.println(MAX_NUM);
		// MAX_NUM = 200; => 상수이므로 저장된 데이터 변경이 불가
	}
}
