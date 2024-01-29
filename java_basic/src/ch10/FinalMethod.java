package ch10;

class T {
	private int num = 10;
//final 변수 => 값을 바꿀 수 없음
//final class => 상속 금지
	public final void print() {
		System.out.println(num);
	}
}

public class FinalMethod extends T {
	int num = 100;

// @Override => 함수 재정의
//public void print() {
//	super.print();
//}
	
	public static void main(String[] args) {
		FinalMethod f = new FinalMethod();
		f.print();
	}
}
