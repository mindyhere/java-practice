package jdbc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//SaveScore.java => 점수 등록 화면
public class SaveScore extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfStudentNo;
	private JTextField tfName;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMat;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public SaveScore(ScoreMain parent) {
//				       부모창의 주소 전달
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 현재 프로그램만 종료
		setBounds(100, 100, 304, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl1 = new JLabel("학번");
		lbl1.setBounds(30, 29, 57, 15);
		contentPane.add(lbl1);

		JLabel lbl2 = new JLabel("이름");
		lbl2.setBounds(30, 64, 57, 15);
		contentPane.add(lbl2);

		JLabel lbl3 = new JLabel("국어");
		lbl3.setBounds(30, 101, 57, 15);
		contentPane.add(lbl3);

		JLabel lbl4 = new JLabel("영어");
		lbl4.setBounds(30, 139, 57, 15);
		contentPane.add(lbl4);

		JLabel lbl5 = new JLabel("수학");
		lbl5.setBounds(30, 178, 57, 15);
		contentPane.add(lbl5);

		JButton btnSave = new JButton("저장");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoreDAO dao = new ScoreDAO();
				String student_no = tfStudentNo.getText();
				String name = tfName.getText();
				int kor = Integer.valueOf(tfKor.getText());
				int eng = Integer.valueOf(tfEng.getText());
				int mat = Integer.valueOf(tfMat.getText());
				dao.insertScore(new ScoreDTO(student_no, name, kor, eng, mat));
				JOptionPane.showMessageDialog(SaveScore.this, "추가되었습니다.");
				parent.refreshTable();
				dispose();
			}
		});
		btnSave.setBounds(125, 213, 97, 23);
		contentPane.add(btnSave);

		tfStudentNo = new JTextField();
		tfStudentNo.setBounds(99, 26, 142, 21);
		contentPane.add(tfStudentNo);
		tfStudentNo.setColumns(10);

		tfName = new JTextField();
		tfName.setBounds(99, 61, 142, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);

		tfKor = new JTextField();
		tfKor.setBounds(99, 98, 142, 21);
		contentPane.add(tfKor);
		tfKor.setColumns(10);

		tfEng = new JTextField();
		tfEng.setBounds(99, 136, 142, 21);
		contentPane.add(tfEng);
		tfEng.setColumns(10);

		tfMat = new JTextField();
		tfMat.setBounds(99, 175, 142, 21);
		contentPane.add(tfMat);
		tfMat.setColumns(10);
	}
}
