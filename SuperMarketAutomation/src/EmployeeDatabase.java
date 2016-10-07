import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmployeeDatabase extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeDatabase frame = new EmployeeDatabase();
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
	public EmployeeDatabase() {
		
		setResizable(false);
		setTitle("Employee Database\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					addemployee frame = new addemployee();
					frame.setVisible(true);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnAddEmployee.setFont(new Font("Dialog", Font.BOLD, 10));
		btnAddEmployee.setBounds(631, 27, 117, 25);
		contentPane.add(btnAddEmployee);
		
		JButton btnNewButton = new JButton("Delete Employee\n");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 9));
		btnNewButton.setBounds(631, 78, 117, 25);
		contentPane.add(btnNewButton);
		
		JButton btnDone = new JButton("Done !");
		btnDone.setBounds(631, 215, 117, 25);
		contentPane.add(btnDone);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 607, 254);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S No", "Name ", "Contact no","Username"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setMinWidth(50);
		table.getColumnModel().getColumn(3).setMinWidth(157);
		table.getColumnModel().getColumn(1).setMinWidth(147);
		scrollPane.setViewportView(table);
		
		JButton btnMoreDetail = new JButton("More Detail");
		btnMoreDetail.setBounds(639, 135, 117, 25);
		contentPane.add(btnMoreDetail);
	}

}
