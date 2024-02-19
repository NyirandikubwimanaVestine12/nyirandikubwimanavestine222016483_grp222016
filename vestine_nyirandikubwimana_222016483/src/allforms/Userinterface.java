package allforms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Userinterface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Userinterface frame = new Userinterface();
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
	public Userinterface() {
		setTitle("Userinterface page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 44, 44));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel welclb = new JLabel("WELCOME TO USER INTERFACE");
		welclb.setForeground(new Color(255, 255, 255));
		welclb.setBackground(new Color(0, 0, 0));
		welclb.setFont(new Font("Imprint MT Shadow", Font.BOLD, 24));
		welclb.setHorizontalAlignment(SwingConstants.CENTER);
		welclb.setBounds(10, 11, 498, 36);
		contentPane.add(welclb);
		
		JButton homebtn = new JButton("HOME");
		homebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Userinterface fc= new Userinterface();
				fc.setVisible(true);
			}
		});
		homebtn.setForeground(new Color(0, 0, 191));
		homebtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		homebtn.setBounds(16, 70, 100, 40);
		contentPane.add(homebtn);
		
		JButton buybtn = new JButton("BUY");
		buybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orders cst=new orders();
				cst.setVisible(true);
				dispose();
			}
		});
		buybtn.setForeground(new Color(0, 217, 217));
		buybtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		buybtn.setBounds(126, 70, 121, 40);
		contentPane.add(buybtn);
		
		JButton logoutbtn = new JButton("LOGOUT");
		logoutbtn.setForeground(new Color(224, 57, 1));
		logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User us=new User();
				us.User.setVisible(true);
				dispose();
				
			}
		});
		logoutbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		logoutbtn.setBounds(443, 71, 100, 38);
		contentPane.add(logoutbtn);
		
		JLabel bdyentrprise = new JLabel("ENTERPRISE   MANAGEMENT   SYSTEM");
		bdyentrprise.setFont(new Font("Sitka Heading", Font.BOLD, 24));
		bdyentrprise.setHorizontalAlignment(SwingConstants.CENTER);
		bdyentrprise.setForeground(new Color(255, 255, 255));
		bdyentrprise.setBounds(22, 117, 486, 57);
		contentPane.add(bdyentrprise);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\VEVE\\Pictures\\photoshop project\\1.a\\baku city.JPG"));
		lblNewLabel.setBounds(44, 160, 454, 220);
		contentPane.add(lblNewLabel);
		
		JButton splybtn = new JButton("ADMIN PAGE");
		splybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Admininterface spy=new Admininterface();
				spy.setVisible(true);
				dispose();
			}
		});
		splybtn.setForeground(new Color(0, 174, 0));
		splybtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		splybtn.setBounds(257, 70, 158, 40);
		contentPane.add(splybtn);
	}
}
