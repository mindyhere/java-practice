package ch09;

public class SalseUse {
	public static void main(String[] args) {
		Sale s1 = new Sale();
		s1.input(1, "Tv", 100, 10);
		s1.calc();
		s1.print();
	}
}
