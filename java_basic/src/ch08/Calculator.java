package ch08;

public class Calculator {
	private int left;
	private int right;
	
	public Calculator() {
		System.out.println("생성자를 호출하였습니다.");
//		left = 5;
//		right = 10;
	}
//생성자 Constructor: 클래스 이름과 같은 메서드, 리턴타입이 없다. 객체의 초기화 작업(기본작업)을 처리
//new 클래스이름 => object 생성
//new 클래스이름() => 생성자 호출. 초기값을 저장하지 않으면 자료형의 기본값으로 초기화

	public Calculator(int left, int right) {
					//local 지역변수
		this.left = left;
//	this. => 현재 객체의 주소값. 멤버변수. 인스턴스변수
		this.right = right;
	}

	public int getLeft() {
		return left;
	}
//getter 변수 값을 읽는 메서드
	public void setLeft(int left) {
		this.left = left;
	}
//setter 변수 값을 쓰는 메서드
	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public void sum() {
		System.out.println(left + right);
	}

	public void avg() {
		System.out.println((left + right) / 2);
	}

}
