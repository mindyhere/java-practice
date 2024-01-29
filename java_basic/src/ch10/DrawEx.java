package ch10;

public class DrawEx {
	public static void main(String[] args) {
		Triangle t = new Triangle();
		t.draw();
		Rectangle r = new Rectangle();
		r.draw();
		Circle c = new Circle();
		c.draw();
		System.out.println();
		Figure f = new Triangle();
		f.draw();
		f = new Rectangle();
		f.draw();
		f = new Circle();
		f.draw();
	}
}
