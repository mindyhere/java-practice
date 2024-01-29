package ch17;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class ProgressEx extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JProgressBar progress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgressEx frame = new ProgressEx();
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
	public ProgressEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		progress = new JProgressBar();
		progress.setStringPainted(true);
		contentPane.add(progress);

		JButton btnStart = new JButton("시작");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//							스레드 객체
				Thread th = new Thread(new Runnable() {
					@Override
					public void run() {
						for (int i = 1; i <= 100; i++) {
							progress.setValue(i);
//							프로그레스바.setValue(값)
							try {
								Thread.sleep(10);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						}
						JOptionPane.showMessageDialog(ProgressEx.this, "완료되었습니다.");
//									보여주기 메세지 대화상자( 화면 컴포넌트, 메세지 )
//						JOptionPane.showMessageDialog(this, "완료되었습니다."); => this는 내부클래스 자신을 가리키기 때문에 에러발생
					}
				});
				th.start(); // run() 실행
			}
		});
		contentPane.add(btnStart);
	}

}
