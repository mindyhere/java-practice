package ch05;

public class IntArray {
public static void main(String[] args) {
		int[] nums = { 10, 20, 30, 40, 50 ,60, 70, 80 };

//		int[] nums;
//    정수배열   배열참조변수
//		nums = new int[5];
//  배열참조변수   생성 
//		nums[0]=10;
//		nums[1]=20;
//		nums[2]=30;
//		nums[3]=40;
//		nums[4]=50;
		
		for (int i=0; i<nums.length ;i++) {
//					배열참조변수.length -> 데이터 수	
			System.out.println(nums[i]);
		}
		
		System.out.println();
		for (int n:nums) {
//       세부적인 값 : 배열
			System.out.println(n);
		}
}
}
