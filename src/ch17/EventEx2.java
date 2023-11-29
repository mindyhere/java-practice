package ch17;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EventEx2 extends Frame implements WindowListener {
//						상속				인터페이스 구현
	public EventEx2() {
		addWindowListener(this);
//		 add 대상	Listener
//		이벤트소스.리스너(핸들러) <=> 대상.감시자.(처리기)
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new EventEx2();
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}
}
