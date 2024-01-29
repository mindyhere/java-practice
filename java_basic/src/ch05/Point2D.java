package ch05;
//패키지 - 디렉토리
//클래스 - 파일
public class Point2D {
	//class 클래스이름 -> 데이터(변수) + 기능(메서드)
	//{} 중괄호 블록
	public static void main(String[] args) {
		int[][] point = {
				{ 80, 90, 100, 0, 0 },
				{ 70, 60, 95, 0, 0 },
				{ 88, 77, 66, 0, 0 },
				{ 99, 89, 95, 0, 0 },
				{ 100, 60, 50, 0, 0 }
				// 열 Java, DB, Math, Total, Average
		};

		for (int i = 0; i < 5; i++) {
			point[i][3] = point[i][0] + point[i][1] + point[i][2];
			point[i][4] = point[i][3] / 3;
			
			
		}

		System.out.println("Java \t DB \t Math \t Tot \t Avg");
		System.out.println("=============================================");

		for (int i = 0; i < 5; i++) {
			System.out.println(
					point[i][0] + "\t" + point[i][1] + "\t" + point[i][2] +
					"\t" + point[i][3] + "\t" + point[i][4]);
		}
	}

}
