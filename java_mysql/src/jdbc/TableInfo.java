package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class TableInfo {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData meta = null;
//			메타데이터: 보충설명

		try {
			conn = DB.dbConn();
			String sql = "select * from scores";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			meta = rs.getMetaData();
			int cols = meta.getColumnCount();
			System.out.println("필드명\t\t자료형\tNull여부");

			for (int i = 1; i <= cols; i++) {
				String colName = meta.getColumnName(i); // 필드명
				String colType = meta.getColumnTypeName(i); // 자료형
				int isNull = meta.isNullable(i); // null 허용여부
				System.out.println(colName + "\t\t" + colType + "\t" + isNull);
			}

		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception

		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e2) {
				e2.printStackTrace();// TODO: handle exception
			}

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e2) {
				e2.printStackTrace();// TODO: handle exception
			}

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();// TODO: handle exception
			}
		}
	}
}
