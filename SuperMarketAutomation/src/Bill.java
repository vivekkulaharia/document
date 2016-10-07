import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Bill extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill frame = new Bill();
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
	public Bill() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("/home/vivek/Desktop/supermarket aisle.png"));
		setTitle("Bill\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddItem = new JButton("Add Item");
		
		btnAddItem.setBounds(565, 58, 105, 25);
		contentPane.add(btnAddItem);
		
		JButton btnPrintBill = new JButton("Print Bill");
		btnPrintBill.setBounds(569, 178, 93, 25);
		contentPane.add(btnPrintBill);
		
		JButton btnGetQuantity = new JButton("Get Quantity");
		btnGetQuantity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnGetQuantity.setFont(new Font("Dialog", Font.BOLD, 11));
		btnGetQuantity.setBounds(565, 126, 117, 25);
		contentPane.add(btnGetQuantity);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 47, 557, 196);
		contentPane.add(scrollPane_1);
		
		DefaultTableModel modelo = new DefaultTableModel();
		final JTable table_1 = new JTable(modelo);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S No", "Item","Item Code", "Quantity", "Weight", "PricePerunit", " Net Price"
			}
		) {
			Class[] columnTypes = new Class[] {
				int.class, String.class, int.class, int.class, float.class, float.class, float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.getColumnModel().getColumn(1).setPreferredWidth(115);
		table_1.getColumnModel().getColumn(3).setMinWidth(217);
		table_1.getColumnModel().getColumn(1).setMinWidth(147);
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img_galleria_branch_th_bg4.jpg"));
		lblNewLabel.setBounds(0, 0, 682, 273);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(22, 242, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterDate = new JLabel("Date");
		lblEnterDate.setBounds(12, 281, 53, 15);
		contentPane.add(lblEnterDate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(58, 279, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTransactionId = new JLabel("Transaction ID");
		lblTransactionId.setBounds(199, 281, 117, 15);
		contentPane.add(lblTransactionId);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setBounds(326, 279, 114, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		btnAddItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				//int numCols = table_1.getModel().getColumnCount();

				Object [] fila = new Object[7]; 
				fila[0] = 1;
				fila[1] = "mango \n orange\nbabana";
				fila[2] = 23;   
				fila[3] = 3;
				fila[4] = 3;
				fila[5] = 3;
				fila[6] = 3
						;
				
				((DefaultTableModel) table_1.getModel()).addRow(fila);

			}
		});
	}
}
