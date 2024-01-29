package jdbc;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Member extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUserid;
	private JPasswordField pass;
	private JTextField tfName;
	private JButton btnSave;
	private JButton btnCheck;

	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	private JLabel confirm;

	/**
	 * Launch the application.
	 * 
	 * @throws Exception
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Member frame = new Member();
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
	public Member() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfUserid = new JTextField();
		tfUserid.setBounds(83, 45, 116, 21);
		contentPane.add(tfUserid);
		tfUserid.setColumns(10);

		pass = new JPasswordField();
		pass.setBounds(83, 80, 116, 21);
		contentPane.add(pass);

		tfName = new JTextField();
		tfName.setBounds(83, 123, 116, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);

		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(12, 48, 57, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setBounds(12, 83, 57, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("이름");
		lblNewLabel_2.setBounds(12, 126, 57, 15);
		contentPane.add(lblNewLabel_2);

		String userid = tfUserid.getText();
		String passwd = String.valueOf(pass.getPassword());
		String name = tfName.getText();

		btnCheck = new JButton("중복확인");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String userid = tfUserid.getText();
					FileInputStream fis = new FileInputStream("C:/work/db.prop");
					Properties prop = new Properties();
					prop.load(fis);
					String driver = prop.getProperty("driver");
					String url = prop.getProperty("url");
					String id = prop.getProperty("id");
					String password = prop.getProperty("password");
					conn = DriverManager.getConnection(url, id, password);

					String sql = "select count(*) from member where userid=?";
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, userid);
					rs = stmt.executeQuery();

					if (userid.equals("")) {
						JOptionPane.showMessageDialog(null, "아이디를 입력하세요.");
						System.out.println("아이디 미입력");
						tfUserid.grabFocus();
					} else {
						if (rs.next()) {
							if (rs.getInt(1) > 0) {
								JOptionPane.showMessageDialog(null, "이미 사용 중인 아이디가 있습니다.");
								System.out.println("중복된 아이디 입력");
							} else {
								JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
								System.out.println("아이디 중복여부 확인완료");
								btnSave.setEnabled(true);
								pass.grabFocus();
							}
						}
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						if (stmt != null)
							stmt.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}

					try {
						if (conn != null)
							conn.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});

		btnCheck.setBounds(222, 44, 97, 23);
		contentPane.add(btnCheck);

		btnSave = new JButton("확인");
		btnSave.setEnabled(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("1111");
					String userid = tfUserid.getText();
					String passwd = String.valueOf(pass.getPassword());
					String name = tfName.getText();

					FileInputStream fis = new FileInputStream("C:/work/db.prop");
					Properties prop = new Properties();
					prop.load(fis);
					String driver = prop.getProperty("driver");
					String url = prop.getProperty("url");
					String id = prop.getProperty("id");
					String password = prop.getProperty("password");

					conn = DriverManager.getConnection(url, id, password);

					String sql = "INSERT INTO member (userid, passwd, name) VALUES (?,?,?)";
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, userid);
					stmt.setString(2, passwd);
					stmt.setString(3, name);
					System.out.println("2222");
					do {
						if (passwd.equals("")) {
							JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.");
							System.out.println("비밀번호 미입력");
							pass.grabFocus();
							
						} else
							continue;

						if (name.equals("")) {
							JOptionPane.showMessageDialog(null, "이름을 입력하세요.");
							System.out.println("이름 미입력");
							
							tfName.grabFocus();
							
						} else {
							continue;
						}
						System.out.println("3333");
						stmt.executeUpdate();
						confirm.setText(rs.getString("name") + " 님 환영합니다.");
						System.out.println("회원등록 성공");
						break;

					} while (passwd.equals("") || name.equals(""));
					System.out.println("4444");
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						if (stmt != null)
							stmt.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}

					try {
						if (conn != null)
							conn.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}

			}
		});
		btnSave.setBounds(222, 122, 97, 23);
		contentPane.add(btnSave);

		confirm = new JLabel("");
		confirm.setBounds(83, 177, 237, 59);
		contentPane.add(confirm);
	}
}
