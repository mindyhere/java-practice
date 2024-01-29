package ch12;

public class Wrapper {
	//기본 자료형을 클래스로 정의 -> 다양한 기능(함수)을 제공 
	public static void main(String[] args) {
		Integer i1 = 10; 	//클래스

		int num1 = i1.intValue();
		int num2 = 20;
		int sum = num1 + num2;
		System.out.println(sum);
		System.out.println(Integer.toBinaryString(sum));
	//								10진수>2진수 문자열	
		System.out.println(Integer.parseInt("100"));
	//							   추출  정수			
		System.out.println(Integer.toString(100));
		System.out.println(100 + "");
	//			100(숫자) + ""(문자열) => "100"+"" => "100"
	}
}
