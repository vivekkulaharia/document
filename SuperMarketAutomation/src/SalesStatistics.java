import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class SalesStatistics extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesStatistics frame = new SalesStatistics();
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
	public SalesStatistics() {
		setTitle("SalesStatistics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 373, 442);
		contentPane.add(scrollPane);
		
		JTextArea txtrIdPrice = new JTextArea();
		txtrIdPrice.setForeground(Color.BLACK);
		txtrIdPrice.setEditable(false);
		txtrIdPrice.setText("<dynamic>\nCode No: <dynamic>\nPrice Realized: 0.0\nQuantity: 0.0\nProfit: 0.0");
		txtrIdPrice.setRows(5);
		txtrIdPrice.setColumns(20);
		txtrIdPrice.setBounds(397, 235, 298, 121);
		contentPane.add(txtrIdPrice);
		
		JButton button = new JButton();
		button.setText("BACK !!");
		button.setFont(new Font("Dialog", Font.BOLD, 12));
		button.setBackground(new Color(0, 153, 153));
		button.setBounds(576, 380, 96, 50);
		contentPane.add(button);
		
		JButton button_1 = new JButton();
		button_1.setText("Histogram");
		button_1.setFont(new Font("Dialog", Font.BOLD, 12));
		button_1.setBackground(new Color(0, 153, 153));
		button_1.setBounds(427, 380, 107, 50);
		contentPane.add(button_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(397, 12, 304, 199);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Duration");
		lblNewLabel.setBounds(87, 12, 193, 15);
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        

		comboBox.setBounds(97, 48, 44, 24);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(140, 48, 67, 24);
		panel.add(comboBox_1);
	    comboBox_1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec" }));


		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(219, 48, 73, 24);
		panel.add(comboBox_2);
		comboBox_2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(97, 108, 44, 24);
		panel.add(comboBox_3);
		comboBox_3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(140, 108, 67, 24);
		panel.add(comboBox_4);
		comboBox_4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec" }));

		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(219, 108, 73, 24);
		panel.add(comboBox_5);
		comboBox_5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));
		
		JLabel lblStart = new JLabel("Start Date");
		lblStart.setBounds(0, 53, 82, 15);
		panel.add(lblStart);
		
		JLabel lblEnd = new JLabel("End Date");
		lblEnd.setBounds(0, 113, 70, 15);
		panel.add(lblEnd);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(97, 162, 117, 25);
		panel.add(btnSubmit);
        
	}
}
