package allforms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class moreviews extends JFrame {

     JPanel contentPane;
	private JTable tabledata;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					moreviews frame = new moreviews();
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
	public moreviews() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 486);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(42, 42, 42));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnListOfProduct = new JButton("LIST OF PRODUCT");
		btnListOfProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/enterprisemanagementsystem","root","");
					Statement stm=con.createStatement();
					String query="Select * from products";
					ResultSet rs =stm.executeQuery(query);
					java.sql.ResultSetMetaData rsmd= rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tabledata.getModel();
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
		btnListOfProduct.setBackground(new Color(77, 77, 77));
		btnListOfProduct.setForeground(new Color(255, 255, 255));
		btnListOfProduct.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnListOfProduct.setBounds(10, 89, 187, 32);
		contentPane.add(btnListOfProduct);
		
		JButton tranctionbtn = new JButton("TRANSCTION REPORT");
		tranctionbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/enterprisemanagementsystem","root","");
					Statement stm=con.createStatement();
					String query="Select * from transction";
					ResultSet rs =stm.executeQuery(query);
					java.sql.ResultSetMetaData rsmd= rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tabledata.getModel();
					int cols=rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String no,name,type,amounts,date;
					while(rs.next()) {
						no=rs.getString(1);
						name=rs.getString(2);
						type=rs.getString(3);
						amounts=rs.getString(4);
						date=rs.getString(5);
						String[] row= {no,name,type,amounts,date};
						model.addRow(row);
					}
					stm.close();
					con.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		});
		tranctionbtn.setBackground(new Color(77, 77, 77));
		tranctionbtn.setForeground(new Color(255, 255, 255));
		tranctionbtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		tranctionbtn.setBounds(10, 196, 187, 32);
		contentPane.add(tranctionbtn);
		
		JButton btnDailyReport = new JButton("CUSTOMER MENU");
		btnDailyReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orders orders=new orders();
				orders.setVisible(true);
				dispose();
			}
		});
		btnDailyReport.setBackground(new Color(77, 77, 77));
		btnDailyReport.setForeground(new Color(255, 255, 255));
		btnDailyReport.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnDailyReport.setBounds(10, 250, 187, 32);
		contentPane.add(btnDailyReport);
		
		JButton alltablebtn = new JButton("VIEW ALL TABLES");
		alltablebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Viewalltables table = new Viewalltables();
				table.setVisible(true);
				dispose();
				
			}
		});
		alltablebtn.setBackground(new Color(77, 77, 77));
		alltablebtn.setForeground(new Color(255, 255, 255));
		alltablebtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		alltablebtn.setBounds(10, 42, 187, 32);
		contentPane.add(alltablebtn);
		
		JButton btnviewSupply = new JButton("VIEW ALL SUPPLIER");
		btnviewSupply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
          try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/enterprisemanagementsystem","root","");
				Statement stm=con.createStatement();
				String query="Select * from supplier";
				ResultSet rs =stm.executeQuery(query);
				java.sql.ResultSetMetaData rsmd= rs.getMetaData();
				DefaultTableModel model=(DefaultTableModel) tabledata.getModel();
				int cols=rsmd.getColumnCount();
				String[] colName=new String[cols];
				for(int i=0; i<cols; i++)
					colName[i]=rsmd.getColumnName(i+1);
				model.setColumnIdentifiers(colName);
				String id,name,pname,unitprice,sellingprice,quantity,paymethods,date;
				while(rs.next()) {
					id=rs.getString(1);
					name=rs.getString(2);
					pname=rs.getString(3);
					unitprice=rs.getString(4);
					sellingprice=rs.getString(5);
					quantity=rs.getString(6);
					paymethods=rs.getString(7);
					date=rs.getString(8);
					String[] row= {id,name,pname,unitprice,sellingprice,quantity,paymethods,date};
					model.addRow(row);
				}
				stm.close();
				con.close();
		} catch (Exception e2) {
			
		}
				
			}
		});
		btnviewSupply.setForeground(new Color(255, 255, 255));
		btnviewSupply.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnviewSupply.setBackground(new Color(77, 77, 77));
		btnviewSupply.setBounds(10, 295, 187, 32);
		contentPane.add(btnviewSupply);
		JScrollPane tbldata = new JScrollPane();
		tbldata.setBounds(207, 42, 480, 377);
		contentPane.add(tbldata);
		
		tabledata = new JTable();
		tbldata.setViewportView(tabledata);
		
		JButton btnClearAll = new JButton("CLEAR ALL");
		btnClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabledata.setModel(new DefaultTableModel());
				
			}
		});
		btnClearAll.setForeground(Color.WHITE);
		btnClearAll.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnClearAll.setBackground(new Color(77, 77, 77));
		btnClearAll.setBounds(10, 387, 187, 32);
		contentPane.add(btnClearAll);
		
		JButton btnBankReport = new JButton("BANK REPORT");
		btnBankReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/enterprisemanagementsystem","root","");
					Statement stm=con.createStatement();
					String query="Select * from bank";
					ResultSet rs =stm.executeQuery(query);
					java.sql.ResultSetMetaData rsmd= rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tabledata.getModel();
					int cols=rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String bank_account,bank_name,transction_name,amounts,date;
					while(rs.next()) {
						bank_account=rs.getString(1);
						bank_name=rs.getString(2);
						transction_name=rs.getString(3);
						amounts=rs.getString(4);
						date=rs.getString(5);
						String[] row= {bank_account,bank_name,transction_name,amounts,date};
						model.addRow(row);
					}
					stm.close();
					con.close();
					
				} catch (Exception e2) {
					
				}
			}
		});
		btnBankReport.setForeground(Color.WHITE);
		btnBankReport.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnBankReport.setBackground(new Color(77, 77, 77));
		btnBankReport.setBounds(10, 344, 187, 32);
		contentPane.add(btnBankReport);
		
		JButton btnSalesReport = new JButton("SALES  REPORT");
		btnSalesReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/enterprisemanagementsystem","root","");
					Statement stm=con.createStatement();
					String query="Select * from customersales";
					ResultSet rs =stm.executeQuery(query);
					ResultSetMetaData rsmd= (ResultSetMetaData) rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tabledata.getModel();
					int cols=rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String customer_id,product_name,customer_name,telephone,order_quantity,payments_methods,date;
					while(rs.next()) {
						customer_id=rs.getString(1);
						product_name=rs.getString(2);
						customer_name=rs.getString(3);
						telephone=rs.getString(4);
						order_quantity=rs.getString(5);
						payments_methods=rs.getString(6);
						date=rs.getString(7);
						String[] row= {customer_id,product_name,customer_name,telephone,order_quantity,payments_methods,date};
						model.addRow(row);
					}
					stm.close();
					con.close();
				} catch (Exception e2) {
					
				}
			}
		});
		btnSalesReport.setForeground(Color.WHITE);
		btnSalesReport.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnSalesReport.setBackground(new Color(77, 77, 77));
		btnSalesReport.setBounds(10, 147, 187, 32);
		contentPane.add(btnSalesReport);
		
		JButton btnNewButton = new JButton("HOME");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admininterface add=new Admininterface();
				 add.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(585, 6, 85, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("VIEW STRUCTURE OF ENTERPRISE  SYSTEM");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 6, 677, 32);
		contentPane.add(lblNewLabel);
	}
}
