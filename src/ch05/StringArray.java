package ch05;

//package 디렉토리
//class 파일
//클래스이름.java

public class StringArray {
//공개
//private 비공개 ; protected ; default 같은 패키지 내
// 함수 실행 -> 함수(입력값) 리턴
	public static void main(String[] args) {
		String[] str = { "Java", "JSP", "DB", "Python" };
		for (int i = 0; i < str.length; i++) {
			System.out.println("str["+i+"] = "+str[i] );
		}
	}
}
