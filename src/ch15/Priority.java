package ch15;

public class Priority extends Thread {
//				     확장(상속)  상위클래스
// Thread 클래스 상속 => run() 의 오버라이딩 => start() 호출에 의해 스레드 실행

	public static void main(String[] args) {
		Priority p1 = new Priority();
		Priority p2 = new Priority();
		p1.setName("thread 1");
		p2.setName("thread 2");
//		스레드 이름 설정

		System.out.println("p1의 우선순위(변경 전) : " + p1.getPriority());
		System.out.println("p2의 우선순위(변경 전) : " + p2.getPriority());
//		동일한 우선순위 => 최소 1~10 최대, 기본값 5

		p1.setPriority(Thread.MIN_PRIORITY); // 우선순위변경 1
		p2.setPriority(Thread.MAX_PRIORITY); // 우선순위변경 10
		System.out.println("p1의 우선순위(변경 후) : " + p1.getPriority());
		System.out.println("p2의 우선순위(변경 후) : " + p2.getPriority());

		p1.start();
		p2.start();
//		스레드 실행요청 => 우선순위에 따라 thread2를 우선 실행
	}

	@Override
	public void run() {
		for (int i = 1; i <= 100000; i++) {
			System.out.println(Thread.currentThread().getName() + " ==> " + i);
//			화면 출력 시 우선순위에 따라 thread2가 먼저 완료되는 것을 확인할 수 있다.
		}

	}
}
