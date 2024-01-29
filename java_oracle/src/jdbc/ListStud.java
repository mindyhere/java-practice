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

public class ListStud extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Vector data, cols;
	private StudExDAO studDao;
	private MajorExDAO majorDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListStud frame = new ListStud();
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
	public ListStud() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 63, 372, 188);
		contentPane.add(scrollPane);

		cols = new Vector();
		cols.add("학번");
		cols.add("이름");
		cols.add("학년");
		cols.add("지도교수번호");
		cols.add("전공");
		studDao = new StudExDAO();
		DefaultTableModel model = new DefaultTableModel(studDao.listStud("%"), cols);

		table = new JTable(model);
		scrollPane.setViewportView(table);

		JComboBox cboMajor = new JComboBox();
		cboMajor.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String mname = cboMajor.getSelectedItem().toString();
					DefaultTableModel model = new DefaultTableModel(studDao.listStud(mname), cols);
					table.setModel(model);
				}
			}
		});

		cboMajor.setBounds(29, 23, 93, 23);
		contentPane.add(cboMajor);
		majorDao = new MajorExDAO();
		ArrayList<MajorExDTO> majorList = majorDao.listMajor();
		cboMajor.addItem("total");
		for (MajorExDTO dto : majorList) {
			cboMajor.addItem(dto.getMname());
		}
	}
}
