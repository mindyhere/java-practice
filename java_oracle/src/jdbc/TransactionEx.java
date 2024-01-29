package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TransactionEx {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean success = false;

		try {
			conn = DB.oraConn();
			conn.setAutoCommit(false); // 자동커밋 X => 프로그램에서 commit을 지시해주어야 한다.

			String sql = "insert into emp_copy values (?, ?, ?)"; // 미완성 명령어
//													   1  2  3 => pstmt.	
			pstmt = conn.prepareStatement(sql); // 미완성명령어 실행 객체생성
			long start = System.currentTimeMillis();
//								현재시간을 밀리세컨드로 표시(1970.1.1 ~ 현재): 타임스탬프

			for (int i = 1; i <= 99; i++) {
				pstmt.setInt(1, i * 100);
				pstmt.setString(2, "kim" + i);
				pstmt.setInt(3, 4500);
				pstmt.addBatch();
//					  추가  배치(일괄처리)
			}
			pstmt.executeBatch(); // 한꺼번에 추가 작업 => .executeUpdate() 보다 작업효율이 더 좋다
			success = true;
			long end = System.currentTimeMillis();
			System.out.println("작업수행시간: " + (end - start));

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (success) {
					System.out.println("커밋되었습니다.");
					conn.commit();
				} else {
					System.out.println("롤백되었습니다.");
					conn.rollback();
				}

				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
