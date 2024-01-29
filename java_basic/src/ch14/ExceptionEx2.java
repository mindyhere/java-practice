package ch14;

public class ExceptionEx2 {
	public static void main(String[] args) {
		int a = 10, b = 0, c;
		try {
//		try {}블록: 실행할 명령어	
			c = a / b;
			System.out.println(c);
		} catch (Exception e) {
//		  catch {}블록: 예외가 발생했을 때 처리하는 블록
//		  Exception > RuntimeException > ArithmethicException
			e.printStackTrace();
//			  출력  스택  추적: 스택 추적정보를 출력
		}
		System.out.println("end");
	}
}