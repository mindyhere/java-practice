package ch18;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileWrite {
	public static void main(String[] args) {
		OutputStream os = null;
//		로컬변수는 반드시 초기화작업
		try {
			os = new FileOutputStream("c:/data/test.txt");
//				   	 파일에 내용 저장			파일 경로
//			os <= "c:/data/test.txt"
			System.out.print("Input: ");
			while (true) {
				int ch = System.in.read();
				System.out.println(ch + " ==> " + (char) ch);
				if (ch == 13) // 줄바꿈문자(\n: enter)
					break;
				os.write(ch);
			}
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
