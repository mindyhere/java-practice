package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

//ScoreDAO.java	=> SQL문 실행. (Data Access Object 데이터 접근 객체)
public class ScoreDAO {
	public int deleteScore(String student_no) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DB.oraConn();
			String sql = "delete from score where student_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student_no);
			result = pstmt.executeUpdate(); // SQL실행, 삭제된 레코드 수를 result에 저장

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
		return result;
	}

	public int updateScore(ScoreDTO dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DB.oraConn();
			String sql = "update score set name = ?, kor=?, eng=?, mat=? where student_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getKor());
			pstmt.setInt(3, dto.getEng());
			pstmt.setInt(4, dto.getMat());
			pstmt.setString(5, dto.getStudent_no());
			result = pstmt.executeUpdate();
//			SQL명령어 실행=>테이블에 추가=>몇행 추가
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
		return result;	//몇 행이 추가되었는지 결과를 반환
	}

	public int insertScore(ScoreDTO dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DB.oraConn();
			String sql = "insert into score values (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getStudent_no());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			result = pstmt.executeUpdate();

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
		return result;
	}

	public Vector listScore() {
		Vector items = new Vector();
		Connection conn = null; // DB 접속
		PreparedStatement pstmt = null; // SQL 생성, 실행
		ResultSet rs = null; // 결과집합

		try {
			conn = DB.oraConn(); // oracle.prop 접속시도
			String sql = "select student_no, name, kor, eng, mat,(kor+eng+mat) tot, round((kor+eng+mat)/3.0, 1) avg from score";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // pstmt에 준비된(저장된) SQL명령어 실행
//			시작주소를 가리킴. 
//			BOF(Begin of File) -> next() -> EOF ==> 한 줄(row)씩 벡터로

			while (rs.next()) {
				Vector row = new Vector();
				String student_no = rs.getString("student_no");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int tot = rs.getInt("tot");
				double avg = rs.getDouble("avg");

				row.add(student_no);
				row.add(name);
				row.add(kor);
				row.add(eng);
				row.add(mat);
				row.add(tot);
				row.add(avg);
//				행벡터에 필드(데이터) 추가 
				items.add(row);
//				전체벡터.add(행벡터) => 전체 데이터(행벡터row)를 벡터(items)에 추가
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
		return items; // 호출한 곳(ScoreMain)으로 값(벡터 items)을 반환
	}

}
