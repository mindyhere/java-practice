package ch02;

public class Compare {
	public static void main(String[] args) {
		int a = 65;
		char c = 'a';
		char c2 = 'A';
		System.out.println(a == c); // 비교
		System.out.println(a = c); // 대입 (a는 숫자로 97)
		System.out.println(a = c2); // "=" 등호:대입을 의미. 따라서 대문자 A의 숫자코드 65로 반환
	}

}
//주석 단축키 ctrl+/