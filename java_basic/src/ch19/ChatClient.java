package ch19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	public static void main(String[] args) throws Exception {
		Socket socket = null;
		PrintWriter writer = null;
		BufferedReader reader = null;

		try {
			socket = new Socket("localhost", 5555);
			writer = new PrintWriter(socket.getOutputStream(), true);
//			클라이언트 ==> 서버 스트림
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			서버 ==> 클라이언트 스트림
		} catch (Exception e) {
			e.printStackTrace();
		}
		String receive = "";
		String send;
		Scanner sc = new Scanner(System.in);
		while (true) {
			receive = reader.readLine(); // 서버에서 보낸 내용
			System.out.println("[server] " + receive);

			if (receive.equals("q"))
				break;
			System.out.println("input(quit:q): ");
			send = sc.nextLine();
			if (send.equals("q"))
				break;
			if (send != null) {
				writer.println(send); // 클라이언트 ==> 서버
			}
		}
//		리소스 정리
		sc.close();
		writer.close();
		reader.close();
		socket.close();
	}
}
