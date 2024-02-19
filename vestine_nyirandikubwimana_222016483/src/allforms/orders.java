package allforms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class orders extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orders frame = new orders();
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
	public orders() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 343);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(45, 45, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("VIEW PRODUCT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vestine_nyirandikubwimana_ems","222016483","222016483");
					Statement stm=con.createStatement();
					String query="Select * from products";
					ResultSet rs =stm.executeQuery(query);
					java.sql.ResultSetMetaData rsmd= rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					int cols=rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String id,productname,quantity,unity,price;
					while(rs.next()) {
						id=rs.getString(1);
						productname=rs.getString(2);
						quantity=rs.getString(3);
						unity=rs.getString(4);
						price=rs.getString(5);
						String[] row= {id,productname,quantity,unity,price};
						model.addRow(row);
					}
					stm.close();
					con.close();
					
				} catch (Exception e2) {
					
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 160));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(50, 239, 177, 42);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("LIST OF ALL PRODUCTS AVAILABE");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(10, 11, 414, 27);
		contentPane.add(lblNewLabel);
		
		JScrollPane tb = new JScrollPane();
		tb.setBounds(50, 36, 489, 179);
		contentPane.add(tb);
		
		table = new JTable();
	    tb.setViewportView(table);
		table.setBounds(50, 37, 489, 178);
		
		JButton orderbtn = new JButton("ORDER NOW");
		orderbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerSales cst= new CustomerSales();
				cst.frame.setVisible(true);
				dispose();
			}
		});
		orderbtn.setForeground(new Color(1, 90, 30));
		orderbtn.setFont(new Font("Tahoma", Font.BOLD, 17));
		orderbtn.setBounds(237, 238, 149, 42);
		contentPane.add(orderbtn);
		
		JButton btnNewButton_1 = new JButton("GO HOME");
		btnNewButton_1.setForeground(new Color(0, 166, 166));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Userinterface user=new Userinterface();
				user.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBounds(423, 245, 116, 35);
		contentPane.add(btnNewButton_1);
		
	}
}
