package ch17;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyColorAction implements ActionListener {
	private JFrame f;
	private Color c;
	private Container con;

//	    생성자				프레임	컬러
	public MyColorAction(JFrame f, Color c) {
		this.f = f;
		con = f.getContentPane(); // 프레임의 내용부분(헤더부분 X)
		this.c = c;
	}

//	버튼을 클릭했을 때 실행되는 명령어구간(메서드)
	@Override
	public void actionPerformed(ActionEvent e) {
		con.setBackground(c); // 배경색상 변경
	}

}

public class EventEx3 extends JFrame {
	private JButton button1, button2, button3; // 필드변수(멤버변수)

	public EventEx3() {
		setLayout(new FlowLayout()); // 기본 레이아웃변경
//		버튼생성
		button1 = new JButton("Red");
		button2 = new JButton("Green");
		button3 = new JButton("Blue");
//		프레임에 추가(버튼)
		add(button1);
		add(button2);
		add(button3);

//			대상.리스너(처리);
//		액션이벤트 => 버튼클릭
		button1.addActionListener(new MyColorAction(this, Color.red));
		button2.addActionListener(new MyColorAction(this, Color.green));
		button3.addActionListener(new MyColorAction(this, Color.blue));
		setSize(450, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new EventEx3();
	}

}
