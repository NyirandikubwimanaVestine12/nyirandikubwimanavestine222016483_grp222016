package allforms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class CustomerSales {

	JFrame frame;
	private JTextField citxf;
	private JTextField cntxf;
	private JTextField teltxf;
	private JTextField orqtytxf;
	private JTextField pmtxf;
	private JTextField datxf;
	private JLabel cilb;
	private JTextField pntxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	 EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerSales window = new CustomerSales();
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
	public CustomerSales() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("customer sales form");
		frame.getContentPane().setBackground(new Color(135, 168, 134));
		frame.setBounds(100, 100, 521, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CUSTOMER SALES");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(8, 2, 480, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel pnlb = new JLabel("Product_Name");
		pnlb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		pnlb.setBounds(8, 102, 191, 25);
		frame.getContentPane().add(pnlb);
		
		cilb = new JLabel("Customer_Id");
		cilb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		cilb.setBounds(8, 52, 191, 25);
		frame.getContentPane().add(cilb);
		
		JLabel cnlb = new JLabel("Customer_Name");
		cnlb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		cnlb.setBounds(8, 156, 191, 25);
		frame.getContentPane().add(cnlb);
		
		JLabel telb = new JLabel("Telehone");
		telb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		telb.setBounds(8, 192, 191, 25);
		frame.getContentPane().add(telb);
		
		JLabel orqtylb = new JLabel("Order_Quantity");
		orqtylb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		orqtylb.setBounds(8, 241, 191, 25);
		frame.getContentPane().add(orqtylb);
		
		JLabel pmlb = new JLabel("Payment_Methods");
		pmlb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		pmlb.setBounds(8, 303, 191, 25);
		frame.getContentPane().add(pmlb);
		
		JLabel datlb = new JLabel("Date");
		datlb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		datlb.setBounds(8, 342, 191, 25);
		frame.getContentPane().add(datlb);
		
		JButton salebtn = new JButton("SALE");
		salebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vestine_nyirandikubwimana_ems","222016483","222016483");
					String query="INSERT INTO customersales VALUES(?,?,?,?,?,?,?)";
					PreparedStatement stm=con.prepareStatement(query);
					stm.setInt(1, Integer.parseInt(citxf.getText()));
					stm.setString(2, pntxf.getText());
					stm.setString(3, cntxf.getText());
					stm.setString(4, teltxf.getText());
					stm.setInt(5, Integer.parseInt(orqtytxf.getText()));
					stm.setString(6, pmtxf.getText());
					stm.setString(7, datxf.getText());
					stm.executeUpdate();
					JOptionPane.showMessageDialog(salebtn, "order Successfully");
					citxf.setText(null);
					pntxf.setText(null);
					cntxf.setText(null);
					teltxf.setText(null);
					orqtytxf.setText(null);
					pmtxf.setText(null);
					datxf.setText(null);
					stm.close();
					con.close();
				} catch (Exception e2) {
					
				}
			}
		});
		salebtn.setBackground(new Color(145, 200, 255));
		salebtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		salebtn.setBounds(90, 393, 99, 35);
		frame.getContentPane().add(salebtn);
		
		citxf = new JTextField();
		citxf.setFont(new Font("Tahoma", Font.BOLD, 16));
		citxf.setBounds(221, 49, 267, 35);
		frame.getContentPane().add(citxf);
		citxf.setColumns(10);
		
		cntxf = new JTextField();
		cntxf.setFont(new Font("Tahoma", Font.BOLD, 16));
		cntxf.setColumns(10);
		cntxf.setBounds(221, 146, 267, 35);
		frame.getContentPane().add(cntxf);
		
		teltxf = new JTextField();
		teltxf.setFont(new Font("Tahoma", Font.BOLD, 16));
		teltxf.setColumns(10);
		teltxf.setBounds(221, 195, 267, 35);
		frame.getContentPane().add(teltxf);
		
		orqtytxf = new JTextField();
		orqtytxf.setFont(new Font("Tahoma", Font.BOLD, 16));
		orqtytxf.setColumns(10);
		orqtytxf.setBounds(221, 244, 267, 35);
		frame.getContentPane().add(orqtytxf);
		
		pmtxf = new JTextField();
		pmtxf.setFont(new Font("Tahoma", Font.BOLD, 16));
		pmtxf.setColumns(10);
		pmtxf.setBounds(221, 293, 267, 35);
		frame.getContentPane().add(pmtxf);
		
		datxf = new JTextField();
		datxf.setFont(new Font("Tahoma", Font.BOLD, 16));
		datxf.setColumns(10);
		datxf.setBounds(221, 339, 267, 35);
		frame.getContentPane().add(datxf);
		
		JButton clearbtn = new JButton("CLEAR");
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				citxf.setText(null);
				pntxf.setText(null);
				cntxf.setText(null);
				teltxf.setText(null);
				orqtytxf.setText(null);
				pmtxf.setText(null);
				datxf.setText(null);
			}
		});
		clearbtn.setBackground(new Color(255, 187, 187));
		clearbtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		clearbtn.setBounds(221, 393, 99, 35);
		frame.getContentPane().add(clearbtn);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orders more=new orders();
				more.setVisible(true);
			   frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setBounds(353, 393, 105, 35);
		frame.getContentPane().add(btnNewButton);
		
		pntxf = new JTextField();
		pntxf.setFont(new Font("Tahoma", Font.BOLD, 16));
		pntxf.setBounds(221, 99, 267, 35);
		frame.getContentPane().add(pntxf);
		pntxf.setColumns(10);
	}
}
