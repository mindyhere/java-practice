package ch15;

public class ATM extends Thread {
//	       Thread 클래스 상속 => run() 의 오버라이딩 => start() 호출에 의해 스레드 실행
	private int deposit = 100000;

//	멀티스레드 실행
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			withdraw(10000);
		}
	}

	public synchronized void withdraw(int money) {
//			  동기화 => 특정 객체 or method 에 lock : 순서대로 처리. 멀티스레드가 일어나지 않도록 막는다.
		String name = Thread.currentThread().getName();
//						현재 실행중인 스레드 이름
		if (deposit > 0) {
			deposit = deposit - money;
			System.out.println(name + " - 잔액 : " + deposit);
		} else {
			System.out.println(name + " - 잔액이 없습니다.");
		}
	}
}
