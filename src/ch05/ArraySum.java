package ch05;

public class ArraySum {
	public static void main(String[] args) {
		int[] nums = { 10, 20, 30, 40, 50 };
					//	0	1	2	3	4
//		[] -> 배열첨자. nums[3] -> 배열참조변수[인덱스]
//								인덱스 ; offset의 개념으로 기준점 0에서 시작
		System.out.println(nums); //->해시코드(주소값)가 출력된다
		System.out.println(nums[0]);
		System.out.println(nums[1]);
		System.out.println(nums[2]);
		System.out.println(nums[3]);
		System.out.println(nums[4]);
//		System.out.println(nums[5]); -> 배열에 없는 인덱스.예외발생
		
		nums[2] = 300; //배열의 세번째
		System.out.println("nums[2]의 값 변경 -> " +nums[2]);
		
		int sum = 0;
		
//		자료형 변수명
		for (int i = 0; i < nums.length; i++) {
//						배열참조변수.length -> 데이터의 개수
			sum += nums[i];
		}
		System.out.println(sum);
	}
}
