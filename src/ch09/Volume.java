package ch09;

//class 하위클래스(:sub class) extends 상위클래스(:super class)
//상속을 통해 상위 클래스의 기존기능을 확장하여 활용할 수 있다.
public class Volume extends Area {
	private int height;

	public Volume() {
	}

	public Volume(int width, int length, int height) {
		super(width, length);
//super() => 상위클래스의 생성자
		this.height = height;
	}

	public int getVolume() {
		return getArea() * height;
	}
}
