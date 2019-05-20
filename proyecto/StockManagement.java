package proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Atxy2k.CustomTextField.RestrictedTextField;

import java.awt.SystemColor;

/**
 * @version 1.0
 * @author Carlos Martínez Aldayturriaga
 *
 */
public class StockManagement extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4528499018302050689L;
	private JPanel contentPane;
	private JTextField stock;
	private JTextField Price;

	/**
	 * Create the frame.
	 */
	
	public StockManagement() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		setTitle("https://www.electronics4everyone.com/admin/registerproduct");
		
		//DB Connection
		new ConexionBD();
		ConexionBD.Conectar();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnVolver = new JButton("Back");
		btnVolver.setBackground(SystemColor.activeCaption);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				Home h = new Home();
				h.setVisible(true);

			}
		});
		btnVolver.setBounds(10, 218, 89, 23);
		panel.add(btnVolver);
		
		JTextArea txtrProductRegister = new JTextArea();
		txtrProductRegister.setFont(new Font("Maiandra GD", Font.BOLD, 14));
		txtrProductRegister.setEditable(false);
		txtrProductRegister.setForeground(SystemColor.desktop);
		txtrProductRegister.setBackground(SystemColor.activeCaption);
		txtrProductRegister.setText("PRODUCT REGISTER FORM");
		txtrProductRegister.setBounds(114, 11, 211, 23);
		panel.add(txtrProductRegister);

		JTextArea txtrProductName = new JTextArea();
		txtrProductName.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		txtrProductName.setForeground(SystemColor.desktop);
		txtrProductName.setBackground(SystemColor.activeCaption);
		txtrProductName.setEditable(false);
		txtrProductName.setText("Product Name:");
		txtrProductName.setBounds(1, 85, 103, 23);
		panel.add(txtrProductName);

		JTextField NomProducto = new JTextField();
		NomProducto.setForeground(Color.BLACK);
		NomProducto.setBackground(Color.WHITE);
		NomProducto.setBounds(114, 85, 158, 23);
		panel.add(NomProducto);

		JTextArea EAN = new JTextArea();
		EAN.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		EAN.setText("Product EAN:");
		EAN.setForeground(SystemColor.desktop);
		EAN.setEditable(false);
		EAN.setBackground(SystemColor.activeCaption);
		EAN.setBounds(11, 119, 93, 22);
		panel.add(EAN);
		

		JTextField txtEAN = new JTextField();
		RestrictedTextField r1 = new RestrictedTextField(txtEAN, "1234567890");
	    r1.setLimit(13);
		txtEAN.setForeground(Color.BLACK);
		txtEAN.setBackground(Color.WHITE);
		txtEAN.setBounds(114, 119, 158, 23);
		panel.add(txtEAN);
		
		//Register product button
		JButton btnRegisterProduct = new JButton("Register Product");
		btnRegisterProduct.setBackground(SystemColor.activeCaption);
		btnRegisterProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (NomProducto.getText().length() > 1 && txtEAN.getText().length() == 13) {

					dispose();

					JOptionPane.showMessageDialog(null, "Product added succesfully ", "Success",
							JOptionPane.YES_NO_CANCEL_OPTION);

					try {
						
						//Insert product into DB
						ConexionBD.EjecutarUpdate("INSERT INTO products(Name, EAN, Stock, Price) VALUES (\"" + NomProducto.getText() + "\", \"" + txtEAN.getText() + "\", \"" + stock.getText()
								+ "\", \"" + Price.getText() + "\");");

					} catch (SQLException e1) {

						e1.printStackTrace();
					}

					StockManagement sm = new StockManagement();
					sm.setVisible(true);

				} else {
					
					
					JOptionPane.showMessageDialog(null, "FATAL ERROR", "Please try again", JOptionPane.WARNING_MESSAGE);

				}

			}
		});
		btnRegisterProduct.setBounds(282, 218, 133, 23);
		panel.add(btnRegisterProduct);

		JTextArea txtrEg1 = new JTextArea();
		txtrEg1.setFont(new Font("Maiandra GD", Font.BOLD, 11));
		txtrEg1.setText("Max. 13 characters");
		txtrEg1.setForeground(Color.DARK_GRAY);
		txtrEg1.setEditable(false);
		txtrEg1.setBackground(SystemColor.activeCaption);
		txtrEg1.setBounds(282, 121, 117, 22);
		panel.add(txtrEg1);

		JTextArea txtrStock = new JTextArea();
		txtrStock.setEditable(false);
		txtrStock.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		txtrStock.setBackground(SystemColor.activeCaption);
		txtrStock.setText("Stock:");
		txtrStock.setBounds(57, 153, 47, 22);
		panel.add(txtrStock);

		stock = new JTextField();
		stock.setBounds(114, 153, 158, 22);
		panel.add(stock);
		stock.setColumns(10);

		Price = new JTextField();
		Price.setBounds(114, 186, 158, 23);
		panel.add(Price);
		Price.setColumns(10);
		
		//Product price
		JTextArea txtrPrice = new JTextArea();
		txtrPrice.setBackground(SystemColor.activeCaption);
		txtrPrice.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		txtrPrice.setText("Price:");
		txtrPrice.setBounds(64, 185, 40, 22);
		panel.add(txtrPrice);
		
		JTextArea txtrMaxCharacters = new JTextArea();
		txtrMaxCharacters.setForeground(Color.DARK_GRAY);
		txtrMaxCharacters.setFont(new Font("Maiandra GD", Font.BOLD, 11));
		txtrMaxCharacters.setBackground(SystemColor.activeCaption);
		txtrMaxCharacters.setText("Max. 4 characters");
		txtrMaxCharacters.setBounds(282, 154, 103, 23);
		panel.add(txtrMaxCharacters);

		JTextArea txtrMaxCharacters_1 = new JTextArea();
		txtrMaxCharacters_1.setForeground(Color.DARK_GRAY);
		txtrMaxCharacters_1.setFont(new Font("Maiandra GD", Font.BOLD, 11));
		txtrMaxCharacters_1.setBackground(SystemColor.activeCaption);
		txtrMaxCharacters_1.setText("Max. 2 decimals");
		txtrMaxCharacters_1.setBounds(282, 188, 117, 23);
		panel.add(txtrMaxCharacters_1);

		JTextArea txtrMaxCharacters_2 = new JTextArea();
		txtrMaxCharacters_2.setFont(new Font("Maiandra GD", Font.BOLD, 11));
		txtrMaxCharacters_2.setBackground(SystemColor.activeCaption);
		txtrMaxCharacters_2.setForeground(Color.DARK_GRAY);
		txtrMaxCharacters_2.setText("Max. 30 characters");
		txtrMaxCharacters_2.setBounds(282, 87, 117, 23);
		panel.add(txtrMaxCharacters_2);

	}
}