package ch19;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressEx {
	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getByName("naver.com");
			System.out.println(address);
			InetAddress[] addresses = InetAddress.getAllByName("naver.com"); 	//모든 ip 주소
			for (InetAddress i : addresses) {
//					개별				배역
				System.out.println(i);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();	//스택 추적정보출력
//			stack: 밑에서 위로 쌓이는 메모리구조 ==> 함수호출
		}
	}
}
