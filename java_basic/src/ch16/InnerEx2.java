package ch16;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InnerEx2 extends Frame {
//					  확장,상속  상위
	public InnerEx2() { // 생성자
		setSize(300, 400); // 화면사이즈 설정(300*400)
		setVisible(true); // 화면에 표시
	}

	public static void main(String[] args) {
		InnerEx2 e = new InnerEx2();
//		인스턴스 생성	 생성자 호출
//		addWindowListener => 윈도우 관련 기능을 추가하는 메서드
		e.addWindowListener(new WindowAdapter() {
//내부클래스: 이름이 없는 클래스(무명클래스) => new 자료형() {	}
			public void windowClosing(WindowEvent e) {
				System.exit(0); // 프로그램 종료
			}
		});
	}

}
