package ch15;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;

class MyFrame extends JFrame implements Runnable {
//				상속				구현		멀티스레드
// 스레드의 구현: Runnable 인터페이스의 run() 을 구현 => start() 호출에 의해 스레드 실행
// JFrame: Swing클래스(자바에서 그래픽 사용자 인터페이스를 구현하기 위하여 제공되는 클래스)에서 구현되는 창(윈도우창)
	private int x, y = 50;
	private int moveX = 2, moveY = 3; // 좌표값 설정
	private Graphics bg; // 그래픽처리
	private Image offScreen;
	private Dimension dim; // 화면의 가로, 세로 사이즈 지정
// 	property변수, 필드변수, 전역변수, 멤버변수

//생성자 호출
	public MyFrame() {
		setSize(500, 500); // 화면사이즈 설정
		setResizable(false);
		setVisible(true); // 화면에 표시
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 창닫기 => 프로그램 종료로 기본설정

		dim = getSize(); // 화면 사이즈 계산(가로, 세로)
		offScreen = createImage(dim.width, dim.height);
//						이미지 생성(가로, 세로)
		bg = offScreen.getGraphics(); // 그래픽처리 객체생성
		Thread t = new Thread(this);
//		멀티스레드 생성 => main 기본스레드, this 현재
		t.start();
//		스레드의 실행
	}

	public void update(Graphics g) { // 화면출력 준비
		bg.setColor(Color.yellow);
		bg.fillRect(0, 0, getWidth(), getHeight());
//		배경화면의 색깔, 형태, 사이즈(기준좌표, 가로길이, 세로길이)
		bg.setColor(Color.green);
		bg.fillOval(x, y, 30, 30);
//		원의 색깔, 형태, 사이즈
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(offScreen, 0, 0, this);
//		이미지 화면 출력	  이미지	 기준좌표 이미지관찰자
		update(g); // 출력준비
	}

	public void run() {
		while (true) {
//			무한반복 => 좌표 재설정(화면 내 영역을 벗어나지 않도록 범위 조정)
			if (x > (dim.width - 30) || x < 0) {
				moveX = -moveX;
			}
			x = x + moveX;
			if (y > (dim.height - 30) || y < 30) {
				moveY = -moveY;
			}
			y = y + moveY;
//			System.out.println("(x, y) = " + x + ", " + y);
			repaint(); // 그래픽을 새로 그림
			try {
				Thread.sleep(10); // 움직이는 속도(시간) 조정
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Ball {
	public static void main(String[] args) {
		new MyFrame();
//		인스턴스 생성 & 생성자 호출
	}
}
