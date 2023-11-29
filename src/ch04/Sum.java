package ch04;

public class Sum {
	public static void main(String[] args) {
		int num = 5;
		int sum = 0;

		for (int i = 1; i <= num; i++) {
	//			1.초기식	 2.조건식  4.증감식
			sum = sum +i; 	//3. sum += i
		}
		System.out.println(sum);
	}
}
