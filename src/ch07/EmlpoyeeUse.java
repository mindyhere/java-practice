package ch07;

public class EmlpoyeeUse {
	public static void main(String[] args) { //지역변수(로컬)
		Employee e1 = new Employee();
//		e1.input("Kim", 300);
		e1.name = "kim";
		e1.basic = 300;
		e1.calc();
		e1.print();
	}
}
