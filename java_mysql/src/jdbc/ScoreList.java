package jdbc;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ScoreList extends JFrame {
	private ScoreDAO dao;
	private Vector<String> cols;
	private DefaultTableModel model;
	private ScoreDTO dto;

	private JPanel contentPane;
	private JTextField tfStudentNo;
	private JTextField tfName;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMat;
	private JTextField tfSearch;
	private JTable table;
	private JButton btnUpdate;
	private JButton btnSave;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreList frame = new ScoreList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} // main의 끝

	/**
	 * Create the frame.
	 */
	public ScoreList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 507);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 181, 501, 277);
		contentPane.add(scrollPane);

		dao = new ScoreDAO();
		cols = new Vector<String>();
		cols.add("학번");
		cols.add("이름");
		cols.add("국어");
		cols.add("영어");
		cols.add("수학");
		cols.add("총점");
		cols.add("평균");
		list();

		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idx = table.getSelectedRow();
				tfStudentNo.setEditable(false);
				tfStudentNo.setText(table.getValueAt(idx, 0) + "");
				tfName.setText(table.getValueAt(idx, 1) + "");
				tfKor.setText(table.getValueAt(idx, 2) + "");
				tfEng.setText(table.getValueAt(idx, 3) + "");
				tfMat.setText(table.getValueAt(idx, 4) + "");
			}
		});

		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("학번");
		lblNewLabel.setBounds(12, 10, 57, 15);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("이름");
		label.setBounds(12, 35, 57, 15);
		contentPane.add(label);

		JLabel label_1 = new JLabel("국어");
		label_1.setBounds(12, 60, 57, 15);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("영어");
		label_2.setBounds(12, 85, 57, 15);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("수학");
		label_3.setBounds(12, 110, 57, 15);
		contentPane.add(label_3);

		JLabel lblNewLabel_1 = new JLabel("이름을 입력하세요");
		lblNewLabel_1.setBounds(12, 156, 116, 15);
		contentPane.add(lblNewLabel_1);

		tfStudentNo = new JTextField();
		tfStudentNo.setBounds(81, 7, 116, 21);
		contentPane.add(tfStudentNo);
		tfStudentNo.setColumns(10);

		tfName = new JTextField();
		tfName.setBounds(81, 32, 116, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);

		tfKor = new JTextField();
		tfKor.setBounds(81, 57, 116, 21);
		contentPane.add(tfKor);
		tfKor.setColumns(10);

		tfEng = new JTextField();
		tfEng.setBounds(81, 82, 116, 21);
		contentPane.add(tfEng);
		tfEng.setColumns(10);

		tfMat = new JTextField();
		tfMat.setBounds(81, 107, 116, 21);
		contentPane.add(tfMat);
		tfMat.setColumns(10);

		btnSave = new JButton("저장");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				int result = dao.insert_score(dto);
				if (result == 1) {
					JOptionPane.showMessageDialog(ScoreList.this, "저장되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		btnSave.setBounds(209, 6, 97, 23);
		contentPane.add(btnSave);

		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				int result = dao.update_score(dto);
				if (result == 1) {
					JOptionPane.showMessageDialog(ScoreList.this, "수정되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		btnUpdate.setBounds(209, 31, 97, 23);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String student_no = tfStudentNo.getText();
				int result = 0;
				int response = JOptionPane.showConfirmDialog(ScoreList.this, "삭제하시겠습니까?");
				if (response == JOptionPane.YES_OPTION) {
					result = dao.delete_score(student_no);
				}
				if (result == 1) {
					JOptionPane.showMessageDialog(ScoreList.this, "삭제되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		btnDelete.setBounds(209, 56, 97, 23);
		contentPane.add(btnDelete);

		tfSearch = new JTextField();
		tfSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				search();
			}
		});

		tfSearch.setBounds(124, 153, 116, 21);
		contentPane.add(tfSearch);
		tfSearch.setColumns(10);

		JButton btnSearch = new JButton("찾기");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnSearch.setBounds(252, 152, 97, 23);
		contentPane.add(btnSearch);
	} // 생성자의 끝

	public void search() {
		String name = tfSearch.getText();
		model = new DefaultTableModel(dao.search_score(name), cols) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(model);
	}

	public void input() {
		String student_no = tfStudentNo.getText();
		String name = tfName.getText();
		int kor = Integer.parseInt(tfKor.getText());
		int eng = Integer.parseInt(tfEng.getText());
		int mat = Integer.parseInt(tfMat.getText());
		dto = new ScoreDTO(student_no, name, kor, eng, mat);
	}

	public void clear() {
//	텍스트필드를 초기화
		tfStudentNo.setText("");
		tfName.setText("");
		tfKor.setText("");
		tfEng.setText("");
		tfMat.setText("");
		tfStudentNo.requestFocus(); // 해당필드로 커서이동 설정
		tfStudentNo.setEditable(true); // 편집 가능상태로(true)
	}

	public void list() {
		model = new DefaultTableModel(dao.list_score(), cols) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}
}
