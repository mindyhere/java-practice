package ch15;

public class Sync {
	public static void main(String[] args) {
		ATM atm = new ATM();
//		   클래스 ==> 메모리: 인스턴스 생성
		Thread mom = new Thread(atm, "mom");
//							스레드 객체, 스레드 이름
		Thread son = new Thread(atm, "son");

//		스레드 시작 요청 ==> run() 실행
		mom.start();
		son.start();
	}
}
