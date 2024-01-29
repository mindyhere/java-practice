package ch17;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderEx extends JFrame {
//					  상속: Java는 다중상속 X => 다중상속이 필요할 경우, 인터페이스 활용
	public BorderEx() {
		JButton button1 = new JButton("Button 1");
		JButton button2 = new JButton("Button 2");
		JButton button3 = new JButton("Button 3");
		JButton button4 = new JButton("Button 4");
		JButton button5 = new JButton("Button 5");
		JButton button6 = new JButton("Button 6");
		add(button1); // 프레임에 추가(버튼). 기본적으로 Center에 배치
// BorderLayout => 동서남북+센터 5개의 영역 vs.FlowLayout 순서대로 베치
//		add(컴포넌트, 위치)
		add(button2, "North");
// 					위치 => 소문자일 때 예외발생(IllegalArgumentException)
		add(button3, "South");
		add(button4, "East");

		JPanel p = new JPanel();
		p.add(button5);
		p.add(button6);
		add(p, "West");
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new BorderEx();
	}
}
