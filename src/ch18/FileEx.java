package ch18;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FileEx extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfFileName;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileEx frame = new FileEx();
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
	public FileEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfFileName = new JTextField();
		tfFileName.setBounds(36, 30, 116, 21);
		contentPane.add(tfFileName);
		tfFileName.setColumns(10);

		JButton button1 = new JButton("OK");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File(tfFileName.getText());
//				파일 참조(주소값을 저장) <= test파일 디렉토리(D:/test.txt)
				if (!file.exists()) {
//						 .exists => 파일이 있으면 true, 없으면 false
//					!: not => 새파일 생성(createNewFile)
					try {
						file.createNewFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				String str = "Name: " + file.getName() + "\n" + "Length: " + file.length() + "\n" + "Parent : "
						+ file.getParent();
				ta.setText(str);
			}
		});
		button1.setBounds(195, 29, 97, 23);
		contentPane.add(button1);

		ta = new JTextArea();
		ta.setBounds(36, 74, 256, 151);
		contentPane.add(ta);
	}

}
