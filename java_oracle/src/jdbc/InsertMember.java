package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertMember {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String id = "java";
		String pw = "java1234";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);

			Scanner scan = new Scanner(System.in);
			System.out.print("아이디: ");
			String userid = scan.nextLine();
			System.out.print("비밀번호: ");
			String passwd = scan.nextLine();
			System.out.print("이름: ");
			String name = scan.nextLine();
			String sql = "insert into member (userid, passwd, name) values (?, ?, ?)";
			// 1 2 3 => binding
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, passwd);
			pstmt.setString(3, name);
			pstmt.executeUpdate();
			System.out.println("레코드가 추가되었습니다.");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
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
