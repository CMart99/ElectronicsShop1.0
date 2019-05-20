package proyecto;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

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
public class AccountManagement extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8758881644964438829L;
	private JPanel contentPane;
	private JTable userstable;
	private JTextField newPass;

	/**
	 * Create the frame.
	 */
	public AccountManagement() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		setTitle("www.electronics4everyone.com/account/manage");

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
				Home h = new Home();
				h.setVisible(true);

			}
		});
		btnBack.setBounds(10, 397, 89, 23);
		panel.add(btnBack);

		JTextArea AccountManagement = new JTextArea();
		AccountManagement.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		AccountManagement.setEditable(false);
		AccountManagement.setBackground(SystemColor.activeCaption);
		AccountManagement.setForeground(Color.BLACK);
		AccountManagement.setText("ACCOUNT MANAGEMENT");
		AccountManagement.setBounds(249, 11, 298, 28);
		panel.add(AccountManagement);

		DefaultTableModel modelo = new DefaultTableModel();
		userstable = new JTable(modelo);
		userstable.setEnabled(false);
		userstable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		userstable.setBackground(Color.WHITE);
		userstable.setBounds(10, 69, 438, 305);
		panel.add(userstable);

		JTextArea txtrName = new JTextArea();
		txtrName.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		txtrName.setForeground(Color.BLACK);
		txtrName.setBackground(SystemColor.activeCaption);
		txtrName.setEditable(false);
		txtrName.setText("Name");
		txtrName.setBounds(10, 46, 60, 23);
		panel.add(txtrName);

		JTextArea txtemail = new JTextArea();
		txtemail.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		txtemail.setForeground(Color.BLACK);
		txtemail.setBackground(SystemColor.activeCaption);
		txtemail.setEditable(false);
		txtemail.setText("Email");
		txtemail.setBounds(295, 46, 52, 23);
		panel.add(txtemail);

		JTextField Name = new JTextField();

		Name.setBounds(602, 216, 127, 23);
		panel.add(Name);

		JTextArea Username = new JTextArea();
		Username.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		Username.setEditable(false);
		Username.setBackground(SystemColor.activeCaption);
		Username.setText("Username");
		Username.setBounds(506, 216, 88, 23);
		panel.add(Username);

		JTextArea txtrNewPass = new JTextArea();
		txtrNewPass.setText("New Password");
		txtrNewPass.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		txtrNewPass.setEditable(false);
		txtrNewPass.setBackground(SystemColor.activeCaption);
		txtrNewPass.setBounds(482, 241, 112, 23);
		panel.add(txtrNewPass);
		
		newPass = new JTextField();
		newPass.setBounds(602, 242, 127, 22);
		panel.add(newPass);
		newPass.setColumns(10);

		JButton btnUpdateAccount = new JButton("Update Account");
		btnUpdateAccount.setBackground(SystemColor.activeCaption);
		btnUpdateAccount.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {

				if (Name.getText().length() > 0) {

					dispose();

					JOptionPane.showMessageDialog(null, "Data Updated Succesfully", "",
							JOptionPane.INFORMATION_MESSAGE);

					try {
						
						
						//System.out.println("UPDATE usuarios SET Password = \"" + newPass.getText() + "\"  WHERE Nombre = \"" + Name.getText() + "\"");
						
						ConexionBD.EjecutarUpdate("UPDATE usuarios SET Password = \"" + newPass.getText() + "\"  WHERE Nombre = \"" + Name.getText() + "\"");

					} catch (SQLException e) {

						e.printStackTrace();
					}

					AccountManagement am = new AccountManagement();
					am.setVisible(true);

				} else {

					JOptionPane.showMessageDialog(null, "Error ", "Please try again", JOptionPane.WARNING_MESSAGE);

				}

			}
		});

		btnUpdateAccount.setBounds(704, 329, 112, 45);
		panel.add(btnUpdateAccount);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setText("Password");
		txtrPassword.setBounds(137, 45, 112, 24);
		panel.add(txtrPassword);

		

		modelo.addColumn("Nombre");
		modelo.addColumn("Password");
		modelo.addColumn("Email");

		ResultSet rs = ConexionBD.EjecutarSentencia("SELECT * FROM usuarios");

		try {
			while (rs.next()) {
				String[] filas = new String[3];
				for (int i = 0; i < 3; i++) {
					filas[i] = rs.getString(i + 1);
				}
				modelo.addRow(filas);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}