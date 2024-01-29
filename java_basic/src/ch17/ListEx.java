package ch17;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ListEx extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf;
	private JList<String> list;
	private DefaultListModel<String> model; // 리스트 모델(작업을 대행, 변환기) => 코드로 직접 작성

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListEx frame = new ListEx();
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
	public ListEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		tf = new JTextField();
//		Design 보기 > 우클릭 > Add event handler > action > actionPerformed
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.addElement(tf.getText());
//				모델   요소를 추가		텍스트 1줄
				list.setModel(model); // 화면에 반영
				tf.setText(""); // 텍스트필드 내용 초기화("")
				tf.requestFocus(); // 포커스 지정요청
			}
		});
		panel.add(tf);
		tf.setColumns(10);

		JButton btnAdd = new JButton("추가");

		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//		JList컴포넌트 <== 모델(변환기) <== 스트링: 스트링을 저장할 수 있도록 모델을 세팅
				model.addElement(tf.getText());
//				모델 		추가요소	텍스트필드.getText(): 텍스트필드 스트링 1줄
				list.setModel(model);
				tf.setText("");
				tf.requestFocus();
			}
		});
		panel.add(btnAdd);

		JButton btnDel = new JButton("삭제");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = list.getSelectedIndex();
//									리스트.get 선택된리스트 => 선택하지 않은 상태 = -1
				if (selectedIndex != -1) {
					model.remove(selectedIndex);
//			 	-1이 아니면: 선택된 인덱스가 있으면 => remove
					list.setModel(model);
//					리스트. 세팅     모델
				}
			}
		});

		panel.add(btnDel);

		model = new DefaultListModel<>();
		list = new JList<>();
		contentPane.add(list, BorderLayout.CENTER);
	}

}
