package jdbc;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class JTableEx extends JFrame {

	private static final long serialVersionUID = 1L; // 코드의 버전
	private JPanel contentPane;
	private JTable table;
	private Vector data, cols;
//				   데이터  헤더

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableEx frame = new JTableEx();
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
	public JTableEx() {

		cols = new Vector();
//		헤더 행 벡터 생성
		cols.add("학번");
		cols.add("이름");
		cols.add("국어");
		cols.add("영어");
		cols.add("수학");
		cols.add("총점");
		cols.add("평균");

		ScoreDAO dao = new ScoreDAO();
//		dao 생성

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
//		DB → dao → DefaultTableModel(기능 대행) → JTable
		DefaultTableModel model = new DefaultTableModel(dao.list_score(), cols) {
//														     데이터	 	   헤더
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		}; // 테이블모델에 자료전달

		table = new JTable(model);// 화면 갱신
		scrollPane.setViewportView(table);
	}
}
