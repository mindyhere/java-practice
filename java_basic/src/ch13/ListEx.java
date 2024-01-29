package ch13;

import java.util.ArrayList;
import java.util.List;
//java.lang 패키지 제외 나머지 => import
//ctrl + shift + O => 자동 import문 추가

public class ListEx {
	public static void main(String[] args) {
		List<Object> list = new ArrayList<>();
//		상위. parent. super				<Object> 생략 가능
//		list 인터페이스 
//		Array 클래스, list 를 구현
//		인터페이스 extends 인터페이스
//		클래스 implements 인터페이스
		list.add("one");
		list.add(2);
		list.add(5.5);
		list.add(false);
		list.add(3, 4);		//index 3, value 4 를 저장(끼워넣기)
//		=> {"one", 2, 5.5, 4, false }
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i) + "\t");
		}
		
		System.out.println();
		list.remove(0);		//index 0 을 제거(remove) => "one" 이 제거됨
			for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i) + "\t");
		}

	}
}
