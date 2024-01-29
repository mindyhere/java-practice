package jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StatementEx {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
//							자바 => 오라클
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
//   	   연결문자열 => jdbc:oracle:thin:@호스트:포트/데이터베이스이름
//									   호스트(DB서버) : 포트(1521 기본) / 데이터베이스(xe)
		String id = "java";
		String pwd = "java1234";
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
//실행순서 => finally 블록에서 닫을 때는 역순으로 정리한다.
//DB접속: Connection
//SQL명령어 생성: Statement, PrepareStatement
//실행: 완성된 SQL문장

		try {
			Class.forName(driver); // 오라클 드라이버 로드
			conn = DriverManager.getConnection(url, id, pwd); // 오라클에 접속
			stmt = conn.createStatement(); // SQL 실행 객체
			long start = System.currentTimeMillis();
//						시스템의 현재시각: 밀리세컨드(타임스탬프)
			for (int i = 1; i <= 10000; i++) {
				String str = "data" + i;
				String sql = "insert into test values (" + i + ", '" + str + "')";
				stmt.executeUpdate(sql);
//				완성된 SQL문 실행
			}
			long end = System.currentTimeMillis();
			System.out.println("작업수행시간: " + (end - start));

			start = System.currentTimeMillis();
			String sql = "insert into test values (?, ?)";
//											?: 파라미터(확정된 값X) => 완성되지 않은 SQL문
			pstmt = conn.prepareStatement(sql);

//			미완성인 SQL문의 '?'의 값을 설정(반복문)
			for (int i = 10001; i <= 20000; i++) {
				String str = "data" + i;
				pstmt.setInt(1, i);
				pstmt.setString(2, str);
//			 	? 에 값을 대임 => insert into test values (1,'data1')
				pstmt.executeUpdate();
			}
			end = System.currentTimeMillis();
			System.out.println("작업수행시간: " + (end - start));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 사용한 메모리 반납
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
