package allforms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.text.Position;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class User {

	public JFrame User;
	private JTextField usertxf;
	private JPasswordField passtxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User window = new User();
					window.User.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public User() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		User = new JFrame();
		User.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\VEVE\\Pictures\\userimg.PNG"));
		User.setTitle("LOGIN FORM");
		User.getContentPane().setBackground(new Color(46, 46, 46));
		User.setBounds(100, 100, 506, 291);
		User.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		User.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN FORM");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 334, 26);
		User.getContentPane().add(lblNewLabel);
		
		JLabel userlb = new JLabel("USERNAME");
		userlb.setForeground(new Color(255, 255, 255));
		userlb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		userlb.setBounds(10, 55, 152, 35);
		User.getContentPane().add(userlb);
		
		JLabel passlb = new JLabel("PASSWORD");
		passlb.setForeground(new Color(255, 255, 255));
		passlb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		passlb.setBounds(10, 119, 152, 36);
		User.getContentPane().add(passlb);
		
		usertxf = new JTextField();
		usertxf.setFont(new Font("Tahoma", Font.BOLD, 14));
		usertxf.setBounds(189, 48, 248, 42);
		User.getContentPane().add(usertxf);
		usertxf.setColumns(10);
		
		JButton loginbtn = new JButton("LOGIN");
		loginbtn.setForeground(new Color(0, 0, 255));
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vestine_nyirandikubwimana_ems","222016483","222016483");
				Statement stm=con.createStatement();
				String sql="Select * from users where username='"+usertxf.getText()+"' and password='"+passtxf.getText().toString()+"'";
				ResultSet rs=stm.executeQuery(sql);
				if (rs.next()) {
					JOptionPane.showMessageDialog(loginbtn, "Logged Successfully!!!!");
					Userinterface user=new Userinterface();
					user.setVisible(true);
					User.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "incorrect username or password!!!!");
				}
				con.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
				
			}
		});
		loginbtn.setBackground(new Color(255, 255, 255));
		loginbtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		loginbtn.setBounds(10, 186, 134, 42);
		User.getContentPane().add(loginbtn);
		
		JButton signupbtn = new JButton("SIGN UP");
		signupbtn.setForeground(new Color(0, 136, 0));
		signupbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreatAccount create= new CreatAccount();
				create.setVisible(true);
				User.dispose();
			}
		});
		signupbtn.setBackground(new Color(255, 255, 255));
		signupbtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		signupbtn.setBounds(154, 186, 108, 42);
		User.getContentPane().add(signupbtn);
		
		JButton adloginbtn = new JButton("EXIT");
		adloginbtn.setForeground(new Color(128, 0, 64));
		adloginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usertxf.setText(null);
				passtxf.setText(null);


			}
		});
		adloginbtn.setBackground(new Color(255, 255, 255));
		adloginbtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		adloginbtn.setBounds(285, 186, 152, 42);
		User.getContentPane().add(adloginbtn);
		
		passtxf = new JPasswordField();
		passtxf.setBounds(189, 113, 248, 42);
		User.getContentPane().add(passtxf);
	}
}
