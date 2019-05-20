package proyecto;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Atxy2k.CustomTextField.RestrictedTextField;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.awt.SystemColor;

/**
 * @version 1.0
 * @author Carlos Martínez Aldayturriaga
 *
 */
public class UpdateProduct extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2942645503271821779L;
	private JPanel contentPane;
	private JTable tabla1;

	/**
	 * Create the frame.
	 */
	public UpdateProduct() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(""));
		setTitle("https://electronics4everyone.com/updateproduct");
		
		//DB Connection
		new ConexionBD();
		ConexionBD.Conectar();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(650, 300, 874, 511);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnBack = new JButton("Back");
		btnBack.setBackground(SystemColor.activeCaption);
		btnBack.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				Home i = new Home();
				i.setVisible(true);

			}
		});
		btnBack.setBounds(10, 397, 89, 23);
		panel.add(btnBack);

		JTextArea UPDATE = new JTextArea();
		UPDATE.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		UPDATE.setEditable(false);
		UPDATE.setBackground(SystemColor.activeCaption);
		UPDATE.setForeground(SystemColor.desktop);
		UPDATE.setText("PRODUCT LIST UPDATE");
		UPDATE.setBounds(330, 11, 239, 28);
		panel.add(UPDATE);

		DefaultTableModel modelo = new DefaultTableModel();
		tabla1 = new JTable(modelo);
		tabla1.setEnabled(false);
		tabla1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla1.setBackground(Color.WHITE);
		tabla1.setBounds(12, 80, 557, 305);
		panel.add(tabla1);

		JTextArea txtrEnterID = new JTextArea();
		txtrEnterID.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		txtrEnterID.setBackground(SystemColor.activeCaption);
		txtrEnterID.setEditable(false);
		txtrEnterID.setText("ID to Update:");
		txtrEnterID.setBounds(579, 171, 98, 23);
		panel.add(txtrEnterID);

		JTextField ID = new JTextField();
		RestrictedTextField r1 = new RestrictedTextField(ID, "1234567890");
		r1.setLimit(8);

		ID.setBounds(687, 171, 116, 23);
		panel.add(ID);

		JTextArea txtrRango_1 = new JTextArea();
		txtrRango_1.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		txtrRango_1.setEditable(false);
		txtrRango_1.setBackground(SystemColor.activeCaption);
		txtrRango_1.setText("Update Price:");
		txtrRango_1.setBounds(579, 206, 98, 23);
		panel.add(txtrRango_1);

		JTextArea txtrnewStock = new JTextArea();
		txtrnewStock.setText("Update Stock:");
		txtrnewStock.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		txtrnewStock.setEditable(false);
		txtrnewStock.setBackground(SystemColor.activeCaption);
		txtrnewStock.setBounds(579, 240, 98, 23);
		panel.add(txtrnewStock);

		JTextArea newPrice = new JTextArea();
		newPrice.setBounds(687, 205, 116, 20);
		panel.add(newPrice);

		JTextArea newStock = new JTextArea();
		newStock.setBounds(687, 239, 116, 20);
		panel.add(newStock);

		JButton UpdateProduct = new JButton("Update Product");
		UpdateProduct.setBackground(SystemColor.activeCaption);
		UpdateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (ID.getText().length() == 8) {

					dispose();

					JOptionPane.showMessageDialog(null, "Product Updated Succesfully ", "",
							JOptionPane.INFORMATION_MESSAGE);

					try {

						ConexionBD.EjecutarUpdate("UPDATE products SET Price = \"" + newPrice.getText()
								+ "\", Stock =\"" + newStock.getText() + "\" WHERE products.ID = " + ID.getText());

					} catch (SQLException e2) {

						e2.printStackTrace();
					}

					UpdateProduct up = new UpdateProduct();
					up.setVisible(true);

				} else {

					JOptionPane.showMessageDialog(null, "Error ", "Please try again", JOptionPane.WARNING_MESSAGE);

				}

			}
		});

		UpdateProduct.setBounds(704, 329, 112, 45);
		panel.add(UpdateProduct);

		modelo.addColumn("ID");
		modelo.addColumn("Product");
		modelo.addColumn("EAN");
		modelo.addColumn("Stock");
		modelo.addColumn("Price");

		ResultSet rs = ConexionBD.EjecutarSentencia("SELECT * FROM products");

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
		scrollBar.setBounds(10, 50, 565, 336);
		panel.add(scrollBar);
		scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	}

}