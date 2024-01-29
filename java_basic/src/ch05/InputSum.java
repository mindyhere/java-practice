package ch05;

import java.util.Scanner;

public class InputSum {
	public static void main(String[] args) {
		int[] nums = new int[5];
		int sum = 0;

		Scanner sc = new Scanner(System.in);
//			warning  경고
		for (int i = 0; i < nums.length; i++) {
			System.out.print("Number " + (i + 1) + ":");
			nums[i] = sc.nextInt();
			sum = sum + nums[i];
		}
		System.out.println("Sum : " + sum);
//		sc.close();
	}
}
