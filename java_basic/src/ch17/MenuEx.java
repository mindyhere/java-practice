package ch17;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuEx extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuEx frame = new MenuEx();
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
	public MenuEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar); // 프레임에 메뉴바 붙이기

		JMenu mnNewMenu = new JMenu("파일");
//				변수명				텍스트
		menuBar.add(mnNewMenu); // 메뉴바에 메뉴를 추가

		JMenuItem mntmNewMenuItem = new JMenuItem("새파일");
		mnNewMenu.add(mntmNewMenuItem); // 메뉴에 메뉴아이템을 추가

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("열기");
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("저장");
		mnNewMenu.add(mntmNewMenuItem_6);

		JMenuItem miExit = new JMenuItem("종료");
//		메뉴아이템 	  변수명				      텍스트
		miExit.addActionListener(new ActionListener() {
//			메뉴아이템.액션이벤트감지(처리기)
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(MenuEx.this, "종료할까요?", "Exit", JOptionPane.YES_NO_OPTION);
//															출력화면			메세지   프레임제목  옵션형태
				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		mnNewMenu.add(miExit);

		JMenu mnNewMenu_1 = new JMenu("색상");
		menuBar.add(mnNewMenu_1);

		JMenuItem miRed = new JMenuItem("red");
		miRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(new Color(255, 0, 0));
//				   컨텐트영역		   배경색 설정			색상:   RGB코드
			}
		});
		mnNewMenu_1.add(miRed);

		JMenuItem miGreen = new JMenuItem("green");
		miGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.green);
			}
		});
		mnNewMenu_1.add(miGreen);

		JMenuItem miBlue = new JMenuItem("blue");
		miBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.blue);
			}
		});
		mnNewMenu_1.add(miBlue);

		JMenu mnNewMenu_2 = new JMenu("도움말");
		menuBar.add(mnNewMenu_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
