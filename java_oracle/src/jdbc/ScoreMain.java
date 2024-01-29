package jdbc;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//ScoreMain.java => 시작화면설계(GUI), 점수 목록 화면표시
//ScoreMain 입력 => SaveScore 저장 => ScoreMain의 화면갱신 => refresh.Table 현재창닫기 

public class ScoreMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ScoreDAO dao;
	private Vector data, cols;
	private JButton btnAdd;
	private JButton btnEdit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreMain frame = new ScoreMain();
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
	public ScoreMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		dao = new ScoreDAO();
		cols = new Vector();
		cols.add("학번");
//		벡터참조변수.add(value) => 벡터에 새로운 데이터 추가
		cols.add("이름");
		cols.add("국어");
		cols.add("영어");
		cols.add("수학");
		cols.add("총점");
		cols.add("평균");

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveScore form = new SaveScore(ScoreMain.this);
//				추가 폼
				form.setVisible(true);
				form.setLocation(200, 200);
			}
		});
		btnAdd.setBounds(12, 10, 97, 23);
		contentPane.add(btnAdd);

		btnEdit = new JButton("수정/삭제");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idx = table.getSelectedRow();
//						 JTable 선택된 행번호 인덱스
				if (idx == -1) {
//					아무것도 선택하지 않았을 때 -1
					JOptionPane.showMessageDialog(ScoreMain.this, "편집할 레코드를 선택하세요.");
					return; // 리턴타입 void => 메서드 종료
				}
				String student_no = String.valueOf(table.getValueAt(idx, 0));
//							 (Obj타입을 String으로) <= 테이블.getValueAt(행번호, 열번호)
				String name = String.valueOf(table.getValueAt(idx, 1));
				int kor = Integer.valueOf(table.getValueAt(idx, 2) + "");
//									정수타입으로   <==	  스트링: Obj타입 + ""
				int eng = Integer.valueOf(table.getValueAt(idx, 3) + "");
				int mat = Integer.valueOf(table.getValueAt(idx, 4) + "");

				ScoreDTO dto = new ScoreDTO(student_no, name, kor, eng, mat);
				EditScore form = new EditScore(ScoreMain.this, dto);
//												부모창의 주소	   전달값(과목점수데이터)
				form.setVisible(true);
			}
		});
		btnEdit.setBounds(121, 10, 97, 23);
		contentPane.add(btnEdit);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 43, 514, 385);
		contentPane.add(scrollPane);

		table = new JTable();
		refreshTable(); // 메서드 호출 call
		scrollPane.setViewportView(table);
	}

	public void refreshTable() {
//		dao => DB (=> Vector => Model) => JTable
//					 데이터저장		변환/대행	  화면표시

		DefaultTableModel model = new DefaultTableModel(dao.listScore(), cols); 
//		모델에 데이터 전달  								items => 데이터	  헤더
		table.setModel(model); // 화면 반영
	}
}
