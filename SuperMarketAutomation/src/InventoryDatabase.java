import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class InventoryDatabase extends   JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryDatabase frame = new InventoryDatabase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		public InventoryDatabase() {
		setTitle("InventoryDataBase");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnChangePrice = new JButton("Change Price");
		btnChangePrice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			       int row = table.getSelectedRow();
		            int col = table.getSelectedColumn();

		            Object data = (Object)table.getValueAt(row, col);

			}
		});
		btnChangePrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnChangePrice.setFont(new Font("Dialog", Font.BOLD, 10));
		btnChangePrice.setBounds(565, 9, 117, 25);
		contentPane.add(btnChangePrice);
		
		JButton btnNewButton = new JButton("Add item");
		
		btnNewButton.setBounds(565, 60, 117, 25);
		contentPane.add(btnNewButton);
		
		JButton btnAddQuantity = new JButton("Change Quantity");
		btnAddQuantity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			       int row = table.getSelectedRow();
		            int col = table.getSelectedColumn();

		            Object data = (Object)table.getValueAt(row, col);
                 
			}
		});
		btnAddQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddQuantity.setFont(new Font("Dialog", Font.BOLD, 9));
		btnAddQuantity.setBounds(565, 114, 117, 25);
		contentPane.add(btnAddQuantity);
		
		JButton btnDone = new JButton("Done !");
		btnDone.setBounds(581, 225, 101, 25);
		contentPane.add(btnDone);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 541, 275);
		contentPane.add(scrollPane);
		DefaultTableModel modelo = new DefaultTableModel();
		final JTable table_1 = new JTable(modelo);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S No", "Name", "Code", "CostPrice", "SellingPrice", "Quantity","Weight",
			}
		) {
			Class[] columnTypes = new Class[] {
				int.class, String.class, int.class, float.class, int.class, float.class,float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("8_gore_st_flea_market.jpg"));
		lblNewLabel.setBounds(0, 0, 694, 299);
		contentPane.add(lblNewLabel);
		
		//table = new JTable();
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					AddItem frame = new AddItem();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				int numCols = table_1.getModel().getColumnCount();

				Object [] fila = new Object[numCols]; 
				fila[0] = 1;
				fila[1] = "420";
				fila[2] = 1;
				fila[3] = 1;
				fila[4] = 1;
				fila[5] = 1;
				fila[6] = 1;
				((DefaultTableModel) table_1.getModel()).addRow(fila);
				
			}
		});

		
	}
}
