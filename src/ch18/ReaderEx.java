package ch18;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReaderEx {
	public static void main(String[] args) {
		int var = 0;
		Reader input = new InputStreamReader(System.in);
//		InputStream: 1byte 단위
//		InputStreamReader: 문자 한글자 단위(영어, 한글, 특수문자... 처리 가능)

		System.out.print("input : ");

//		입출력, cpu간섭(인터럽트), 네트워크, DB 관련 =>예외처리가 필수
//		try/catch 구문으로 예외처리
		try {
			while (true) {
				var = input.read(); // 한글자 => 변수 var에 대입
				if (var == 13)
					break;
				System.out.println(var + " ==> " + (char) var);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
