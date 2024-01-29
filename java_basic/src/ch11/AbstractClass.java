package ch11;

//abstract: 추상(완성되지 않은) 클래스. 1개 이상의 추상메서드가 있는 경우.
public abstract class AbstractClass {
	abstract void method1(); // 완성되지 않은 함수. {}블럭 없음

	void method2() {
		System.out.println("완성되 코드");
	}
}
