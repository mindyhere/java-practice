package ch17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ClockExam extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private Calendar cal;
	private String str;
	private JLabel lblTime;// "convert local to field" => 지역변수에 선언되어 있던 것을 필드변수로 이동

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { // 내부클래스
//		그래픽처리를 위한 백그라운드 스레드를 추가
			public void run() {
				try {
					ClockExam frame = new ClockExam(); // 인스턴스 생성
					frame.setVisible(true);
				} catch (Exception e) { // 예외처리
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClockExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
//		setBounds() => 범위지정

//	컴포넌트(화면 구성요소) => button, lable
//	컨테이너(컴포넌트를 담는 틀, 컴포넌트의 일종)  => panel, frame 등
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // 테두리 설정
		contentPane.setLayout(new BorderLayout(0, 0)); // 레이아웃 설정
		setContentPane(contentPane);

		lblTime = new JLabel("New label");
//		레이블 생성					텍스트
		lblTime.setForeground(new Color(255, 102, 255));
//		foreground 전경색					R  G   B
		lblTime.setFont(new Font("궁서", Font.ITALIC, 30));
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
//					가로정렬방식					가운데정렬
		contentPane.add(lblTime, BorderLayout.CENTER);
//		컨텐트팬에 추가   레이블(컴포넌트)   가운데 <=> 대상.add(컴포넌트, 위치)
		Thread t = new Thread(this); // 시간처리를 위한 스레드 생성
		t.start(); // => run() 실행

		JButton btnExit = new JButton("Exit");
//		 	버튼 생성					   텍스트
		btnExit.addActionListener(new ActionListener() {
//		이벤트소스.리스너(핸들러) <=> 버튼.액션리스너(동작)
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // 프로그램 종료 명령어
			}
		});

		contentPane.add(btnExit, BorderLayout.SOUTH);
//		컨텐트팬에 추가(add)	  버튼			위치
	}

	@Override
	public void run() {
		while (true) { // 무한반복
			cal = Calendar.getInstance(); // 캘린더 인스턴스를 생성
			str = String.format("%4d-%02d-%02d %02d:%02d:%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1,
					cal.get(Calendar.DATE), cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),
					cal.get(Calendar.SECOND));
//			String.format("형식", 값...)
			lblTime.setText(str);
//			레이블.setText(값)

			try {
				Thread.sleep(1000); // cpu 실행을 일정시간 동안 강제로 멈추는 기능(1000 밀리세컨드=1초)
			} catch (InterruptedException e) {
//						cpu 간섭
				e.printStackTrace();
			}
		}
	}

}
