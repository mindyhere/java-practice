package ch13;

public class Type3<T> {
// 	클래스이름<자료형 미정> => 클래스/메소드에서 사용할 내부 데이터 타입을 컴파일 시에 미리 지정
	
	T t;

	public void setT(T t) {
		this.t = t;
	}

	public T getT() {
		return t;
	}

	public static void main(String[] args) {
		Type3<String> t = new Type3<String>();
//			<자료형 지정: String>
		t.setT("100");
		System.out.println(t.getT());
		
		Type3<Integer> t2 = new Type3<Integer>();
//		<자료형 지정: integer>
		t2.setT(100);
		System.out.println(t2.getT());
	}
}
