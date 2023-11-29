package ch19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = null; // 서비스 제공 소켓
		try {
			serverSocket = new ServerSocket(5555);
			System.out.println("Started...");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error...");
			System.exit(1);
		}

		Socket clientSocket = null;
		try {
			clientSocket = serverSocket.accept();
//						   대기중, 사용자 접속, 허가, 통신회선 연결
			System.out.println("client's ip: " + clientSocket.getInetAddress().getHostAddress());
		} catch (Exception e) {
			e.printStackTrace();
		}

		PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
//					서버 ==> 클라이언트 출력용 
		BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//						클라이언트 ==> 서버 입력용
		String receive = "";
		String send = "Welcome!";
		writer.println(send);
		Scanner sc = new Scanner(System.in);

		while (true) {
			receive = reader.readLine();
			if (receive == null || receive.equals("q")) {
				break;
			}

			System.out.println("[client]" + receive);
			System.out.println("input(quit:q): ");
			send = sc.nextLine(); // 서버 ==> 클라이언트로 보낼 메세지
			writer.println(send); // 전송

			if (send.equals("q")) {
				break;
			}
		}
		sc.close(); // 스캐너 닫기
		writer.close(); // 스트림 종료
		reader.close();
		clientSocket.close(); // 소켓 닫기
		serverSocket.close();
	}
}