package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteMember {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String id = "java";
		String pwd = "java1234";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pwd);
			Scanner sc = new Scanner(System.in);
			System.out.print("삭제할 아이디: ");
			String userid = sc.nextLine();
			String sql = "delete from member where userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.executeUpdate();

			int rows = pstmt.executeUpdate();
//			삭제된 레코드수
			if (rows > 0) {
				System.out.println("레코드가 삭제되었습니다.");
			} else {
				System.out.println("아이디를 확인하세요.");
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
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
