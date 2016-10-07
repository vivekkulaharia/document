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
public class Changedetails extends JFrame {

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
					Changedetails frame = new Changedetails();
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
	public Changedetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Your Details", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(12, 12, 476, 313);
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
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBounds(100, 266, 162, 25);
		panel.add(btnChangePassword);
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(347, 266, 117, 25);
		panel.add(btnDone);
	}
}
