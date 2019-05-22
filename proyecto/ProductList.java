package proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
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

/**
 * @version 1.0
 * @author Carlos Martínez Aldayturriaga
 *
 */
public class ProductList extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -977355343226726705L;
	protected static final String stock = null;
	public static String ProductID;
	private JPanel contentPane;
	private JTable tabla1;

	/**
	 * Create the frame.
	 */
	public ProductList() {
		
		
		
		
		new ConexionBD();
		ConexionBD.Conectar();
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
		btnBack.setBackground(SystemColor.activeCaption);
		btnBack.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				Home i = new Home();
				i.setVisible(true);

			}
		});

		btnBack.setBounds(20, 397, 89, 23);
		panel.add(btnBack);

		JTextArea txtrProductList = new JTextArea();
		txtrProductList.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		txtrProductList.setEditable(false);
		txtrProductList.setBackground(SystemColor.activeCaption);
		txtrProductList.setForeground(SystemColor.desktop);
		txtrProductList.setText("PRODUCT LIST");
		txtrProductList.setBounds(299, 11, 154, 28);
		panel.add(txtrProductList);
		
		JTextArea ProductID = new JTextArea();
		ProductID.setBounds(338, 396, 185, 24);
		panel.add(ProductID);

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

		JButton btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				if(ProductID.getText().length() > 0) {
				dispose();

				JOptionPane.showMessageDialog(null, "Product added succesfully ", "Success",
						JOptionPane.YES_NO_CANCEL_OPTION);

				try {

					// System.out.println("INSERT INTO products(Name, EAN, Stock, Price) VALUES
					// (\""+ NomProducto.getText() + "\", \""+ txtEAN.getText() + "\", \""+
					// stock.getText() + "\", \""+ Price.getText() + "\");");
					
					//Insert product into DB
					ConexionBD.EjecutarUpdate("INSERT INTO sells(ID, Name, EAN, Stock, Price) " + "SELECT * FROM products WHERE products.ID = " + ProductID.getText());
					
					System.out.println();
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

				Cart c = new Cart();
				c.setVisible(true);

			} else {
				
				//System.out.println("INSERT INTO sells(ID, Name, EAN, Stock, Price) " + "SELECT * FROM products WHERE products.ID = " + ProductID.getText());
				
				JOptionPane.showMessageDialog(null, "FATAL ERROR", "Please try again", JOptionPane.WARNING_MESSAGE);

			}

		}
	});
		btnAddToCart.setBackground(SystemColor.activeCaption);
		btnAddToCart.setBounds(597, 397, 121, 23);
		panel.add(btnAddToCart);
		
		
		
		JTextArea txtrEnterProductId = new JTextArea();
		txtrEnterProductId.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		txtrEnterProductId.setBackground(SystemColor.activeCaption);
		txtrEnterProductId.setText("Enter Product ID to Buy:");
		txtrEnterProductId.setBounds(151, 396, 169, 24);
		panel.add(txtrEnterProductId);
	}
}