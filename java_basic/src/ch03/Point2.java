package ch03;

public class Point2 {
	public static void main(String[] args) {

		int java = 88;
		int db = 99;
		int math = 73;
		int tot = java + db + math;
		double avg = tot / 3.0;
		//@SuppressWarnings("unused")
		String grade = "";

		if (avg >= 90 && avg <= 100) {
			grade = "A";
		} else if (avg >= 80) {
			grade = "B";
		} else if (avg >= 70) {
			grade = "C";
		} else if (avg >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}

		System.out.println("Java :" + java);
		System.out.println("DB :" + db);
		System.out.println("Math :" + math);
		System.out.println("Total :" + tot);
		System.out.println("Average :" + String.format("%5.1f", avg));
	}
}
