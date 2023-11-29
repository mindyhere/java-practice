package ch12;

public class DoubleEx {
	public static void main(String[] args) {
		Double num1 = 11.5;
	//  클래스	
		
		double num2 = 3.5;
		double num3 = num1 / num2;
		System.out.println(num3);
		String str = "11.5";
		System.out.println(str + 200);
		System.out.println(Double.parseDouble(str) + 200);
	//						str 스트링에서 따옴표 제거 => 문자열에서 숫자(실수형)
	//						  "11.5"       11.5(실수형)	
	}
}
