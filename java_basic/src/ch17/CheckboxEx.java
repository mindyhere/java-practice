package ch17;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckboxEx extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea ta; // Convert local to field => 멤버변수로 변경(필드변수, 전역변수)
// 	JTextArea 여러줄  <=>  JTextField 한줄

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckboxEx frame = new CheckboxEx();
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
//	생성자() {}
	public CheckboxEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
//		메인패널		추가	 패널				위치 => 체크박스 3개를 저장

		JCheckBox chJava = new JCheckBox("자바");
//		아이템 상태가 바뀌면: ItemEvent e ==> 체크박스를 누르면 e에 text를 저장
		chJava.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) { // 아이템 이벤트 선택 상태
					ta.append("Java를 신청했습니다.\n"); // "\n" 줄바꿈 기능
				} else if (e.getStateChange() == ItemEvent.DESELECTED) { // 아이템 이벤트 해제 상태
					ta.append("Java를 취소했습니다.\n");
//					ta.setText("Java를 취소했습니다.\n"); => 기존 내용을 지우고 텍스트가 변경된다.
//				텍스트영역.setText(내용 교체/변경)
//				텍스트영역.append(내용 추가)
//				텍스트영역.getText => 내용을 읽어옴
				}
			}
		});
		panel.add(chJava);

		JCheckBox chPython = new JCheckBox("파이썬");
		chPython.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ta.append("파이썬을 신청했습니다.\n");
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					ta.append("파이썬을 취소했습니다.\n");
				}
			}
		});
		panel.add(chPython);

		JCheckBox chLinux = new JCheckBox("리눅스");
		chLinux.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ta.append("리눅스를 신청했습니다.\n");
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					ta.append("리눅스를 취소했습니다.\n");
				}
			}
		});
		panel.add(chLinux);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		ta = new JTextArea();
		scrollPane.setViewportView(ta);

		JButton btnExit = new JButton("종료");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnExit, BorderLayout.SOUTH);
//		패널			추가	 버튼					위치
	}

}
