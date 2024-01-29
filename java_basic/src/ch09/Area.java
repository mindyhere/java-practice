package ch09;

public class Area {
	private int width;
	private int length;

	public Area() {
	}

	public Area(int width, int length) {
//		super();	//상위 클래스를 의미
		this.width = width;
		this.length = length;
	}

	public int getArea() {
		return width * length;
	}

}
