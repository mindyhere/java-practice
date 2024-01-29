package jdbc;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginEx extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userid;
	private JPasswordField pwd;
	private JLabel lblResult; // convert local to field

	/**
	 * Launch the application.
	 */
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
	public LoginEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(45, 51, 57, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setBounds(45, 97, 57, 15);
		contentPane.add(lblNewLabel_1);

		lblResult = new JLabel("");
		lblResult.setBounds(45, 145, 313, 64);
		contentPane.add(lblResult);

		userid = new JTextField();
		userid.setBounds(114, 48, 116, 21);
		contentPane.add(userid);
		userid.setColumns(10);

		pwd = new JPasswordField();
		pwd.setBounds(114, 94, 116, 21);
		contentPane.add(pwd);

		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strUserid = userid.getText();
				String strPwd = String.valueOf(pwd.getPassword());

				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try {
//					c://db.prop 파일 => fis로 읽어와서 DB접속
					FileInputStream fis = new FileInputStream("c://work/db.prop");
					Properties prop = new Properties();
					prop.load(fis);
//					프로퍼티기능.불러오기(파일내용) → key & value 구조
					String url = prop.getProperty("url");
					String id = prop.getProperty("id");
					String password = prop.getProperty("password");
					conn = DriverManager.getConnection(url, id, password);

					String sql = "select * from member where userid = ? and pwd = ?"; // 완성되지 않은 SQL명령어
//																	strUserid	strPwd
					pstmt = conn.prepareStatement(sql); // SQL실행객체
					pstmt.setString(1, strUserid);
					pstmt.setString(2, strPwd);
					rs = pstmt.executeQuery(); // 완성된 명령어 실행

					if (rs.next()) {
						lblResult.setText(rs.getString("name") + " 님 환영합니다.");
					} else {
						lblResult.setText("아이디 또는 비밀번호가 일치하지 않습니다.");
					}

				} catch (Exception e2) {
					e2.printStackTrace();
					
				} finally {
					try {
						if (rs != null) {
							rs.close();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					try {
						if (pstmt != null) {
							pstmt.close();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					try {
						if (conn != null) {
							conn.close();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnLogin.setBounds(261, 93, 97, 23);
		contentPane.add(btnLogin);
	}
}
