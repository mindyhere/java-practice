package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

public class EmpDAO {
	public Vector listEmp(String dname) {
		Vector items = new Vector();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DB.oraConn(); // DB접속
			String sql = "select empno, ename, job, hiredate, sal, dname from emp e, dept d "
					+ "where e.deptno = d.deptno and dname like ?";
//			System.out.println(sql);	SQL문장 확인(출력)
			pstmt = conn.prepareStatement(sql); // 완성되지 않은 SQL문(sql)을 준비

			if (dname.equals("전체부서")) {
				dname = "%";
			}
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery(); // 완성된 SQL 실행

			while (rs.next()) {
				Vector row = new Vector(); // 1개의 레코드 저장 벡터
				row.add(rs.getInt("empno"));
//					참조변수.get자료형("필드명" or 필드번호)	
//				  행.add(값)
				row.add(rs.getString("ename"));
				row.add(rs.getString("job"));
				row.add(rs.getDate("hiredate"));
				row.add(rs.getInt("sal"));
				row.add(rs.getString("dname"));
				items.add(row); 	//전체 벡터에 데이터 저장
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
		return items;
	}

	public ArrayList<EmpDTO> listEmp(int deptno) {
		ArrayList<EmpDTO> items = new ArrayList<EmpDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DB.oraConn();
			String sql = "select empno, ename, job, hiredate, sal, dname from emp e, dept d where e.deptno = d.deptno and e.deptno =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EmpDTO dto = new EmpDTO();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setHiredate(rs.getDate("hiredate"));
				dto.setSal(rs.getInt("sal"));
				dto.setDname(rs.getString("dname"));
				items.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();// TODO: handle exception
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace(); // TODO: handle exception
			}
		}
		return items;
	}
}
