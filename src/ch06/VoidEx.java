package ch06;

public class VoidEx {
	static void hello() {
//접근권한지정자 리턴타입 메서드이름(입력매개변수)
//타입 -> 숫자(정수/실수), 문자형(char), 논리형(boolean)
//		void(되돌려주는 값, 리턴값이 없을 경우..?)	
		System.out.println("hello"); //(2-1)
	}
//프로그램 실행 시 메인main이 우선 실행된다
	public static void main(String[] args) {
		System.out.println("start"); //(1)
		hello(); //(2) -> hello메서드 호출call
		System.out.println("end"); //(3)
	}
}
