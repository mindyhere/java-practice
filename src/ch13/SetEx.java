package ch13;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetEx {
	public static void main(String[] args) {
//		Set<String> hs = new HashSet<>();
//		Set: 순서없음, 중복값을 허용하지 않음
		Set<String> hs = new TreeSet<>(); // => 순서 (O)

		hs.add("Apple");
		hs.add("Peach");
		hs.add("Melon");
		hs.add("Grape");
		hs.add("Melon"); // => 중복값은 저장되지 않는다.
		System.out.println(hs); // => 입력 순서대로 저장되지 않는다.
		System.out.println();
		for (String str : hs) {
			System.out.println(str);
		}
		System.out.println();
		Iterator<String> it = hs.iterator();
//		반복처리기능
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
