package ch15;

// new> class > implements > add > 자동추가
public class RunnableEx implements Runnable {
//						완성, 구현		인터페이스
	@Override
//	상위 클래스의 함수를 재정의하는 것
	public void run() {
		for (int i = 1; i <= 20; i++) {
			System.out.println(Thread.currentThread().getName() + " ==> " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		RunnableEx e1 = new RunnableEx();
//		햔제 ==> Runnable ==> Thread
		Thread t1 = new Thread(e1, "thread1");
//							Runnable객체, 스레드이름
		Thread t2 = new Thread(e1, "thread2");
		t1.start(); // 작업요청
		t2.start();

		System.out.println("test1");
		System.out.println("test2");
		System.out.println("test3");
//		동시에 여려기능을 같이 처리함(순서X)
	}

}
