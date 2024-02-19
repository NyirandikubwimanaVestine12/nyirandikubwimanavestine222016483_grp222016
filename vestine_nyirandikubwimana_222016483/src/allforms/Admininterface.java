package allforms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Admininterface extends JFrame {

	JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admininterface frame = new Admininterface();
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
	public Admininterface() {
		setTitle("Admin interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 437);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 44, 44));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ENTERPRISE MANAGEMENT SYSTEM");
		lblNewLabel_1.setForeground(new Color(128, 0, 64));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(40, 129, 406, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel welcadminlb = new JLabel("WELCOME TO ADMIN PAGE");
		welcadminlb.setHorizontalAlignment(SwingConstants.CENTER);
		welcadminlb.setForeground(new Color(255, 255, 255));
		welcadminlb.setFont(new Font("Times New Roman", Font.BOLD, 27));
		welcadminlb.setBounds(10, 11, 470, 34);
		contentPane.add(welcadminlb);
		
		JButton homebtn = new JButton("HOME");
		homebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admininterface admin=new Admininterface();
				admin.setVisible(true);
			}
		});
		homebtn.setForeground(new Color(0, 0, 255));
		homebtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		homebtn.setBounds(30, 74, 89, 34);
		contentPane.add(homebtn);
		
		JButton viewallbtn = new JButton("VIEW ALL");
		viewallbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moreviews more= new moreviews();
				more.setVisible(true);
				dispose();
			}
		});
		viewallbtn.setForeground(new Color(0, 185, 47));
		viewallbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		viewallbtn.setBounds(152, 74, 153, 34);
		contentPane.add(viewallbtn);
		
		JButton logoutbtn = new JButton("LOGOUT");
		logoutbtn.setForeground(new Color(187, 61, 0));
		logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user=new User();
				user.User.setVisible(true);
			dispose();
			}
		});
		logoutbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		logoutbtn.setBounds(357, 73, 97, 36);
		contentPane.add(logoutbtn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\VEVE\\Pictures\\photoshop project\\1.b\\tiber.JPG"));
		lblNewLabel.setBounds(30, 119, 424, 268);
		contentPane.add(lblNewLabel);
	}
}
