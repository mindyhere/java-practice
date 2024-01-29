package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

public class StudExDAO {
	public Vector listStud(String mname) {
		Vector items = new Vector();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DB.oraConn();
			String sql = "select studno, sname, grade, profno, mname from stud s, major m "
					+ "where s.majorno = m.majorno and mname like ?";
			pstmt = conn.prepareStatement(sql);

			if (mname.equals("total")) {
				mname = "%";
			}
			pstmt.setString(1, mname);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Vector row = new Vector();
				row.add(rs.getInt("studno"));
				row.add(rs.getString("sname"));
				row.add(rs.getInt("grade"));
				row.add(rs.getInt("profno"));
				row.add(rs.getString("mname"));
				items.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
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
				e.printStackTrace();// TODO: handle exception
			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();// TODO: handle exception
			}
		}
		return items;
	}

	public ArrayList<StudExDTO> listStud(int majorno) {
		ArrayList<StudExDTO> items = new ArrayList<StudExDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DB.oraConn();
			String sql = "select studno, sname, grade, profno, mname from stud s, major m "
					+ "where s.majorno = m.majorno and s.majorno like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, majorno);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				StudExDTO dto = new StudExDTO();
				dto.setStudno(rs.getInt("studno"));
				dto.setSname(rs.getString("sname"));
				dto.setGrade(rs.getInt("grade"));
				dto.setProfno(rs.getInt("profno"));
				dto.setMname(rs.getString("mname"));
				items.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();// TODO: handle exception
			}

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();// TODO: handle exception
			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();// TODO: handle exception
			}
		}
		return items;
	}
}
