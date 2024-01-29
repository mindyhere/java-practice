package ch18;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedReaderEx {
	public static void main(String[] args) {

//		Buffer: 임시메모리 영역
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//								BufferedReader	<== 한 글자 단위 <== InputStream 1byte단위
		System.out.print("input : ");
		try {
			String str = br.readLine();
//		변수 str에 저장  <=  한 줄(Line) 읽기기능
			System.out.println(str);
//			실행시, BufferedReader에 의해 입력받아 임시저장된 내용 그대로 출력된다.(문자코드 X)	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
