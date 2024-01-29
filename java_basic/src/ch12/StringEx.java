package ch12;

public class StringEx {
	public static void main(String[] args) {
		String str = "Hello Java";
		System.out.println(str);
		System.out.println(str.toUpperCase() + " : 대문자 변환");
		System.out.println(str.toLowerCase() + " : 소문자 변환");
		System.out.println(str);
		str = str.toLowerCase();
		System.out.println(str);

		str = "";	//빈 문자열을 저장
		System.out.println(str); 
		str = null;		//가리키는 내용 없음
		System.out.println(str);

		char ch = '\0'; 	//null character
		System.out.println(ch + ", code : " + (int) ch);
		ch = ' '; 	//Space 문자
		System.out.println(ch + ", code : " + (int) ch);
	}
}
