package allforms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Transction {

	 JFrame frame;
	private JTextField tnotxf;
	private JTextField tntxf;
	private JTextField ttytxf;
	private JTextField amtxf;
	private JTextField datetxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transction window = new Transction();
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
	public Transction() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.setTitle("Transction form");
		frame.getContentPane().setBackground(new Color(135, 168, 134));
		frame.setBounds(100, 100, 470, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TRANSCTION  FORM");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(3, 3, 441, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel tnolb = new JLabel("Transction_no");
		tnolb.setHorizontalAlignment(SwingConstants.CENTER);
		tnolb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		tnolb.setBounds(1, 57, 155, 32);
		frame.getContentPane().add(tnolb);
		
		JLabel tnlb = new JLabel("Transction_name");
		tnlb.setHorizontalAlignment(SwingConstants.CENTER);
		tnlb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		tnlb.setBounds(1, 106, 155, 31);
		frame.getContentPane().add(tnlb);
		
		JLabel ttylb = new JLabel("Transction_Type");
		ttylb.setHorizontalAlignment(SwingConstants.CENTER);
		ttylb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		ttylb.setBounds(1, 153, 155, 29);
		frame.getContentPane().add(ttylb);
		
		JLabel amlb = new JLabel("Amounts");
		amlb.setHorizontalAlignment(SwingConstants.CENTER);
		amlb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		amlb.setBounds(0, 195, 156, 29);
		frame.getContentPane().add(amlb);
		
		JLabel datelb = new JLabel("Date");
		datelb.setHorizontalAlignment(SwingConstants.CENTER);
		datelb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		datelb.setBounds(3, 236, 153, 28);
		frame.getContentPane().add(datelb);
		
		tnotxf = new JTextField();
		tnotxf.setFont(new Font("Tahoma", Font.BOLD, 14));
		tnotxf.setBounds(167, 55, 255, 34);
		frame.getContentPane().add(tnotxf);
		tnotxf.setColumns(10);
		
		tntxf = new JTextField();
		tntxf.setFont(new Font("Tahoma", Font.BOLD, 14));
		tntxf.setColumns(10);
		tntxf.setBounds(167, 104, 255, 33);
		frame.getContentPane().add(tntxf);
		
		ttytxf = new JTextField();
		ttytxf.setFont(new Font("Tahoma", Font.BOLD, 14));
		ttytxf.setColumns(10);
		ttytxf.setBounds(167, 151, 255, 31);
		frame.getContentPane().add(ttytxf);
		
		amtxf = new JTextField();
		amtxf.setFont(new Font("Tahoma", Font.BOLD, 14));
		amtxf.setColumns(10);
		amtxf.setBounds(167, 193, 255, 31);
		frame.getContentPane().add(amtxf);
		
		datetxf = new JTextField();
		datetxf.setFont(new Font("Tahoma", Font.BOLD, 14));
		datetxf.setColumns(10);
		datetxf.setBounds(167, 234, 255, 30);
		frame.getContentPane().add(datetxf);
		
		JButton savebtn = new JButton("SAVE");
		savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql:// localhost:3306/vestine_nyirandikubwimana_ems","222016483","222016483");
					String query="INSERT INTO  transction VALUES(?,?,?,?,?)";
					PreparedStatement ps= con.prepareStatement(query);
					ps.setInt(1, Integer.parseInt(tnotxf.getText()));
					ps.setString(2, tntxf.getText());
					ps.setString(3, ttytxf.getText());
					ps.setString(4, amtxf.getText());
					ps.setString(5, datetxf.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(savebtn, "transction saved successfully");
					tnotxf.setText(null);
					tntxf.setText(null);
					ttytxf.setText(null);
					amtxf.setText(null);
					datetxf.setText(null);
					ps.close();
					con.close();
				} catch (Exception e2) {
					
				}
			}
		});
		savebtn.setBackground(new Color(145, 200, 255));
		savebtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		savebtn.setBounds(15, 284, 89, 43);
		frame.getContentPane().add(savebtn);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tnotxf.setText("");
				tntxf.setText("");
				ttytxf.setText("");
				amtxf.setText("");
				datetxf.setText(null);
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnClear.setBackground(new Color(255, 187, 187));
		btnClear.setBounds(244, 283, 89, 44);
		frame.getContentPane().add(btnClear);
		
		JButton deletebtn = new JButton("DELETE");
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vestine_nyirandikubwimana_ems","222016483","222016483");
				String query="DELETE FROM transction WHERE transction_no=?";
				int tnotxf=Integer.parseInt(JOptionPane.showInputDialog( "Enter the number of transction wants to delete"));
				PreparedStatement stm=con.prepareStatement(query);
				stm.setInt(1, tnotxf);
				JOptionPane.showMessageDialog(deletebtn, "Record out!!!!!!!!");
				stm.executeUpdate();
				stm.close();
				con.close();
				
			} catch (Exception e2) {
				
			}	
			}
		});
		deletebtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		deletebtn.setBackground(new Color(183, 18, 0));
		deletebtn.setBounds(120, 284, 114, 43);
		frame.getContentPane().add(deletebtn);
		
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
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(342, 286, 97, 42);
		frame.getContentPane().add(btnNewButton);
	}
}
