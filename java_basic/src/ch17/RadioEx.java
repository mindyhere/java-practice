package ch17;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class RadioEx extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioEx frame = new RadioEx(); // 프레임생성, 생성자호출
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RadioEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JRadioButton rdoRed = new JRadioButton("Red");
//		라디오버튼		 변수명	  생성				텍스트
		rdoRed.addItemListener(new ItemListener() {
//		라디오버튼.add아이템Listener(처리기)	
			public void itemStateChanged(ItemEvent e) {
//						아이템 상태가 바뀌면
				contentPane.setBackground(Color.RED);
//				프레임의 내용영역 	배경색	   색상 지정
			}
		});
		buttonGroup.add(rdoRed); // 버튼그룹에 라디오버튼을 추가
		contentPane.add(rdoRed); // 패널에 라디오버튼을 추가

		JRadioButton rdoGreen = new JRadioButton("Green");
		rdoGreen.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				contentPane.setBackground(Color.green);
			}
		});
		buttonGroup.add(rdoGreen);
		contentPane.add(rdoGreen);

		JRadioButton rdoBlue = new JRadioButton("Blue");
		rdoBlue.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				contentPane.setBackground(Color.blue);
			}
		});
		buttonGroup.add(rdoBlue);
		contentPane.add(rdoBlue);
	}

}
