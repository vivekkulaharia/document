import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Welcome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
					frame.setVisible(true);
				//	{
		            //frame.setVisible(false);
		            //frame.dispose();}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Welcome() {
		setResizable(false);
		setTitle("Supermarket Automation Software");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME\n");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(188, 37, 164, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SUPERMARKET AUTOMATION SOFTWARE");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(40, 120, 472, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TO");
		lblNewLabel_2.setForeground(Color.CYAN);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBounds(233, 93, 35, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Login frame1 = new Login();
					frame1.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		lblNewLabel_4.setIcon(new ImageIcon("HDtimelapse.net_People_0137_hirez.jpg"));
		lblNewLabel_4.setBounds(0, 0, 524, 334);
		contentPane.add(lblNewLabel_4);
		
			
			
	}
}
