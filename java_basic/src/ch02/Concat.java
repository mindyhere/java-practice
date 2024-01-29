package ch02;

public class Concat {
	public static void main(String[] args) {
		String a = "Hello " + "java"; // + 는 연결. 문다열을 연결(단순 나열)
		System.out.println(a);
		String b = "point : " + 100; // 문자열과 숫자의 연결 -> 숫자를 문자열로 변환
		System.out.println(b);

		String c = "95"; // "" 는 문자열을 의미함

		System.out.println((int) '9'); // 숫자 9와 문자 9는 다르다!
		System.out.println((int) '5');

		// System.out.println(c*100); //변수 c의 값이 숫자이므로 문자열과 곱하기 연산(*) 불가
		System.out.println(Integer.parseInt(c) * 100);
		// Integer.parseInt 정수로 바꾸는 메서드?클래스??????

	}
}
