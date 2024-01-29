package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ListBook {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
//		 			 연결문자열
		String id = "java";
		String pwd = "java1234";
		Connection conn = null; // 접속
		PreparedStatement pstmt = null; // SQL실행
		ResultSet rs = null; // 결과셋

		try {
			Class.forName(driver); // Oracle 드라이버 로딩
			conn = DriverManager.getConnection(url, id, pwd); // DB접속
			Scanner sc = new Scanner(System.in);
			System.out.print("도서명을 입력하세요: ");
			String book_title = sc.nextLine(); // 사용자가 입력한 한 Line을 String으로 저장
			String sql = "select * from books where title like ? order by title";
//													제목,	like(부분검색) & "?" 매핑 => 미완성 상태의 SQL문	
			pstmt = conn.prepareStatement(sql); // 준비 명령어
			pstmt.setString(1, "%" + book_title + "%");
//									 첫번재 물음표
			rs = pstmt.executeQuery();
			System.out.println("코드\t도서명\t\t저자\t연도\t단가");

			while (rs.next()) {
//				   rs.next() => 포인터가 다음으로 이동
//			while (자료가 있으면 true, 없으면 false)	
				int book_code = rs.getInt("book_code");
//								   get자료형("필드명")
				String title = rs.getString("title");
				String author = rs.getString("author");
				String year = rs.getString("year");
				int price = rs.getInt("price");
				System.out.println(book_code + "\t" + title + "\t\t" + author + "\t" + year + "\t" + price);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
