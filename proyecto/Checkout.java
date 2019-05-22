package proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import java.awt.SystemColor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Checkout extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField name;
	private JTextField address;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checkout frame = new Checkout();
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
	public Checkout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(name.getText().length() > 0) {
					dispose();

					JOptionPane.showMessageDialog(null, "Product added succesfully ", "Success",
							JOptionPane.YES_NO_CANCEL_OPTION);

					try {

			
						
				
						ConexionBD.EjecutarUpdate("INSERT INTO orders(OrderID, RecipientName, Address, Total" VALUES (\"" + name.getText() + "\", \"" + address.getText() + "\", \"" + TotalPrice.getText() + "\");");
						
						ConexionBD.EjecutarUpdate("DELETE * FROM sells(ID, Name, EAN, Stock, Price)");
						
						System.out.println();
					} catch (SQLException e1) {

						e1.printStackTrace();
					}

					Home h = new Home();
					h.setVisible(true);

				} else {
					
					//System.out.println("INSERT INTO sells(ID, Name, EAN, Stock, Price) " + "SELECT * FROM products WHERE products.ID = " + ProductID.getText());
					
					JOptionPane.showMessageDialog(null, "FATAL ERROR", "Please try again", JOptionPane.WARNING_MESSAGE);

				}

			}
		});
			
		btnPlaceOrder.setBackground(SystemColor.activeCaption);
		btnPlaceOrder.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		btnPlaceOrder.setBounds(504, 327, 125, 23);
		contentPane.add(btnPlaceOrder);
		
		JCheckBox fast = new JCheckBox("Fast Shipping (7\u20AC)");
		fast.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		fast.setBackground(SystemColor.activeCaption);
		fast.setBounds(10, 197, 189, 23);
		contentPane.add(fast);
		
		JTextArea txtrCheckout = new JTextArea();
		txtrCheckout.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		txtrCheckout.setBackground(SystemColor.activeCaption);
		txtrCheckout.setText("CHECKOUT");
		txtrCheckout.setBounds(247, 11, 125, 23);
		contentPane.add(txtrCheckout);
		
		
		DefaultTableModel modelo = new DefaultTableModel();
		table = new JTable(modelo);
		table.setBackground(Color.WHITE);
		table.setBounds(10, 45, 619, 211);
		contentPane.add(table);
		
		modelo.addColumn("ID");
		modelo.addColumn("Name");
		modelo.addColumn("EAN");
		modelo.addColumn("Stock");
		modelo.addColumn("Price");

		ResultSet rs = ConexionBD.EjecutarSentencia("SELECT * FROM sells");

		try {
			while (rs.next()) {
				String[] filas = new String[5];
				for (int i = 0; i < 5; i++) {
					filas[i] = rs.getString(i + 1);
				}
				modelo.addRow(filas);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JScrollPane scrollBar = new JScrollPane(table);
		scrollBar.setBounds(10, 45, 268, 107);
		contentPane.add(scrollBar);
		scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JCheckBox standard = new JCheckBox("Standard Shipping (3\u20AC)");
		standard.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		standard.setBackground(SystemColor.activeCaption);
		standard.setBounds(10, 164, 189, 23);
		contentPane.add(standard);
		
		JTextArea txtrRecipientId = new JTextArea();
		txtrRecipientId.setEditable(false);
		txtrRecipientId.setBackground(SystemColor.activeCaption);
		txtrRecipientId.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		txtrRecipientId.setText("Recipient Name:");
		txtrRecipientId.setBounds(285, 102, 125, 23);
		contentPane.add(txtrRecipientId);
		
		name = new JTextField();
		name.setBounds(420, 105, 190, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		address = new JTextField();
		address.setBounds(420, 132, 190, 20);
		contentPane.add(address);
		address.setColumns(10);
		
		JTextArea txtrAdress = new JTextArea();
		txtrAdress.setEditable(false);
		txtrAdress.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		txtrAdress.setBackground(SystemColor.activeCaption);
		txtrAdress.setText("Address:");
		txtrAdress.setBounds(344, 129, 66, 23);
		contentPane.add(txtrAdress);
		
		JTextArea txtrZipCode = new JTextArea();
		txtrZipCode.setEditable(false);
		txtrZipCode.setBackground(SystemColor.activeCaption);
		txtrZipCode.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		txtrZipCode.setText("Postal Code:");
		txtrZipCode.setBounds(312, 160, 98, 23);
		contentPane.add(txtrZipCode);
		
		JTextArea pcode = new JTextArea();
		pcode.setBounds(420, 164, 190, 20);
		contentPane.add(pcode);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Maiandra GD", Font.BOLD, 11));
		btnBack.setBackground(SystemColor.activeCaption);
		btnBack.setBounds(10, 328, 89, 23);
		contentPane.add(btnBack);
	}
}
