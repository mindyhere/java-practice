package ch17;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginEx extends JFrame {

	private JPanel contentPane;
	private JTextField userid;
	private JPasswordField pwd;
	private JLabel lblResult;
	Map<String, String> map;
//	< >: generic 일반화
//	해시맵 Map<String, Object> map = new HashMap<>();
//			key자료형, value자료형

	/**
	 * Launch the application.
	 */

//	기본스레드: main메서드
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginEx frame = new LoginEx();
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
	public LoginEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300); // => 프레임의 좌표&사이즈 설정
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
//					기본 레이아웃 사용X => 절대좌표 사용(원하는 위치 설정이 가능하다)

		userid = new JTextField();
		userid.setBounds(210, 75, 116, 21);
//		텍스트필드			  x   y   가로  세로 => 위치&사이즈 지정
		contentPane.add(userid);
		userid.setColumns(10);

		pwd = new JPasswordField();
		pwd.setBounds(210, 113, 116, 21);
		contentPane.add(pwd);

		map = new HashMap<String, String>();
		map.put("kim", "1234");
		map.put("park", "2222");
		map.put("hong", "3333");

		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = userid.getText();
//				id에 저장	 <=	텍스트필드.getText() 입력한 값
				String pw = String.valueOf(pwd.getPassword());

				if (map.get(id) == null) {
					lblResult.setForeground(Color.red);
					lblResult.setText("ID is incorredt.");

				} else {
					if (map.get(id).equals(pw)) {
//						A.equals(b) => A와 B의 내용을 비교
//					     A == B     => A와 B의 주소를 비교
						lblResult.setForeground(Color.blue);
						lblResult.setText("Welcome " + id);
					} else {
						lblResult.setForeground(Color.red);
						lblResult.setText("ID or Password is incorrect.");
					}
				}
			}
		});

		btnLogin.setBounds(210, 144, 116, 23);
		contentPane.add(btnLogin);

		lblResult = new JLabel("");
		lblResult.setBounds(82, 200, 246, 15);
		contentPane.add(lblResult);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(82, 78, 82, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(82, 116, 82, 15);
		contentPane.add(lblNewLabel_1);
//		패널		   .설정	레이아웃: 기본 floewLayout
	}
}
