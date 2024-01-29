package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DB {
	public static Connection oraConn() {
		Connection conn = null;
		try {
			FileInputStream fis = new FileInputStream("c:/work/oracle.prop");
//			파일내용 => 1바이트씩 읽음

			Properties prop = new Properties();
			prop.load(fis);
//			등호(=) 기준, key = value 구조로 해당 파일의 데이터를 읽는다. 
//			=> 아래 각 변수(url, id, password)에 데이터(values)저장

			String url = prop.getProperty("url");
			String id = prop.getProperty("id");
			String password = prop.getProperty("password");
			conn = DriverManager.getConnection(url, id, password);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}
}


//oracle.prop => DB접속정보 프로퍼티파일
//DB.java => DB 접속, Connection 리턴
//ScoreDTO.java	=> 레코드. Data Transfer Object(데이터 전달 객체)
//ScoreDAO.java	=> SQL문 실행. Data Access Object(데이터 접근 객체)
//ScoreMain.java => 시작화면설계(GUI), 점수 목록 화면
//SaveScore.java => 점수 등록 화면
//EditScore.java => 점수 수정/삭제 화면
