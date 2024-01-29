package ch17;

import javax.swing.JFrame;

//java.lang 패키지(기본) 제외 나머지 => import문을 추가해야 한다.

public class JFrameExam {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		  설정  기본     닫기동작				프로그램 종료
	}
}
