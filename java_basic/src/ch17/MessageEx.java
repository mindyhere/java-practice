package ch17;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MessageEx extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessageEx frame = new MessageEx();
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
//	생성자() {} => 클래스 초기작업 처리
	public MessageEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//					닫기 동작				프로그램 종료
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
//		컨테이너:다른 컴포넌트를 담을 수 있는 컴포넌트의 일종
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton button3 = new JButton("Input");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(MessageEx.this, "Input name");
//				showInputDialog(출력화면, 메시지 ) => 대화상자
				JOptionPane.showMessageDialog(MessageEx.this, "Welcome " + name);
			}
		});
		contentPane.add(button3);

		JButton button4 = new JButton("Option");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 사용자 정의 버튼 [0]Yes [1]No [2]Cancel
				String[] str = { "ADD", "UPDATE", "DELETE" };
				JOptionPane.showOptionDialog(MessageEx.this, "SELECT MENU", "OPTION", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null, str, str[0]);
//						 			아이콘 이미지 			기본선택값
			}
		});
		contentPane.add(button4);

		JButton button2 = new JButton("Confirm");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(MessageEx.this, "Do you want to exit?", "EXIT",
						JOptionPane.YES_OPTION);
//		showConfirmDialog(출력화면, 메세지, 타이틀, 옵션)	
				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		contentPane.add(button2);

		JButton button1 = new JButton("Message");
//		버튼.리스너(동작)  =>  addActionListener : 버튼 클릭(동작)을 감지
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MessageEx.this, "Message");
			}
		});
		contentPane.add(button1);
	}

}
