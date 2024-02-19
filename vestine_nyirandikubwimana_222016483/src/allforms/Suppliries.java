package allforms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Suppliries {

	JFrame frame;
	private JTextField sidtxf;
	private JTextField sntxf;
	private JTextField pntxf;
	private JTextField uptxf;
	private JTextField sptxf;
	private JTextField qtytxf;
	private JTextField pmtxf;
	private JTextField datetxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Suppliries window = new Suppliries();
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
	public Suppliries() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 168, 134));
		frame.setTitle("SUPPLIERS FORM");
		frame.setBounds(100, 100, 671, 411);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("FILL SUPPLIERS  FORMS");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBackground(new Color(0, 0, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 553, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel sidlb = new JLabel("Supply_id");
		sidlb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		sidlb.setBounds(20, 48, 211, 25);
		frame.getContentPane().add(sidlb);
		
		JLabel snlb = new JLabel("Supply_Name");
		snlb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		snlb.setBounds(20, 79, 211, 21);
		frame.getContentPane().add(snlb);
		
		JLabel pnlb = new JLabel("Product_Name");
		pnlb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		pnlb.setBounds(20, 111, 211, 19);
		frame.getContentPane().add(pnlb);
		
		JLabel uplb = new JLabel("Unit_Price");
		uplb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		uplb.setBounds(20, 141, 211, 19);
		frame.getContentPane().add(uplb);
		
		JLabel splb = new JLabel("Selling Price");
		splb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		splb.setBounds(20, 171, 211, 25);
		frame.getContentPane().add(splb);
		
		JLabel qtylb = new JLabel("Quantity");
		qtylb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		qtylb.setBounds(20, 202, 211, 20);
		frame.getContentPane().add(qtylb);
		
		JLabel pmlb = new JLabel("Payment_Methods");
		pmlb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		pmlb.setBounds(20, 233, 211, 21);
		frame.getContentPane().add(pmlb);
		
		JLabel datelb = new JLabel("Date");
		datelb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		datelb.setBounds(20, 265, 211, 14);
		frame.getContentPane().add(datelb);
		
		sidtxf = new JTextField();
		sidtxf.setFont(new Font("Tahoma", Font.BOLD, 11));
		sidtxf.setBounds(227, 52, 316, 20);
		frame.getContentPane().add(sidtxf);
		sidtxf.setColumns(10);
		
		sntxf = new JTextField();
		sntxf.setFont(new Font("Tahoma", Font.BOLD, 11));
		sntxf.setColumns(10);
		sntxf.setBounds(227, 78, 316, 20);
		frame.getContentPane().add(sntxf);
		
		pntxf = new JTextField();
		pntxf.setFont(new Font("Tahoma", Font.BOLD, 11));
		pntxf.setColumns(10);
		pntxf.setBounds(227, 107, 316, 20);
		frame.getContentPane().add(pntxf);
		
		uptxf = new JTextField();
		uptxf.setFont(new Font("Tahoma", Font.BOLD, 11));
		uptxf.setColumns(10);
		uptxf.setBounds(227, 139, 316, 20);
		frame.getContentPane().add(uptxf);
		
		sptxf = new JTextField();
		sptxf.setFont(new Font("Tahoma", Font.BOLD, 11));
		sptxf.setColumns(10);
		sptxf.setBounds(227, 171, 316, 20);
		frame.getContentPane().add(sptxf);
		
		qtytxf = new JTextField();
		qtytxf.setFont(new Font("Tahoma", Font.BOLD, 11));
		qtytxf.setColumns(10);
		qtytxf.setBounds(227, 202, 316, 20);
		frame.getContentPane().add(qtytxf);
		
		pmtxf = new JTextField();
		pmtxf.setFont(new Font("Tahoma", Font.BOLD, 11));
		pmtxf.setColumns(10);
		pmtxf.setBounds(227, 232, 316, 20);
		frame.getContentPane().add(pmtxf);
		
		datetxf = new JTextField();
		datetxf.setFont(new Font("Tahoma", Font.BOLD, 11));
		datetxf.setColumns(10);
		datetxf.setBounds(227, 263, 316, 20);
		frame.getContentPane().add(datetxf);
		
		JButton submbtn = new JButton("ADD");
		submbtn.setForeground(new Color(255, 255, 255));
		submbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vestine_nyirandikubwimana_ems","222016483","222016483");
					String query="INSERT INTO supplier VALUES(?,?,?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setInt(1, Integer.parseInt(sidtxf.getText()));
					ps.setString(2, sntxf.getText());
					ps.setString(3, pntxf.getText());
					ps.setInt(4, Integer.parseInt(uptxf.getText()));
					ps.setInt(5, Integer.parseInt(sptxf.getText()));
					ps.setInt(6, Integer.parseInt(qtytxf.getText()));
					ps.setString(7, pmtxf.getText());
					ps.setString(8, datetxf.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(submbtn, "Supply added Successfully!!");
					sidtxf.setText(null);
					sntxf.setText(null);
					pntxf.setText(null);
					uptxf.setText(null);
					sptxf.setText(null);
					qtytxf.setText(null);
					pmtxf.setText(null);
					datetxf.setText(null);
					ps.close();
					con.close();

				} catch (Exception e2) {
					e2.getMessage();
					
				}
			}
		});
		submbtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		submbtn.setBackground(new Color(0, 0, 128));
		submbtn.setBounds(138, 307, 97, 39);
		frame.getContentPane().add(submbtn);
		
		JButton deletebtn = new JButton("DELETE");
		deletebtn.setForeground(new Color(255, 255, 255));
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vestine_nyirandikubwimana_ems","222016483","222016483");
						String query="DELETE FROM supplier WHERE supply_id=?";
						PreparedStatement pst=con.prepareStatement(query);
						pst.setString(1, sidtxf.getText());
						pst.executeUpdate();
						JOptionPane.showMessageDialog(deletebtn, "RecordOut Successfully!!");
						sidtxf.setText(null);
						sntxf.setText(null);
						pntxf.setText(null);
						uptxf.setText(null);
						sptxf.setText(null);
						qtytxf.setText(null);
						pmtxf.setText(null);
						datetxf.setText(null);
				} catch (Exception e2) {
					
				}
			}
		});
		deletebtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		deletebtn.setBackground(new Color(128, 0, 0));
		deletebtn.setBounds(370, 308, 119, 37);
		frame.getContentPane().add(deletebtn);
		
		JButton backbtn = new JButton("BACK");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Viewalltables more=new Viewalltables();
				more.setVisible(true);
			   frame.dispose();
				
			}
		});
		backbtn.setForeground(new Color(0, 0, 255));
		backbtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		backbtn.setBackground(new Color(255, 255, 255));
		backbtn.setBounds(505, 307, 97, 39);
		frame.getContentPane().add(backbtn);
		
		JButton findbtn = new JButton("FIND");
		findbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vestine_nyirandikubwimana_ems","222016483","222016483");
				String query="SELECT *  FROM supplier WHERE supply_id=?";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1, sidtxf.getText());
				ResultSet rs=pst.executeQuery();
				if (rs.next()==false) {
					JOptionPane.showMessageDialog(null,"Please, enter supply id want to update");
					
				}
				else {
					sntxf.setText(rs.getString(2));
					pntxf.setText(rs.getString(3));
					uptxf.setText(rs.getString(4));
					sptxf.setText(rs.getString(5));
					qtytxf.setText(rs.getString(6));
					pmtxf.setText(rs.getString(7));
					datetxf.setText(rs.getString(8));
				}
			} catch (Exception e2) {
				
			}	
			}
		});
		findbtn.setForeground(new Color(0, 0, 255));
		findbtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		findbtn.setBounds(548, 47, 97, 39);
		frame.getContentPane().add(findbtn);
		
		JButton btnChange = new JButton("CHANGE");
		btnChange.setForeground(new Color(255, 255, 255));
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vestine_nyirandikubwimana_ems","222016483","222016483");
					String query=" UPDATE supplier SET  supply_name=?, product_name=?, unitprice=?, sellingprice=?, quantity=?, paymentsmethod=?, date=? WHERE supply_id=?";
					PreparedStatement stm=con.prepareStatement(query);
					stm.setString(1, sntxf.getText());
					stm.setString(2, pntxf.getText());
					stm.setString(3, uptxf.getText());
					stm.setString(4, sptxf.getText());
					stm.setString(5, qtytxf.getText());
					stm.setString(6, pmtxf.getText());
					stm.setString(7, datetxf.getText());
					stm.setString(8, sidtxf.getText());
					stm.executeUpdate();
					sidtxf.setText(null);
					sntxf.setText(null);
					pntxf.setText(null);
					pmtxf.setText(null);
					uptxf.setText(null);
					sptxf.setText(null);
					qtytxf.setText(null);
					datetxf.setText(null);
					JOptionPane.showMessageDialog(btnChange, "Updated Successfully!!!!!!!!!!!");
				} catch (Exception e2) {
					
				}
				
			}
		});
		btnChange.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnChange.setBackground(new Color(0, 128, 0));
		btnChange.setBounds(259, 307, 97, 39);
		frame.getContentPane().add(btnChange);
	}
}
