package proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
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

import Atxy2k.CustomTextField.RestrictedTextField;

import java.awt.SystemColor;
import javax.swing.JTextField;

/**
 * @version 1.0
 * @author Carlos Martínez Aldayturriaga
 *
 */
public class StockDelete extends JFrame {

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
	public StockDelete() {
		setResizable(false);
		setTitle("www.electronics4everyone.com");
		setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(650, 300, 783, 496);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		new ConexionBD();
		ConexionBD.Conectar();

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

		JTextArea txtrProductList = new JTextArea();
		txtrProductList.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		txtrProductList.setEditable(false);
		txtrProductList.setBackground(SystemColor.activeCaption);
		txtrProductList.setForeground(SystemColor.desktop);
		txtrProductList.setText("DROP FROM LIST");
		txtrProductList.setBounds(299, 11, 197, 28);
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
		scrollBar.setBounds(10, 50, 737, 336);
		panel.add(scrollBar);
		scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		ID = new JTextField();
		RestrictedTextField rtf = new RestrictedTextField(ID, "1234567890");
	    rtf.setLimit(2);
		ID.setBounds(382, 397, 121, 22);
		panel.add(ID);
		ID.setColumns(10);

		JTextArea txtrIntroduceEanTo = new JTextArea();
		txtrIntroduceEanTo.setEditable(false);
		txtrIntroduceEanTo.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		txtrIntroduceEanTo.setBackground(SystemColor.activeCaption);
		txtrIntroduceEanTo.setText("Enter product ID to drop:");
		txtrIntroduceEanTo.setBounds(194, 397, 178, 23);
		panel.add(txtrIntroduceEanTo);

		JButton btnDropItem = new JButton("Drop Item");
		btnDropItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (ID.getText().length() >= 1) {

					dispose();

					JOptionPane.showMessageDialog(null, "Product dropped succesfully ", "Success",
							JOptionPane.YES_NO_CANCEL_OPTION);

					try {

						// System.out.println("DELETE FROM products WHERE EAN = " +EAN.getText());
						ConexionBD.EjecutarUpdate("DELETE FROM products WHERE ID = " + ID.getText());
					} catch (SQLException e1) {

						e1.printStackTrace();
					}

					StockDelete sd = new StockDelete();
					sd.setVisible(true);

				} else {

					JOptionPane.showMessageDialog(null, "FATAL ERROR", "Please try again", JOptionPane.WARNING_MESSAGE);

				}
			}
		});
		btnDropItem.setBackground(SystemColor.activeCaption);
		btnDropItem.setBounds(658, 397, 89, 23);
		panel.add(btnDropItem);
	}
}
