package view;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Diem extends JFrame {
	public JTable table;
	public JScrollPane scroll;
	public static DefaultTableModel model = new DefaultTableModel();
	public String[] arr = { "Tên người chơi", "Điểm" };
	public JLabel diem;
	public static JButton xoa;
	JPanel p = new JPanel();

	public Diem(String title) throws HeadlessException {
		super(title);
		diem = new JLabel("Danh sách điểm của bạn");
		table = new JTable();
		scroll = new JScrollPane();
		scroll = new JScrollPane(table);
		xoa = new JButton("Xóa điểm");
		model.setColumnIdentifiers(arr);
		table.setModel(model);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(diem, BorderLayout.NORTH);
		getContentPane().add(scroll, BorderLayout.CENTER);
		getContentPane().add(p.add(xoa), BorderLayout.SOUTH);
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(200, 230);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
	}

	public Diem() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
	}

}
