package ch17;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class KeyMouseEx extends JFrame implements KeyListener, MouseListener, MouseMotionListener {
	private int x, y; // 좌표
	private int width, height; // 가로,세로 사이즈
	private Image img; // 이미지

//	생성자
	public KeyMouseEx() {
//	 대상	.리스터(처리기)
		addKeyListener(this); // (대상). 이 생략됨 => "프레임"에 키 이벤트 기능추가
		addMouseListener(this);
		addMouseMotionListener(this);

		img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("smile.png"));
//												   getClass() 현재 실행중인 클래스 
//															=> 같은 디렉토리에 있는 이미지(Resource)를 읽어옴(get)

		setFocusable(true);
		requestFocus();
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

//	그래픽 처리
	@Override
	public void paint(Graphics g) {
		super.paint(g);
//		이미지 가로&세로 사이즈
		width = img.getWidth(this);
		height = img.getHeight(this);
		g.drawImage(img, x, y, this);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		repaint(); // 그래픽을 새로그림(실행 명령어)
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			y = Math.max(50, y - 5);
			break;
		case KeyEvent.VK_DOWN:
			y = Math.min(480 - height, y + 5);
			break;
		case KeyEvent.VK_LEFT:
			x = Math.max(20, x - 5);
			break;
		case KeyEvent.VK_RIGHT:
			x = Math.min(480 - width, x + 5);
			break;
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public static void main(String[] args) {
		new KeyMouseEx();
	}

}
