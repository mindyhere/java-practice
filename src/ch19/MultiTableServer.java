package ch19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class MultiTableServer implements Runnable {
//	Runnable: 호출 ==> Thread: 실제기능
	private ServerSocket serverSocket; // 서비스제공용 소켓
	private Socket socket; // 데이터통신용 소켓
	private DataInputStream dis;
	private DataOutputStream dos;

	public MultiTableServer() { // 생성자
//			네트워크작업 => 예외처리 필수
		try {
			serverSocket = new ServerSocket(9999); // 서버소켓 => 서비스제공
//											포트번호
			System.out.println("Started...");
		} catch (Exception e) {
			e.printStackTrace();
		}

		while (true) {
			try {
				socket = serverSocket.accept(); // 클라이언트의 접속을 허가
				InetAddress ip = socket.getInetAddress();
//				클라이언트의 ip주소
				System.out.println("Client's ip: " + ip);
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				Thread th = new Thread(this); // 백그라운드 스레드
				th.start(); // 스레드 실행
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new MultiTableServer();
	}

	@Override
	public void run() {
		try {
			while (true) {
				int table = dis.readInt(); // 클라이언트의 입력값, 정수
				System.out.println("dan: " + table);
				StringBuilder sb = new StringBuilder();
				for (int i = 1; i <= 9; i++) {
					sb.append(table + " X " + i + " = " + table * i + "\r\n");
				}
				dos.writeUTF(sb.toString()); // 클라이언트에게 결과값을 전송
			}
		} catch (SocketException e) {
			System.out.println("클라이언트의 연결이 끊어졌습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
