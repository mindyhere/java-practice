package ch03;

public class Point3 {
	public static void main(String[] args) {
		int java = 52;
		int db = 40;
		int math = 33;
		int tot = java + db + math;
		double avg = tot / 3.0;
		String grade = "";

		switch ((int) (avg / 10)) {
	// switch   조건건식 -> 정수, 문자, 스트링, enum(자료형이 다르면 컴파일러 에러 발생) || 실수 -> X
	//									enum 열거형변수
	//          (바꿀자료형)값
		case 10:  //정수, 상수만 가능 ||문자열 -> X && 중복 -> X
		case 9:
			grade = "A";
			break; 		// -> 블록의 끝으로 이동
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default: 		// 나머지 모든 경우(case)
			grade = "F";
		}
		System.out.println("Java: " + java);
		System.out.println("DB: " + db);
		System.out.println("Math: " + math);
		System.out.println("Total : " + tot);
		System.out.println("Average : " + String.format("%5.1f", avg));
		System.out.println("Grade : " + grade);
	}
}
