package ch17;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowEx extends JFrame {
	public FlowEx() {
		setLayout(new FlowLayout());
//		JFrame: (기본) BorderLayout => FlowLayout
//		setLayout: 레이아웃 변경
		JButton button1 = new JButton("Button 1");
		JButton button2 = new JButton("Button 2");
		JButton button3 = new JButton("Button 3");
		add(button1); // 프레임에 추가(버튼)
		add(button2);
		add(button3);
		setSize(400, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new FlowEx();
//		객체(인스턴스) 생성 & 생성자 호출(call)
	}
}
