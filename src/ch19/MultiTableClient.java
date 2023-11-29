package ch19;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class MultiTableClient extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea taResult;
	private JComboBox cboTable;
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultiTableClient frame = new MultiTableClient();
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
	public MultiTableClient() {
//		서버소켓 => 서비스시작
		try {
			socket = new Socket("localhost", 9999);
//			socket = new Socket("ip주소", 9999);
//									서버 ip       port 
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 252, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		cboTable = new JComboBox();
		cboTable.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					int table = cboTable.getSelectedIndex() + 2;
					try {
						dos.writeInt(table);
//						dos.write => 바이트 단위. 서버쪽에서 int타입으로 인식하기 때문에 이 경우 프로그램이 정상작동 하지 않는다.
//											int table = dis.readInt();
						taResult.setText(dis.readUTF());
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		cboTable.setModel(new DefaultComboBoxModel(new String[] { "2단", "3단", "4단", "5단", "6단", "7단", "8단", "9단" }));
		cboTable.setBounds(12, 10, 99, 23);
		contentPane.add(cboTable);

		taResult = new JTextArea();
		taResult.setBounds(12, 43, 209, 208);
		contentPane.add(taResult);
	}
}