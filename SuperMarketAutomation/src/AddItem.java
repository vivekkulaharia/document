import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddItem extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddItem frame = new AddItem();
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
	public AddItem() {
		setTitle("Add Item\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNameOfItem = new JLabel("Name of item");
		lblNameOfItem.setBounds(29, 35, 108, 15);
		contentPane.add(lblNameOfItem);
		
		JLabel lblBuyingPriceOf = new JLabel("Buying Price");
		lblBuyingPriceOf.setBounds(29, 74, 156, 15);
		contentPane.add(lblBuyingPriceOf);
		
		JLabel lblSellingPriceOf = new JLabel("Selling Price");
		lblSellingPriceOf.setBounds(29, 115, 94, 15);
		contentPane.add(lblSellingPriceOf);
		
		JLabel lblCodeOfItem = new JLabel("Code of item");
		lblCodeOfItem.setBounds(29, 154, 120, 15);
		contentPane.add(lblCodeOfItem);
		
		JLabel lblQuantity = new JLabel("Quantity ");
		lblQuantity.setBounds(29, 187, 108, 15);
		contentPane.add(lblQuantity);
		
		JLabel lblNewLabel = new JLabel("Weight\n");
		lblNewLabel.setBounds(29, 221, 70, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(145, 33, 291, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 72, 291, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(145, 113, 291, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(145, 152, 291, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(144, 185, 292, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(145, 219, 291, 19);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("Done !");
		btnNewButton.setBounds(319, 251, 117, 25);
		contentPane.add(btnNewButton);
	}

}
