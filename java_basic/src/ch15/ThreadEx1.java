package ch15;

public class ThreadEx1 extends Thread {
	// 생성자: 클래스이름과 이름이 같다. 리턴타입 없음
	public ThreadEx1(String name) {
		super(name);
//	this.멤버: 현재 클래스의 멤버	<=> super.멤버: 상위 클래스의 멤버
//	this() 현재 클래스의 생성자	<=> super(): 상위 클래스의 생성자
	}

	@Override
	public void run() {
		for (int i = 1; i <= 9; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);

//			// 처리시간
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}

	public static void main(String[] args) {
		ThreadEx1 e1 = new ThreadEx1("T1");
		ThreadEx1 e2 = new ThreadEx1("T2");
		ThreadEx1 e3 = new ThreadEx1("T3");
		e1.start(); // run() 실행
		e2.start();
		e3.start();
		
//single thread: 1개의 작업단위. 순서대로 처리
//multi thread: 2개 이상의 작업단위. 동시에 처리(순서X, 보다 빠른 처리)
	}

}
