package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MajorExDAO {
	public ArrayList<MajorExDTO> listMajor() {
		ArrayList<MajorExDTO> items = new ArrayList<MajorExDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DB.oraConn();
			String sql = "select * from major order by mname";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int majorno = rs.getInt("majorno");
				String mname = rs.getString("mname");
				MajorExDTO dto = new MajorExDTO(majorno, mname);
				items.add(dto);
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
}