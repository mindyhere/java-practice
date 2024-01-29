package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	public List<EmpDTO> list_emp() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<EmpDTO> items = new ArrayList<>();
		try {
			conn = DB.dbConn();
			String sql = "select * from emp";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				String hiredate = rs.getString("hiredate");
				double sal = rs.getDouble("sal");
				int deptno = rs.getInt("deptno");
				EmpDTO dto = new EmpDTO(empno, ename, job, hiredate, sal, deptno);
				items.add(dto);
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
		return items;
	}

	public void insert_emp(EmpDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.dbConn();
			String sql = "insert into emp (empno, ename, job, hiredate, sal, deptno) values (?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getEmpno());
			pstmt.setString(2, dto.getEname());
			pstmt.setString(3, dto.getJob());
			pstmt.setString(4, dto.getHiredate());
			pstmt.setDouble(5, dto.getSal());
			pstmt.setInt(6, dto.getDeptno());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

	public int delete_emp(int empno) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.dbConn();
			String sql = "delete from emp where empno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
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
		return result;
	}
}
