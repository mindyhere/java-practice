package ch19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TextDown {
	public static void main(String[] args) {
		URL url = null;
		try {
			url = new URL("https://raw.githubusercontent.com/selva86/datasets/master/ozone.csv"); // url을 탐색
			HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // url에 접속

			if (conn != null) {
				conn.setConnectTimeout(3000); // 3초가 접속 시도
				if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
//					getResponseCode 응답코드 => OK(200), NotFound(404), 논리적오류(500) etc.

//					Stream 1byte씩 ==> Reader 1문자씩 ==> BufferedReader 임시메모리저장
//					new BufferedReader(new InputStreamReader(InputStream))
//					     한꺼번에 처리				문자단위				byte 단위
					BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
					BufferedWriter bw = new BufferedWriter(new FileWriter(new File("c:/data/ozone.csv")));
//																 해당 디렉토리가 없을 경우, FileNotFoundException 발생
					while (true) {
						String line = br.readLine(); // 한 줄(Line)을 읽음
						if (line == null)
							break; // 해당 Line에 내용이 없을 경우, 종료
						bw.write(line + "\r\n");
//						\r: 캐리지리턴. 커서를 맨 앞으로 보냄
//						\n: new line. 개행문자
					}
//					사용이 끝난 버퍼(변수) 정리. 메모리반환
					br.close();
					bw.close();
					System.out.println("Done");
				}
				conn.disconnect(); // 접속 해제
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
