package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ListMember {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String id = "java";
		String pwd = "java1234";

		Connection conn = null; // DB접속
		PreparedStatement pstmt = null; // SQL실행(Create, Read, Update, Delete:CRUD)
		ResultSet rs = null; // 실행결과 출력

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pwd);
			String sql = "select * from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);

			while (rs.next()) {
				String userid = rs.getString("userid");
				String passwd = rs.getString("passwd");
				String name = rs.getString("name");
				System.out.println(userid + "\t" + passwd + "\t" + name);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
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
