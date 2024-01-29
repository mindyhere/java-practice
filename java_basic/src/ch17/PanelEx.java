package ch17;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelEx extends JFrame {
	public PanelEx() { // 생성자
		JPanel p = new JPanel();
//		컵포넌트: 화면구성 도구(버튼, 체크박스 등)
//		컨테이너: 컴포넌트를 담을 수 있는 그릇

		p.setBackground(Color.yellow); // 배경색상을 설정
		JButton button1 = new JButton("Button 1");
//		버튼 객체 선언 & 생성
		JButton button2 = new JButton("Button 2");
		JButton button3 = new JButton("Button 3");

		p.add(button1);
//		패널.추가(버튼)
		p.add(button2);
		p.add(button3);

		add(p); // => 프레임에 추가(패널)
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//					닫기동작
	}

	public static void main(String[] args) {
		new PanelEx();
//		new 인스턴스생성
	}

}
