package ch14;

public class ExceptionEx1 {
	public static void main(String[] args) {
		int a = 10, b = 0, c;
		c = a / b;
		System.out.println(c);
		System.out.println("end");
	}
//	Exception in thread "main" java.lang.ArithmeticException: / by zero 
//	예외발생 => 비정상적으로 종료됨(println~ 메서드 두줄에 대해 실행 X)
//	ArithmeticException: 산술연산 관련 예외
}
