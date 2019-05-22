package proyecto;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import javax.swing.JTextField;

/**
 * @version 1.0
 * @author Carlos Martínez Aldayturriaga
 *
 */
public class Cart extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -977355343226726705L;
	private JPanel contentPane;
	private JTable tabla1;
	private JTextField ID;

	/**
	 * Create the frame.
	 */
	public Cart() {

		setResizable(false);
		setTitle("https://www.electronics4everyone.com");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(650, 300, 783, 496);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		btnBack.setBackground(SystemColor.activeCaption);
		btnBack.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				Home i = new Home();
				i.setVisible(true);

			}
		});

		btnBack.setBounds(10, 423, 89, 23);
		panel.add(btnBack);

		JTextArea txtrProductList = new JTextArea();
		txtrProductList.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		txtrProductList.setEditable(false);
		txtrProductList.setBackground(SystemColor.activeCaption);
		txtrProductList.setForeground(SystemColor.desktop);
		txtrProductList.setText("Shopping Cart");
		txtrProductList.setBounds(299, 11, 154, 28);
		panel.add(txtrProductList);

		DefaultTableModel modelo = new DefaultTableModel();
		tabla1 = new JTable(modelo);
		tabla1.setEnabled(false);
		tabla1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla1.setBackground(Color.WHITE);
		tabla1.setBounds(10, 69, 706, 305);
		panel.add(tabla1);

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

		JScrollPane scrollBar = new JScrollPane(tabla1);
		scrollBar.setBounds(10, 50, 737, 336);
		panel.add(scrollBar);
		scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JButton btnAddToCart = new JButton("Proceed To Checkout");
		btnAddToCart.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();

				Checkout co = new Checkout();
				co.setVisible(true);

			}
		});
		btnAddToCart.setBackground(SystemColor.activeCaption);
		btnAddToCart.setBounds(555, 423, 192, 23);
		panel.add(btnAddToCart);

		JButton btnDropFromCart = new JButton("Drop from Cart");
		btnDropFromCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (ID.getText().length() >= 1) {

					dispose();

					JOptionPane.showMessageDialog(null, "Product dropped ", "Success",
							JOptionPane.YES_NO_CANCEL_OPTION);

					try {

					
						ConexionBD.EjecutarUpdate("DELETE FROM sells WHERE ID = " + ID.getText());
					} catch (SQLException e1) {

						e1.printStackTrace();
					}

					Cart c = new Cart();
					c.setVisible(true);

				} else {

					JOptionPane.showMessageDialog(null, "Product doesn't exist in cart", "Please try with another ID", JOptionPane.WARNING_MESSAGE);

				}
			}
		});

		btnDropFromCart.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		btnDropFromCart.setBackground(SystemColor.activeCaption);
		btnDropFromCart.setBounds(375, 397, 154, 23);
		panel.add(btnDropFromCart);

		ID = new JTextField();
		ID.setBounds(231, 397, 134, 21);
		panel.add(ID);
		ID.setColumns(10);

		JTextArea txtrProductId = new JTextArea();
		txtrProductId.setEditable(false);
		txtrProductId.setBackground(SystemColor.activeCaption);
		txtrProductId.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		txtrProductId.setText("Product ID:");
		txtrProductId.setBounds(143, 397, 89, 23);
		panel.add(txtrProductId);
	}
}