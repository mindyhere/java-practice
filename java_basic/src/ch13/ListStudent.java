package ch13;

import java.util.ArrayList;
import java.util.List;

public class ListStudent {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
//		상위						하위 => F4, 계층 구조도 확인가능
		list.add(new Student("Kim", "Design", 1));
//		new Student => 인스턴스 생성
//		Student(name, major, year) => 생성자 호출
//		list.add() => 추가
		
		list.add(new Student("Park", "DB", 2));
		list.add(new Student("Song", "Math", 3));
		System.out.println("Name\tMajor\tYear");

//		for each문
//			   개별값	   : 리스트
		for (Student s : list) {
			System.out.println(s.getName() + "\t" + s.getMajor() + "\t" + s.getYear());
		}
		
		System.out.println();
		for (int i=0; i<list.size(); i++) {
			Student s = list.get(i);
			System.out.println(s.getName() + "\t" + s.getMajor() + "\t" + s.getYear());
		}

	}
}
