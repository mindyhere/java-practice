package ch13;

public class Type2 {
	Object value;

//  모든 자료형을 다 처리할 수 있지만 비용이 비싸다(비효율적일 수 있음)
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public static void main(String[] args) {
		Type2 t = new Type2();
		t.setValue("kim");
		System.out.println(t.getValue());
		t.setValue(100.5);
		System.out.println(t.getValue());

	}
}
