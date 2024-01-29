package ch12;

public class ObjectEx {
	public static void main(String[] args) {
		Object obj = 20;
	//  	참조변수  value <=> Object obj = new Integer(20);
		System.out.println(obj);
		
		obj = 20.5;
		System.out.println(obj);
		
		obj = "hello";
		System.out.println(obj);
	}
}
