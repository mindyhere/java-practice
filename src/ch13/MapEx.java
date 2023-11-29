package ch13;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapEx {
//	List 순서대로, 인덱스 0 부터 저장
//	Map(key, value) 데이터를 key-value의 구조로 저장. 순서X, 자료를 조회할 때 빠르게 처리가능
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		
/*		HashMap
 		Map<Stirng, Objext> map=new HashMap<>();
		map.put(key, value) => 입력
		map.get(key) => 출력 
		*/

		map.put("apple", "사과");
//	자료	저장/추가	  key	 value
		System.out.println(map.get("apple"));
//							자료 조회  key
		System.out.println();
		map.put("grape", "포도");
		map.put("peach", "복숭아");
		System.out.println(map);
		System.out.println(map.keySet()); // key의 집합
		System.out.println(map.values()); // value의 집합
		System.out.println();

		String input = "grape";
		System.out.println(input + "==>" + map.get(input));
		System.out.println();
		Iterator<String> iterator = map.keySet().iterator(); // key 집합, 반복처리 기능
		while (iterator.hasNext()) {
//			다음 자료가 있으면 true, 없으면 false
			String key = iterator.next();
			System.out.print("key = " + key);
			System.out.println(", value = " + map.get(key));
		}
	}

}
