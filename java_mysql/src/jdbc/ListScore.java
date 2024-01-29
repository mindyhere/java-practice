package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class ListScore {
	public static void main(String[] args) {
		PreparedStatement pstmt = null; // SQL실행
		ResultSet rs = null; // select 실행 → 결과
		Connection conn = null;

		try {
			FileInputStream fis = new FileInputStream("c:/work/db.prop");
			Properties prop = new Properties();
			prop.load(fis);

			// prop → key-value로 읽어오기
			String url = prop.getProperty("url");
			String id = prop.getProperty("id");
			String password = prop.getProperty("password");
			conn = DriverManager.getConnection(url, id, password);
//			String sql = "SELECT NAME, kor, eng, mat, kor+eng+mat 총점, ROUND((kor+eng+mat)/3, 2) 평균,\r\n"
//					+ "	case\r\n" + "		when (kor+eng+mat)/3 >= 90 then 'A'\r\n"
//					+ "		when (kor+eng+mat)/3 >= 80 then 'B'\r\n" + "		when (kor+eng+mat)/3 >= 70 then 'C'\r\n"
//					+ "		when (kor+eng+mat)/3 >= 60 then 'D'\r\n" + "		ELSE 'F'\r\n" + "	END 등급\r\n"
//					+ "FROM score";
			String sql = "SELECT NAME, kor, eng, mat FROM score where name=?"; // 완성되지 않은 SQL명령어
			pstmt = conn.prepareStatement(sql); // SQL 실행객체 생성
			pstmt.setString(1, "park"); // 물음표 값을 지정
			rs = pstmt.executeQuery(); // 완성된 명령어를 실행

			System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t등급");
			while (rs.next()) {
				// rs.next()→1개의 레코드셋을 읽음
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
//				int tot = rs.getInt("총점");
//				float avg = rs.getFloat("평균");
//				String grade = rs.getString("등급");
				int tot = kor + eng + mat;
				double avg = tot / 3.0;
				String grade = "";
				
				if (avg >= 90) {
					grade = "A";
				} else if (avg >= 80) {
					grade = "B";
				} else if (avg >= 70) {
					grade = "C";
				} else if (avg >= 60) {
					grade = "D";
				} else
					grade = "F";
				
				System.out.println(name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + tot + "\t"
						+ String.format("%.1f", avg) + "\t" + grade);
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
	}
}