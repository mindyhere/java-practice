package ch13;

public class Type1 {
	int value;		//정수타입만 저장가능

	// ctrl+space > set
	public void setValue(int value) {
		this.value = value;
	}

	// ctrl+space > get
	public int getValue() {
		return value;
	}

	public static void main(String[] args) {
		Type1 t = new Type1();
		t.setValue(100);
//		 t.setValue(100.5);		
//		 t.setValue("Hello");
//		int value => 타입이 맞지 않아서 예외발생
		System.out.println(t.getValue());
	}
}
