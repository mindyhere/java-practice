package ch18;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FileRead extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileRead frame = new FileRead();
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
	public FileRead() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tf = new JTextField();
		tf.setBounds(12, 10, 248, 22);
		contentPane.add(tf);
		tf.setColumns(10);

		JButton button1 = new JButton("OK");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String file = tf.getText();
//				변수에 저장    <=  텍스트필드에 입력한 내용
				String str = "";
				BufferedReader reader = null; // 초기화작업

				try {
					reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//					FileInputStream(파일경로): 파일의 내용을 읽어오는 클래스
					ta.setText(""); // ta 의 내용을 지우고 공백("")으로 초기화
					while ((str = reader.readLine()) != null) {
//								  코드 1줄(Line)을 읽음 => null이 아니면
						ta.append(str + "\n"); // 기존 내용 끝에 내용추가 & 줄바꿈
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				} finally { // 예외발생 여부와 관계없이 항상 실행되는 구간
					try {
						if (reader != null)
							reader.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		button1.setBounds(272, 9, 97, 23);
		contentPane.add(button1);

		ta = new JTextArea();
		ta.setBounds(12, 42, 410, 209);
		contentPane.add(ta);
	}

}
