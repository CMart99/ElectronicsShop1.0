package proyecto;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.SystemColor;

/**
 * @version 1.0
 * @author Carlos Martínez Aldayturriaga
 *
 */
public class Home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2117093150817749618L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Home() {
		setResizable(false);
		setTitle("https://www.electronics4everyone.com");
		setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(650, 300, 867, 517);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Update Product");
		btnNewButton.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				UpdateProduct s = new UpdateProduct();
				s.setVisible(true);
				
				
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(532, 116, 198, 34);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Product List");
		btnNewButton_1.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				dispose();
				ProductList p = new ProductList();
				p.setVisible(true);

			}
		});
		btnNewButton_1.setBounds(72, 116, 198, 34);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add Product to Stock");
		btnNewButton_2.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				StockManagement sm = new StockManagement();
				sm.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(72, 179, 198, 34);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Drop From Stock");
		btnNewButton_3.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		btnNewButton_3.setBackground(SystemColor.activeCaption);
		btnNewButton_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				StockDelete sd = new StockDelete();
				sd.setVisible(true);

			}
		});
		btnNewButton_3.setBounds(532, 239, 198, 34);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Sign Out");
		btnNewButton_4.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Login l = new Login();
				l.setVisible(true);
				
			}
		});
		btnNewButton_4.setBackground(SystemColor.activeCaption);
		btnNewButton_4.setBounds(716, 24, 96, 25);
		panel.add(btnNewButton_4);
		
		JTextArea txtrPginaPrincipal = new JTextArea();
		txtrPginaPrincipal.setText("Electronics Shop");
		txtrPginaPrincipal.setForeground(SystemColor.activeCaptionText);
		txtrPginaPrincipal.setFont(new Font("Maiandra GD", Font.BOLD, 34));
		txtrPginaPrincipal.setEditable(false);
		txtrPginaPrincipal.setBackground(SystemColor.activeCaption);
		txtrPginaPrincipal.setBounds(277, 24, 308, 45);
		panel.add(txtrPginaPrincipal);
		
		JButton btnNewButton_5 = new JButton("Account Management");
		btnNewButton_5.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AccountManagement am = new AccountManagement();
				am.setVisible(true);
			}
		});
		btnNewButton_5.setBackground(SystemColor.activeCaption);
		btnNewButton_5.setBounds(72, 239, 198, 34);
		panel.add(btnNewButton_5);
	}
}
