package allforms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.imageio.plugins.tiff.ExifGPSTagSet;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

public class CreatAccount extends JFrame {

	private JPanel contentPane;
	private JTextField nametxf;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField agetxf;
	private JTextField mobiletxf;
	private JTextField emailtxf;
	private JTextField usertxf;
	private JPasswordField passtxf;
	Connection con;
	PreparedStatement ps;
	private JTextField postxf;
	private JTextField idtxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreatAccount frame = new CreatAccount();
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
	public CreatAccount() {
		setBackground(new Color(0, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\VEVE\\Pictures\\userimg.PNG"));
		setTitle("ACCOUNT FORM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 510);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NAME:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 87, 116, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblGender = new JLabel("GENDER:");
		lblGender.setForeground(new Color(255, 255, 255));
		lblGender.setBackground(new Color(0, 0, 0));
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(10, 166, 116, 14);
		contentPane.add(lblGender);
		
		JLabel lblAge = new JLabel("AGE:");
		lblAge.setForeground(new Color(255, 255, 255));
		lblAge.setBackground(new Color(0, 0, 0));
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAge.setBounds(10, 206, 116, 14);
		contentPane.add(lblAge);
		
		JLabel lblMobileNo = new JLabel("MOBILE NO:");
		lblMobileNo.setForeground(new Color(255, 255, 255));
		lblMobileNo.setBackground(new Color(0, 0, 0));
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMobileNo.setBounds(10, 245, 116, 14);
		contentPane.add(lblMobileNo);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setBackground(new Color(0, 0, 0));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(10, 291, 116, 14);
		contentPane.add(lblEmail);
		
		JLabel lblUsername = new JLabel("USERNAME:");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setBackground(new Color(0, 0, 0));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(10, 336, 116, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBackground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(10, 380, 116, 14);
		contentPane.add(lblPassword);
		
		nametxf = new JTextField();
		nametxf.setBackground(new Color(255, 255, 255));
		nametxf.setFont(new Font("Tahoma", Font.BOLD, 13));
		nametxf.setBounds(187, 86, 158, 20);
		contentPane.add(nametxf);
		nametxf.setColumns(10);
		
		JRadioButton malerd = new JRadioButton("male");
		malerd.setForeground(new Color(255, 255, 255));
		malerd.setFont(new Font("Tahoma", Font.BOLD, 13));
		malerd.setBackground(new Color(0, 0, 0));
		buttonGroup.add(malerd);
		malerd.setBounds(187, 164, 78, 23);
		contentPane.add(malerd);
		
		JRadioButton femalerd = new JRadioButton("female");
		femalerd.setForeground(new Color(255, 255, 255));
		femalerd.setFont(new Font("Tahoma", Font.BOLD, 13));
		femalerd.setBackground(new Color(0, 0, 0));
		buttonGroup.add(femalerd);
		femalerd.setBounds(307, 166, 100, 23);
		contentPane.add(femalerd);
		
		agetxf = new JTextField();
		agetxf.setBackground(new Color(255, 255, 255));
		agetxf.setFont(new Font("Tahoma", Font.BOLD, 13));
		agetxf.setBounds(187, 205, 158, 20);
		contentPane.add(agetxf);
		agetxf.setColumns(10);
		
		mobiletxf = new JTextField();
		mobiletxf.setBackground(new Color(255, 255, 255));
		mobiletxf.setFont(new Font("Tahoma", Font.BOLD, 13));
		mobiletxf.setColumns(10);
		mobiletxf.setBounds(187, 244, 158, 20);
		contentPane.add(mobiletxf);
		
		emailtxf = new JTextField();
		emailtxf.setBackground(new Color(255, 255, 255));
		emailtxf.setFont(new Font("Tahoma", Font.BOLD, 13));
		emailtxf.setColumns(10);
		emailtxf.setBounds(187, 290, 158, 20);
		contentPane.add(emailtxf);
		
		usertxf = new JTextField();
		usertxf.setBackground(new Color(255, 255, 255));
		usertxf.setFont(new Font("Tahoma", Font.BOLD, 13));
		usertxf.setColumns(10);
		usertxf.setBounds(187, 335, 158, 20);
		contentPane.add(usertxf);
		
		passtxf = new JPasswordField();
		passtxf.setBackground(new Color(255, 255, 255));
		passtxf.setBounds(187, 379, 158, 20);
		contentPane.add(passtxf);
		
		JButton createbtn = new JButton("CREATE");
		createbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vestine_nyirandikubwimana_ems","222016483","222016483");
					String query="INSERT INTO users VALUES(?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps= conn.prepareStatement(query);
					ps.setInt(1, Integer.parseInt(idtxf.getText()));
					ps.setString(2, nametxf.getText());
					ps.setString(3, postxf.getText());
					if (malerd.isSelected()) 
					ps.setString(4, malerd.getText());		
					else 
						ps.setString(4, femalerd.getText());
					ps.setInt(5,Integer.parseInt(agetxf.getText()));
					ps.setInt(6,Integer.parseInt(mobiletxf.getText()));
					ps.setString(7, emailtxf.getText());
					ps.setString(8, usertxf.getText());
					ps.setString(9, passtxf.getText());
					int i=ps.executeUpdate();
					JOptionPane.showMessageDialog(createbtn, i+"Account Created Successfully!!");
					User us=new User();
					us.User.setVisible(true);
					dispose();
					ps.close();
					con.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		});
		
		createbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		createbtn.setBackground(new Color(97, 188, 237));
		createbtn.setBounds(114, 414, 116, 37);
		contentPane.add(createbtn);
		
		JButton resetbtn = new JButton("RESET");
		resetbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nametxf.setText("");
				postxf.setText("");
				agetxf.setText("");
				mobiletxf.setText("");
				emailtxf.setText("");
				usertxf.setText("");
				passtxf.setText("");
				buttonGroup.clearSelection();
			}
		});
		resetbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		resetbtn.setBackground(new Color(255, 128, 192));
		resetbtn.setBounds(263, 414, 106, 37);
		contentPane.add(resetbtn);
		
		JLabel posil = new JLabel("POSITION");
		posil.setForeground(Color.WHITE);
		posil.setFont(new Font("Tahoma", Font.BOLD, 15));
		posil.setBackground(Color.BLACK);
		posil.setBounds(10, 129, 116, 14);
		contentPane.add(posil);
		
		postxf = new JTextField();
		postxf.setFont(new Font("Tahoma", Font.BOLD, 13));
		postxf.setColumns(10);
		postxf.setBackground(Color.WHITE);
		postxf.setBounds(187, 128, 158, 20);
		contentPane.add(postxf);
		
		JLabel idlb = new JLabel("ID");
		idlb.setForeground(Color.WHITE);
		idlb.setFont(new Font("Tahoma", Font.BOLD, 15));
		idlb.setBackground(Color.BLACK);
		idlb.setBounds(8, 46, 116, 14);
		contentPane.add(idlb);
		
		idtxf = new JTextField();
		idtxf.setFont(new Font("Tahoma", Font.BOLD, 13));
		idtxf.setColumns(10);
		idtxf.setBackground(Color.WHITE);
		idtxf.setBounds(186, 46, 158, 20);
		contentPane.add(idtxf);
		
		JLabel lblNewLabel_1 = new JLabel("CREATE YOUR ACCOUNT");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setForeground(new Color(6, 132, 10));
		lblNewLabel_1.setBounds(19, 6, 402, 24);
		contentPane.add(lblNewLabel_1);
	}
}
