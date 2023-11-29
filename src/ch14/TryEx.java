package ch14;

public class TryEx {
	public static void main(String[] args) {
		int[] nums = { 10, 20, 30, 40, 50 };
//		      인덱스      0	1	2	3	4
//		System.out.println(nums[5]); // => ArrayIndexOutOfBoundsException
//		Index 5 out of bounds for length 5 at ch14.TryEx.main

		/*
		   for (int i = 0; i <= nums.length; i++) { System.out.println(nums[i]); }
		   System.out.println("종료"); nums.length=5 => 예외발생으로 비정상 종료됨
		 */

		try {
			for (int i = 0; i <= nums.length; i++) {
				System.out.println(nums[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally");
		}
		System.out.println("종료");
//		catch {} 블록에 의해 예외처리 후 정상종료=> "종료" 문장까지 출력
	}
}
