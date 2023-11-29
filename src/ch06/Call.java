package ch06;

public class Call {
	static void test1(int b) {
		//			argument 인자, 인수
		//			parameter 매개변수
		// void  리턴값이 없음을 표시
		System.out.println(b);
	}

	static void test2(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
//프로그램 시작점 -> main
	public static void main(String[] args) {
		int a = 10;
		test1(a); //4.1 값에 의한 호출
		int[] nums = { 10, 20, 30, 40, 50 };
		test2(nums); //4.2 주소값에 의한 호출
	}

}
