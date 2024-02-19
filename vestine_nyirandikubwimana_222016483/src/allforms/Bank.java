package allforms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Bank {

	 JFrame frame;
	private JTextField batxf;
	private JTextField bntxf;
	private JTextField tntxf;
	private JTextField amtxf;
	private JTextField datetxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bank window = new Bank();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Bank() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("BANK FORM");
		frame.getContentPane().setBackground(new Color(135, 168, 134));
		frame.setBounds(100, 100, 480, 399);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel bank = new JLabel("BANK   FORM");
		bank.setForeground(new Color(255, 255, 255));
		bank.setFont(new Font("Times New Roman", Font.BOLD, 25));
		bank.setHorizontalAlignment(SwingConstants.CENTER);
		bank.setBounds(10, 0, 444, 34);
		frame.getContentPane().add(bank);
		
		JLabel balb = new JLabel("Bank_Account");
		balb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		balb.setBounds(10, 67, 137, 31);
		frame.getContentPane().add(balb);
		
		JLabel bnlb = new JLabel("Bank_Name");
		bnlb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		bnlb.setBounds(10, 109, 137, 34);
		frame.getContentPane().add(bnlb);
		
		JLabel tnlb = new JLabel("Transction_Name");
		tnlb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		tnlb.setBounds(10, 154, 137, 33);
		frame.getContentPane().add(tnlb);
		
		JLabel amlb = new JLabel("Amounts");
		amlb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		amlb.setBounds(10, 198, 137, 34);
		frame.getContentPane().add(amlb);
		
		JLabel datelb = new JLabel("Date");
		datelb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		datelb.setBounds(10, 243, 137, 32);
		frame.getContentPane().add(datelb);
		
		JButton sendbtn = new JButton("SEND");
		sendbtn.setForeground(new Color(255, 255, 255));
		sendbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verify(4);
				JOptionPane.showMessageDialog(sendbtn,"Record Added Successfully!!!" );
			}
		});
		sendbtn.setBackground(new Color(43, 43, 255));
		sendbtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		sendbtn.setBounds(6, 300, 89, 42);
		frame.getContentPane().add(sendbtn);
		
		JButton modifybtn = new JButton("MODIFY");
		modifybtn.setForeground(new Color(0, 0, 0));
		modifybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verify(3);
				JOptionPane.showMessageDialog(modifybtn, "Updated successfully!!");
				
				
			}
		});
		modifybtn.setBackground(new Color(145, 200, 255));
		modifybtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		modifybtn.setBounds(120, 300, 103, 42);
		frame.getContentPane().add(modifybtn);
		
		batxf = new JTextField();
		batxf.setFont(new Font("Tahoma", Font.BOLD, 12));
		batxf.setBounds(170, 64, 180, 34);
		frame.getContentPane().add(batxf);
		batxf.setColumns(10);
		
		bntxf = new JTextField();
		bntxf.setFont(new Font("Tahoma", Font.BOLD, 12));
		bntxf.setColumns(10);
		bntxf.setBounds(170, 112, 180, 31);
		frame.getContentPane().add(bntxf);
		
		tntxf = new JTextField();
		tntxf.setFont(new Font("Tahoma", Font.BOLD, 12));
		tntxf.setColumns(10);
		tntxf.setBounds(170, 157, 180, 30);
		frame.getContentPane().add(tntxf);
		
		amtxf = new JTextField();
		amtxf.setFont(new Font("Tahoma", Font.BOLD, 12));
		amtxf.setColumns(10);
		amtxf.setBounds(170, 201, 180, 31);
		frame.getContentPane().add(amtxf);
		
		datetxf = new JTextField();
		datetxf.setFont(new Font("Tahoma", Font.BOLD, 12));
		datetxf.setColumns(10);
		datetxf.setBounds(170, 246, 180, 29);
		frame.getContentPane().add(datetxf);
		
		JButton deletbtn = new JButton("DELETE");
		deletbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verify(1);
				JOptionPane.showMessageDialog(deletbtn, "Data Deleted successfully!!");
			}
		});
		deletbtn.setForeground(new Color(0, 0, 0));
		deletbtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		deletbtn.setBackground(new Color(235, 5, 39));
		deletbtn.setBounds(253, 300, 89, 42);
		frame.getContentPane().add(deletbtn);
		
		JButton searchbtn = new JButton("Search");
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verify(2);
				
			}
		});
		searchbtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		searchbtn.setForeground(new Color(0, 0, 255));
		searchbtn.setBounds(358, 67, 104, 34);
		frame.getContentPane().add(searchbtn);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Viewalltables more=new Viewalltables();
				more.setVisible(true);
			   frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setBounds(352, 301, 89, 42);
		frame.getContentPane().add(btnNewButton);
	}
	public void verify(int value) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vestine_nyirandikubwimana_ems","222016483","222016483");
			switch (value) {
			case 1: {
				String query="DELETE FROM bank WHERE bank_account=?";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1, batxf.getText());
				pst.executeUpdate();
				batxf.setText(null);
				bntxf.setText(null);
				tntxf.setText(null);
				amtxf.setText(null);
				datetxf.setText(null);
				break;
			}
			case 2:{
				String query="SELECT *  FROM bank WHERE bank_account=?";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1, batxf.getText());
				ResultSet rs=pst.executeQuery();
				if (rs.next()==false) {
					JOptionPane.showMessageDialog(null,"Please, enter your Account");
					
				}
				else {
					bntxf.setText(rs.getString(2));
					tntxf.setText(rs.getString(3));
					amtxf.setText(rs.getString(4));
					datetxf.setText(rs.getString(5));
				}
				break;
				
			}
			case 3:{
				String query=" UPDATE bank SET  bank_name=?, transaction_name=?, amounts=?,date=? WHERE  bank_account=?";
				PreparedStatement stm=con.prepareStatement(query);
				stm.setString(1, bntxf.getText());
				stm.setString(2, tntxf.getText());
				stm.setString(3, amtxf.getText());
				stm.setString(4, datetxf.getText());
				stm.setString(5, batxf.getText());
				stm.executeUpdate();
				batxf.setText(null);
				bntxf.setText(null);
				tntxf.setText(null);
				amtxf.setText(null);
				datetxf.setText(null);
				break;
			}
			case 4:{
				String query="INSERT INTO bank VALUES(?,?,?,?,?)";
				PreparedStatement stm=con.prepareStatement(query);
				stm.setString(1, batxf.getText());
				stm.setString(2, bntxf.getText());
				stm.setString(3, tntxf.getText());
				stm.setInt(4, Integer.parseInt(amtxf.getText()));
				stm.setString(5, datetxf.getText());
				stm.executeUpdate();
				batxf.setText(null);
				bntxf.setText(null);
				tntxf.setText(null);
				amtxf.setText(null);
				datetxf.setText(null);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + value);
			}
			con.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
