package ch12;

public class ObjectCast {
	public static void main(String[] args) {
		int a = 10;
	// 정수형 a 에 대입
		Object obj = 20;
		a = (int) obj;
	// 하위 (int) 상위 -> cast 연산으로 obj를 int타입으로 축소함
		System.out.println(a);
		System.out.println();

		Object[] obj2 = { 100, 100.5, true, "hello", 'A' };
		// for (Object o : obj2) {
		// System.out.println(o);
		
		for (int i = 0; i < obj2.length; i++) {
			System.out.println(obj2[i]);
		}
	}
}
