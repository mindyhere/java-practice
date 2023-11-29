package ch15;

public class SingleThread {
	void print() {
		System.out.println(Thread.currentThread().getName());
//							스레드	현재실행중인스레드	이름
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		SingleThread t = new SingleThread();
		t.print();	//(1)
		t.print();	//(2)
//		(1) 이 완료되고 나서 (2) 를 처리
	}
}
