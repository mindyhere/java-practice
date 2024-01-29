package ch18;

import java.io.IOException;

//	  InputStream
//프로그램  <==  데이터(1byte 씩)
public class InputStreamEx {
	public static void main(String[] args) throws IOException {
//예외처리  	1. throw: 예외 발생 시 => IOException 클래스에서 예외처리
//			2. try/catch => 클래스 내에서 예외처리
		int a = 0;

		// try {
		System.out.print("Input : ");
		a = System.in.read();
//	변수 a <= 문자코드를 읽는 기능

		while (a != 13) {
//					\n: enter. 개행문자 코드
			System.out.println(a + " ==> " + (char) a);
//							 int타입		  형변환 (문자)변수
			a = System.in.read();
		}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
