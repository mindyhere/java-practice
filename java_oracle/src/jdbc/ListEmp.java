package jdbc;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ListEmp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Vector data, cols;
	private EmpDAO empDao;
	private DeptDAO deptDao;
//	DAO: Data Access Object 데이터 접근 객체(해김적인 비즈니스 로직)

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListEmp frame = new ListEmp();
//									new 자료형 => 메모리 생성(객체 생성) => 생성자
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
	public ListEmp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox cboDept = new JComboBox();
		cboDept.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String dname = cboDept.getSelectedItem().toString();
//				  스트링 변수에 저장 <= getSelectedItem(리턴타입: Obj) 스트링으로 변환
					DefaultTableModel model = new DefaultTableModel(empDao.listEmp(dname), cols);
//										모델 <= 실제 데이터	 		   (선택한 아이템(dname) -> listEmp 메서드 실행)
					table.setModel(model);
//					테이블.모델세팅(모델이름) <= 화면 반영
				}
			}
		});
		cboDept.setBounds(12, 23, 115, 23);
		contentPane.add(cboDept);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 56, 410, 195);
		contentPane.add(scrollPane);
		cols = new Vector();
		cols.add("사원번호");
		cols.add("사원이름");
		cols.add("직급");
		cols.add("입사일자");
		cols.add("급여");
		cols.add("소속부서");
		empDao = new EmpDAO();
		DefaultTableModel model = new DefaultTableModel(empDao.listEmp("%"), cols);

		table = new JTable(model);
		scrollPane.setViewportView(table);

		deptDao = new DeptDAO();
		ArrayList<DeptDTO> deptList = deptDao.listDept();
		cboDept.addItem("전체부서"); // 콤보박스에 "전체부서" 항목(item)을 추가
		for (DeptDTO dto : deptList) {
			cboDept.addItem(dto.getDname());
		}

	} // 생성자의 끝
}
// 클래스의 끝
