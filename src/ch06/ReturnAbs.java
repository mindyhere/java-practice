package ch06;

public class ReturnAbs {
	static int abs(int num) {
		return num > 0 ? num : -num;
//		
//	삼항연산자 		조건  ? 	   참 : 거짓;
//y=f(x) -> 출력= 절대값게산(입력)
	}

	public static void main(String[] args) {
		int a = -15;
		System.out.println(a);
		System.out.println(abs(a));
		System.out.println(Math.abs(a)); //Math 클래스 내 abs매서드(절댓값 계산하는 함수)
	}
}
