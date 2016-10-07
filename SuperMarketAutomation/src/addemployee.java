import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addemployee extends JFrame {

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
					addemployee frame = new addemployee();
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
	public addemployee() {
		setTitle("New Employee Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(170, 38, 254, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(170, 79, 254, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNameOfEmployee = new JLabel("Name of Employee");
		lblNameOfEmployee.setBounds(12, 40, 140, 15);
		contentPane.add(lblNameOfEmployee);
		
		JLabel lblContactNo = new JLabel("Contact no ");
		lblContactNo.setBounds(12, 81, 97, 15);
		contentPane.add(lblContactNo);
		
		JLabel lblAddressOfEmployee = new JLabel("Address of employee");
		lblAddressOfEmployee.setBounds(12, 148, 175, 15);
		contentPane.add(lblAddressOfEmployee);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(170, 148, 240, 80);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(12, 119, 140, 15);
		contentPane.add(lblUsername);
		
		textField_2 = new JTextField();
		textField_2.setBounds(170, 117, 254, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnDone = new JButton("Done !");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDone.setBounds(319, 236, 117, 25);
		contentPane.add(btnDone);
	}
}
