package jdbc;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ComboboxEx extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox combo;
	private JList list;

	private StudExDAO studDao;
	private MajorExDAO majorDao;
	private ArrayList<MajorExDTO> majorList;
	private ArrayList<StudExDTO> studList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboboxEx frame = new ComboboxEx();
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
	public ComboboxEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		studDao = new StudExDAO();
		majorDao = new MajorExDAO();
		majorList = majorDao.listMajor();
		studList = studDao.listStud(0);

		list = new JList();

		combo = new JComboBox();
		combo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					int idx = combo.getSelectedIndex();
					if (idx != -1) {
						refreshList(idx);
					}
				}
			}
		});

		contentPane.add(combo, BorderLayout.NORTH);

		for (MajorExDTO dto : majorList) {
			combo.addItem(dto.getMname());
		}
		refreshList(0);

		contentPane.add(list, BorderLayout.CENTER);
	}

	void refreshList(int idx) {
		int majorno = majorList.get(idx).getMajorno();
		studList = studDao.listStud(majorno);
		String[] names = new String[studList.size()];
		for (int i = 0; i < names.length; i++) {
			names[i] = studList.get(i).getSname();
		}
		DefaultListModel<String> model = new DefaultListModel<>();
		for (String val : names) {
			model.addElement(val);
		}
		list.setModel(model);
	}
}
