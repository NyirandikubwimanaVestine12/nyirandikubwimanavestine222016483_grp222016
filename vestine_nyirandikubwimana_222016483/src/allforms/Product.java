package allforms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Product extends JFrame {

	private JPanel contentPane;
	private JTextField pidtxf;
	private JTextField pntxf;
	private JTextField qtytxf;
	private JTextField untxf;
	private JTextField sptxf;
	DefaultTableModel mode;
	Object row;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product frame = new Product();
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
	public Product() {
		setTitle("PRODUCTS FORM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 508);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(31, 31, 31));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LIST OF ALL PRODUCTS WE HAVE IN STOCK");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 720, 35);
		contentPane.add(lblNewLabel);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 38, 328, 390);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("PRODUCT  FORM");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(2, 0, 308, 25);
		panel.add(lblNewLabel_1);
		
		JLabel pidlb = new JLabel("Product Id:");
		pidlb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		pidlb.setBounds(12, 52, 108, 25);
		panel.add(pidlb);
		
		JLabel pnlb = new JLabel("Product Name:");
		pnlb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		pnlb.setBounds(12, 90, 122, 25);
		panel.add(pnlb);
		
		JLabel qtylb = new JLabel("Quantity:");
		qtylb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		qtylb.setBounds(12, 139, 108, 25);
		panel.add(qtylb);
		
		JLabel unlb = new JLabel("Unity:");
		unlb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		unlb.setBounds(12, 187, 108, 25);
		panel.add(unlb);
		
		JLabel splb = new JLabel("Selling Price:");
		splb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		splb.setBounds(12, 240, 108, 25);
		panel.add(splb);
		pidtxf = new JTextField();
		pidtxf.setFont(new Font("Tahoma", Font.BOLD, 15));
		pidtxf.setBounds(150, 51, 150, 25);
		panel.add(pidtxf);
		pidtxf.setColumns(10);
		
		pntxf = new JTextField();
		pntxf.setFont(new Font("Tahoma", Font.BOLD, 15));
		pntxf.setColumns(10);
		pntxf.setBounds(148, 94, 150, 25);
		panel.add(pntxf);
		
		qtytxf = new JTextField();
		qtytxf.setFont(new Font("Tahoma", Font.BOLD, 15));
		qtytxf.setColumns(10);
		qtytxf.setBounds(150, 143, 150, 25);
		panel.add(qtytxf);
		
		untxf = new JTextField();
		untxf.setFont(new Font("Tahoma", Font.BOLD, 15));
		untxf.setColumns(10);
		untxf.setBounds(148, 191, 150, 25);
		panel.add(untxf);
		
		sptxf = new JTextField();
		sptxf.setFont(new Font("Tahoma", Font.BOLD, 15));
		sptxf.setColumns(10);
		sptxf.setBounds(148, 240, 150, 25);
		panel.add(sptxf);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(344, 38, 451, 390);
		contentPane.add(scrollPane);
		
		JTable tt = new JTable();
		tt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=tt.getSelectedRow();
				pidtxf.setText(mode.getValueAt(i, 0).toString());
				pntxf.setText(mode.getValueAt(i, 1).toString());
				qtytxf.setText(mode.getValueAt(i, 2).toString());
				untxf.setText(mode.getValueAt(i, 3).toString());
				sptxf.setText(mode.getValueAt(i, 4).toString());
			}
		});
		scrollPane.setViewportView(tt);
		tt.setBackground(new Color(255, 255, 255));
		mode=new DefaultTableModel();
		Object[] column={"ID","NAME","QUANTITY","UNITY","PRICE"};
		Object[] row= new Object[5];
		mode.setColumnIdentifiers(column);
		tt.setModel(mode);
		JButton addbtn = new JButton("ADD");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/vestine_nyirandikubwimana_ems","222016483","222016483");
					String query="INSERT INTO products VALUES(?,?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setInt(1, Integer.parseInt(pidtxf.getText()));
					pst.setString(2, pntxf.getText());
					pst.setInt(3, Integer.parseInt(qtytxf.getText()));
					pst.setString(4, untxf.getText());
					pst.setInt(5, Integer.parseInt(sptxf.getText()));
					pst.executeUpdate();
					
					if(pidtxf.getText().equals("")|| pntxf.getText().equals("")|| qtytxf.getText().equals("")||untxf.getText().equals("")||sptxf.getText().equals(""))
					{
					JOptionPane.showMessageDialog(null, "Please Fill Complete Information!!");	
					}
					else {
					row[0]=pidtxf.getText();
					row[1]=pntxf.getText();
					row[2]=qtytxf.getText();
					row[3]=untxf.getText();
					row[4]=sptxf.getText();
					
					pidtxf.setText(null);
					pntxf.setText(null);
					qtytxf.setText(null);
					untxf.setText(null);
					sptxf.setText(null);
					mode.addRow(row);
					JOptionPane.showMessageDialog(null, "Saved Successfully!!");	
					}	
					
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}			
			}
		});
		
		addbtn.setForeground(new Color(0, 0, 187));
		addbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		addbtn.setBounds(10, 291, 94, 40);
		panel.add(addbtn);
		
		JButton editbtn = new JButton("EDIT");
		editbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/vestine_nyirandikubwimana_ems","222016483","222016483");
					String query=" UPDATE products SET product_name=?, quantity=?, unity=?, selling_price=? WHERE product_id=? ";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, pntxf.getText());
					pst.setString(2,qtytxf.getText());
					pst.setString(3, untxf.getText());
					pst.setString(4,sptxf.getText());
					pst.setString(5, pidtxf.getText());
					pst.executeUpdate();
					int i=tt.getSelectedRow();
					if (i>=0) {
						mode.setValueAt(pidtxf.getText(), i, 0);
						mode.setValueAt(pntxf.getText(), i, 1);
						mode.setValueAt(qtytxf.getText(), i, 2);
						mode.setValueAt(untxf.getText(), i, 3);
						mode.setValueAt(sptxf.getText(), i, 4);
						pidtxf.setText(null);
						pntxf.setText(null);
						qtytxf.setText(null);
						untxf.setText(null);
						sptxf.setText(null);
						JOptionPane.showMessageDialog(null, "Updated Successfully!!");	
					}
					else {
						JOptionPane.showMessageDialog(null, "Please Select Any Row Want to Update !!");	
					}
					
				} catch (Exception e2) {
				 System.out.println(e2.getMessage());
				}
			}
		});
		editbtn.setForeground(new Color(15, 164, 11));
		editbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		editbtn.setBounds(114, 292, 94, 38);
		panel.add(editbtn);
		
		JButton deletebtn = new JButton("DELETE");
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/vestine_nyirandikubwimana_ems","222016483","222016483");
					String query="DELETE FROM products WHERE product_id=? ";
					PreparedStatement pStatement=connection.prepareStatement(query);
					pStatement.setString(1, pidtxf.getText());
					pStatement.executeUpdate();
					int i=tt.getSelectedRow();
					if (i>=0) {
						mode.removeRow(i);
						pidtxf.setText(null);
						pntxf.setText(null);
						qtytxf.setText(null);
						untxf.setText(null);
						sptxf.setText(null);
						JOptionPane.showMessageDialog(null, "Deleted Successfully!!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Please Select Row Want to Delete");
					}
				} catch (Exception e2) {
					
					
				}
			}
		});
		deletebtn.setForeground(new Color(168, 0, 0));
		deletebtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		deletebtn.setBounds(12, 342, 94, 38);
		panel.add(deletebtn);
		
		JButton viewbtn = new JButton("VIEW");
		viewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vestine_nyirandikubwimana_ems","222016483","222016483");
					Statement stm=con.createStatement();
					String query="Select * from products";
					ResultSet rs =stm.executeQuery(query);
					java.sql.ResultSetMetaData rsmd= rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tt.getModel();
					int cols=rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String id,name,quantity,unity,price;
					while(rs.next()) {
						id=rs.getString(1);
						name=rs.getString(2);
						quantity=rs.getString(3);
						unity=rs.getString(4);
						price=rs.getString(5);
						String[] row= {id,name,quantity,unity,price};
						model.addRow(row);
					}
					stm.close();
					con.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}

				
			}
		});
		viewbtn.setForeground(new Color(221, 21, 191));
		viewbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		viewbtn.setBounds(218, 292, 94, 38);
		panel.add(viewbtn);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Viewalltables more=new Viewalltables();
				more.setVisible(true);
			   dispose();
			}
		});
		btnNewButton.setForeground(new Color(128, 0, 128));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(124, 346, 94, 34);
		panel.add(btnNewButton);
		
	}
}
