package jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectEx {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/web?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
//			연결문자열   jdbc:mysql://호스트:포트/데이터베이스		공개키 true					보안접속 false 	서버시간대(서울)
		String id = "user"; // 사용자아이디
		String password = "1234"; // 비번
		Connection conn = null; // DB접속
		Statement stmt = null; // SQL실행(완성된 SQL명령어)
		ResultSet rs = null; // 실행결과

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // mySQL 드라이버 로드
			conn = DriverManager.getConnection(url, id, password); // mySQL 접속
			String sql = "select * from books";
			stmt = conn.createStatement(); // SQL 실행객체 생성
			rs = stmt.executeQuery(sql); // SQL문 실행

			System.out.println("book_code\t"+"title\t"+"author\t"+"year\t"+"price");
			while (rs.next()) {
				int book_code = rs.getInt("book_code");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String year = rs.getString("year");
				int price = rs.getInt("price");
				System.out.println(book_code + "\t\t" + title + "\t" + author + "\t" + year + "\t" + price);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();// TODO: handle exception
			}

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();// TODO: handle exception
			}

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();// TODO: handle exception
			}
		}
	}
}