package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeptDAO {
	public ArrayList<DeptDTO> listDept() {
		ArrayList<DeptDTO> items = new ArrayList<DeptDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DB.oraConn();
			String sql = "select * from dept order by dname";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				DeptDTO dto = new DeptDTO(deptno, dname);
				items.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();// TODO: handle exception
			}

			try {
				if (pstmt != null)
					pstmt.close();
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
		return items;
	}
}
