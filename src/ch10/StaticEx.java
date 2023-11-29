package ch10;

public class StaticEx {
	public static void main(String[] args) {
		int a = 40, b = 30, result;
		result = Math.max(a, b); //최댓값
		System.out.println(result);
		result = Math.min(a, b); //최솟값
		System.out.println(result);
		System.out.println(Math.sqrt(100)); //제곱근

		double r = 15.3;
		System.out.println("원의 둘레 Circumference : " + 2 * Math.PI * r);
		System.out.println("원의 면적 Area : " + Math.PI * r * r);
	}
}
