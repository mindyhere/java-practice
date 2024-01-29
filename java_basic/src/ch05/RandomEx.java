package ch05;

import java.util.Random;

public class RandomEx {
	public static void main(String[] args) {
		Random rand = new Random(); //난수발생기
	//	특정 시간을 기준으로 규칙적인 수열 생성
	//	random seed(씨, 기준값) - 재현성
		int[] nums = new int[6];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = rand.nextInt(100) + 1;
			//				0~99	-> 1~100 사이의 값
			System.out.println(nums[i]);
		}
	}
}
