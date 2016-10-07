import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class updateimventory extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnDone;
	private JButton btnAddItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateimventory frame = new updateimventory();
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
	public updateimventory() {
		setTitle("Update Inventory");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 12, 307, 249);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"S no", "Name of item", "Code of item"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(0).setMinWidth(25);
		scrollPane.setViewportView(table);
		
		JButton btnAddQuantity = new JButton("Update Quantity");
		btnAddQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddQuantity.setFont(new Font("Dialog", Font.BOLD, 11));
		btnAddQuantity.setBounds(366, 28, 165, 25);
		contentPane.add(btnAddQuantity);
		
		btnDone = new JButton("Done !");
		btnDone.setBounds(386, 236, 117, 25);
		contentPane.add(btnDone);
		
		btnAddItem = new JButton("Add item");
		btnAddItem.setBounds(371, 85, 160, 25);
		contentPane.add(btnAddItem);
	}

}
