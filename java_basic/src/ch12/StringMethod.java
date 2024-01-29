package ch12;

public class StringMethod {
	public static void main(String[] args) {
		String str = "java";
		str += "programming";
		System.out.println(str.length());
		System.out.println(str.charAt(2));
		System.out.println(str.indexOf("program"));
		System.out.println(str.indexOf("z"));
		System.out.println(str.substring(0, 4));
	//								(strat , stop)	
		System.out.println(str.substring(5));
	//									(목수)	
		System.out.println(str.replace("java", "jsp"));
		System.out.println(str);
		str = str.replace("java", "jsp");
		System.out.println(str);
	}
}
