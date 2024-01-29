package ch14;

public class ThrowsEx {
	public static void main(String[] args) throws InterruptedException {		
//		Unhandled exception type InterruptedException 
//		sleep => CPU간섭으로 예외발생
//		(1) throws InterruptedException 선언  or  (2) try~ catch~구문 추가
		
		for (int i = 10; i >= 1; i--) {
			System.out.println(i);
			Thread.sleep(1000); //1초, CPU 샐힝 멈춤
//						밀리세컨드
		}
	}
}
