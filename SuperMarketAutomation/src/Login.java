import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.*;
public class Login extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();	
	final StringBuilder sb = new StringBuilder("vb");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setBackground(Color.GRAY);
		setTitle("Login Window");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginAs = new JLabel("Login As");
		lblLoginAs.setFont(new Font("Dialog", Font.BOLD, 20));
		lblLoginAs.setForeground(new Color(51, 51, 51));
		lblLoginAs.setBounds(151, 12, 114, 31);
		contentPane.add(lblLoginAs);
	    
	    final String f = new String("bn");
;
		JRadioButton rdbtnManager = new JRadioButton("Manager");
		rdbtnManager.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 sb.delete(0, sb.length()).append("m"); 
			}
		});
		buttonGroup.add(rdbtnManager);
		rdbtnManager.setFont(new Font("Dialog", Font.BOLD, 15));
		rdbtnManager.setBounds(134, 76, 149, 23);
		contentPane.add(rdbtnManager);
		
		JRadioButton rdbtnSalesclerk = new JRadioButton("SalesCLerk");
		rdbtnSalesclerk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 sb.delete(0, sb.length()).append("s");
				
			}
		});
		buttonGroup.add(rdbtnSalesclerk);
		rdbtnSalesclerk.setFont(new Font("Dialog", Font.BOLD, 15));
		rdbtnSalesclerk.setBounds(134, 137, 149, 23);
		contentPane.add(rdbtnSalesclerk);
		
		JButton btnOk = new JButton("OK!");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switch(sb.toString())
				{
				case "m":{
					try {
						Manager frame = new Manager();
						frame.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				} break;
				case "s":{
					try {
						SalesClerk frame = new SalesClerk();
						frame.setVisible(true);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				};break;
				default  : break;
				}
				
			}
		});
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOk.setBounds(284, 221, 117, 25);
		contentPane.add(btnOk);
	}
}
