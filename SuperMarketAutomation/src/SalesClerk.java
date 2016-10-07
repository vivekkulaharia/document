import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class SalesClerk extends JFrame {

	private JPanel contentPane;
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
					SalesClerk frame = new SalesClerk();
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
	public SalesClerk() {
		setTitle("SalesClerk Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Dialog", Font.BOLD, 13));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(12, 0, 623, 25);
		contentPane.add(lblWelcome);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Your Details", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(12, 42, 435, 303);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setBounds(12, 69, 102, 28);
		panel.add(lblUsername);
		
		JLabel lblMobileNo = new JLabel("Mobile No :");
		lblMobileNo.setBounds(12, 109, 90, 15);
		panel.add(lblMobileNo);
		
		JLabel lblAddress = new JLabel("Address  :");
		lblAddress.setBounds(12, 148, 90, 21);
		panel.add(lblAddress);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(12, 40, 70, 15);
		panel.add(lblName);
		
		JButton btnChangeDetails = new JButton("Change Details");
		btnChangeDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Changedetails frame = new Changedetails();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnChangeDetails.setBounds(154, 266, 142, 25);
		panel.add(btnChangeDetails);
		
		textField = new JTextField();
		textField.setBounds(100, 38, 323, 17);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(100, 74, 321, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(100, 107, 323, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 148, 323, 106);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnEmployeeDb = new JButton("Generate Bill");
		btnEmployeeDb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Bill frame = new Bill();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEmployeeDb.setFont(new Font("Dialog", Font.BOLD, 11));
		btnEmployeeDb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEmployeeDb.setBounds(459, 63, 176, 35);
		contentPane.add(btnEmployeeDb);
		
		JButton btnNewButton = new JButton("Update Inventory");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					updateimventory frame = new updateimventory();
					frame.setVisible(true);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButton.setBounds(459, 137, 176, 42);
		contentPane.add(btnNewButton);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(492, 303, 117, 25);
		contentPane.add(btnLogout);
	}
}
