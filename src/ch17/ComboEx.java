package ch17;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ComboEx extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea ta; // 필드변수로 이동

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboEx frame = new ComboEx();
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
	public ComboEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JComboBox cboTable = new JComboBox();
		cboTable.addItemListener(new ItemListener() {
//		 콤보박스.추가 아이템(이벤트)감지 (처리)	
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ta.setText(""); // 기존에 출력되어 있는 텍스트를 공백("")으로 초기화
					int table = cboTable.getSelectedIndex() + 2;
					for (int i = 1; i <= 9; i++) {
						ta.append(String.format("%2d X %2d = %2d\n", table, i, table * i));
//						.append: 기존내용 + 끝에 내용 새로 추가
//						ta.setText(String.format("%2d X %2d = %2d\n", table, i, table * i));
//						.setText: 내용 교체, 변경 => 가장 마지막 줄만 출력되는 에러 발생
					}
				}
			}
		});
		cboTable.setModel(new DefaultComboBoxModel(new String[] { "2단", "3단", "4단", "5단", "6단", "7단", "8단", "9단" }));
		contentPane.add(cboTable, BorderLayout.NORTH);

		ta = new JTextArea();
		contentPane.add(ta, BorderLayout.CENTER);
	}

}
