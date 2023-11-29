package ch15;

public class ThreadEx2 {
//프로그램 시작
//	"main" 기본스레드 => thread1 & thread2  동시에 run() 실행
	public static void main(String[] args) {
		MyThread t1 = new MyThread("thread1");
//						인스턴스 생성	생성자 호출
		MyThread t2 = new MyThread("thread2");

		t1.start(); // => 작업요청
		t2.start(); // => 작업요청
	}
}
