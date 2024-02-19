package allforms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Viewalltables extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viewalltables frame = new Viewalltables();
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
	public Viewalltables() {
		setTitle("ALL TABLES FORM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 327);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(22, 22, 22));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel alltablelb = new JLabel("ALL TABLES IN  SYSTEM");
		alltablelb.setHorizontalAlignment(SwingConstants.CENTER);
		alltablelb.setForeground(new Color(255, 255, 255));
		alltablelb.setFont(new Font("Times New Roman", Font.BOLD, 22));
		alltablelb.setBounds(10, 11, 514, 34);
		contentPane.add(alltablelb);
		
		JButton productbtn = new JButton("PRODUCTS");
		productbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product pro= new Product();
				pro.setVisible(true);
				dispose();
			}
		});
		productbtn.setFont(new Font("Times New Roman", Font.BOLD, 17));
		productbtn.setForeground(new Color(0, 0, 128));
		productbtn.setBounds(74, 56, 132, 44);
		contentPane.add(productbtn);
		
		JButton supplierbtn = new JButton("SUPPLIERS");
		supplierbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Suppliries spy= new Suppliries();
				spy.frame.setVisible(true);
				dispose();	
			}
		});
		supplierbtn.setFont(new Font("Times New Roman", Font.BOLD, 17));
		supplierbtn.setForeground(new Color(0, 0, 128));
		supplierbtn.setBounds(74, 127, 132, 44);
		contentPane.add(supplierbtn);
		
		JButton transbtn = new JButton("TRANSCTIONS");
		transbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transction spy= new Transction();
				spy.frame.setVisible(true);
				dispose();
			}
		});
		transbtn.setFont(new Font("Times New Roman", Font.BOLD, 17));
		transbtn.setForeground(new Color(0, 0, 128));
		transbtn.setBounds(292, 127, 183, 44);
		contentPane.add(transbtn);
		
		JButton salesbtn = new JButton("CUSTOMER SALES");
		salesbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerSales spy= new CustomerSales();
				spy.frame.setVisible(true);
				dispose();
			}
		});
		salesbtn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		salesbtn.setForeground(new Color(0, 0, 128));
		salesbtn.setBounds(292, 56, 183, 44);
		contentPane.add(salesbtn);
		
		JButton bankbtn = new JButton("BANKS");
		bankbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bank bk= new Bank();
				bk.frame.setVisible(true);
				dispose();
				
			}
		});
		bankbtn.setFont(new Font("Times New Roman", Font.BOLD, 17));
		bankbtn.setForeground(new Color(0, 0, 128));
		bankbtn.setBounds(74, 205, 132, 44);
		contentPane.add(bankbtn);
		
		JButton backbtn = new JButton("GO BACK");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moreviews more= new moreviews();
				more.setVisible(true);
				dispose();
				
			}
		});
		backbtn.setFont(new Font("Times New Roman", Font.BOLD, 17));
		backbtn.setForeground(new Color(255, 0, 0));
		backbtn.setBounds(292, 205, 183, 44);
		contentPane.add(backbtn);
	}
}
