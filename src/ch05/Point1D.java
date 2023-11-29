package ch05;

public class Point1D {
	public static void main(String[] args) {
		String[] name = { "A", "B", "C", "D", "E" };
		int[] java = { 100, 80, 70, 60, 90 };
		int[] db = { 80, 90, 95, 85, 75 };
		int[] math = { 99, 89, 79, 69, 77 };
		int[] tot = { 0, 0, 0, 0, 0 };
		double[] avg = new double[5];

		for (int i = 0; i < name.length; i++) {
			tot[i] = java[i] + db[i] + math[i];
			avg[i] = tot[i] / 3.0;
			//총점과 평균을 계산해 각각의 배열에 저장
		}

		System.out.println("Name\tJava\tDB\tMath\tTot\tAvg");
		System.out.println("==============================");

		for (int i = 0; i < 5; i++) {
			System.out.println(name[i] + "\t" + java[i] + "\t" + db[i] + "\t" 
					+ math[i] + "\t" + tot[i] + "\t" + String.format("%5.2f", avg[i]));
//			System.out.println(name[i] + "\t" + java[i] + "\t" + db[i] + "\t" 
//					+ math[i] + "\t" + tot[i] + "\t" + avg[i]);
	//escape character -> 제어기능	eg. \t \n \\ 등			
	//												형식지적 > %위치, 4.1f 전체4자리-소수이하1자리, f부동소수점
		}
	}
}
