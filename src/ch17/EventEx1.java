package ch17;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EventEx1 extends Frame {
	public EventEx1() {
		addWindowListener(new WindowAdapter() {
//		  프레임에 추가
//	add + 대상 + Listener => 이벤트소스.리스너(핸들러)
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
//			프로그램 강제 종료 => (0) 정상 종료
//					  		(-1) 비정상 종료
			}
		});
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new EventEx1();
	}

}
