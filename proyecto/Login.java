package proyecto;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.awt.event.ActionEvent;
import remember.RememberUname;
/**
 * @version 1.0
 * @author Carlos Martínez Aldayturriaga
 *
 */
public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -777530028656960854L;
	private JPanel contentPane;
	private JPasswordField pass1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {

		new ConexionBD();
		ConexionBD.Conectar();
		
		String u = "";
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		// Register button
		JButton register = new JButton("Register");
		register.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		register.setBackground(SystemColor.activeCaption);
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Register r = new Register();
				r.setVisible(true);
			}

		});
		register.setBounds(240, 153, 89, 23);
		panel.add(register);
		// User
		JTextArea txtrUsuario = new JTextArea();
		txtrUsuario.setEditable(false);
		txtrUsuario.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtrUsuario.setBackground(SystemColor.activeCaption);
		txtrUsuario.setText("User");
		txtrUsuario.setBounds(110, 37, 41, 23);
		panel.add(txtrUsuario);
		
		
		// Password
		JTextArea txtrPasswd = new JTextArea();
		txtrPasswd.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtrPasswd.setBackground(SystemColor.activeCaption);
		txtrPasswd.setEditable(false);
		txtrPasswd.setText("Password");
		txtrPasswd.setBounds(91, 86, 75, 23);
		panel.add(txtrPasswd);
		
		try {
			u = RememberUname.remember();
		} catch (IOException e2) {}
		
		JTextArea username = new JTextArea(u);
		username.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		username.setBackground(Color.WHITE);
		username.setBounds(176, 40, 156, 21);
		panel.add(username);

		JTextArea txtranNoTienes = new JTextArea();
		txtranNoTienes.setFont(new Font("Mangal", Font.BOLD, 13));
		txtranNoTienes.setEditable(false);
		txtranNoTienes.setBackground(SystemColor.activeCaption);
		txtranNoTienes.setText("Not registered yet?");
		txtranNoTienes.setBounds(240, 130, 156, 22);
		panel.add(txtranNoTienes);

		JCheckBox rememberuname = new JCheckBox("Remember my username");
		rememberuname.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rememberuname.setBackground(SystemColor.activeCaption);
		rememberuname.setBounds(240, 199, 143, 23);
		panel.add(rememberuname);
		
		pass1 = new JPasswordField();
		pass1.setBounds(176, 90, 153, 23);
		panel.add(pass1);

		JButton login = new JButton("Login");
		login.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		login.addActionListener(new ActionListener() {
			/**
			 * Login button
			 */
			public void actionPerformed(ActionEvent e) {

				dispose();

				@SuppressWarnings("deprecation")
				ResultSet resultado = ConexionBD.EjecutarSentencia(
						MessageFormat.format("SELECT * FROM usuarios WHERE Nombre = ''{0}''AND Password = ''{1}''",
								username.getText(), pass1.getText()));

				try {

					if (resultado.next()) {
						
						if(rememberuname.isSelected()) {
							try {
								RememberUname.save(username.getText());	
							} catch (Exception e1) {}
						}

						Home h = new Home();
						h.setVisible(true);

					} else {

						dispose();

						JOptionPane.showMessageDialog(null, "Incorrect login data", "FATAL ERROR",
								JOptionPane.WARNING_MESSAGE);
						Login l = new Login();
						l.setVisible(true);
					}
				} catch (HeadlessException e1) {

					e1.printStackTrace();
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});

		login.setBackground(SystemColor.activeCaption);
		login.setBounds(77, 153, 89, 23);
		panel.add(login);

		JTextArea txtrWannaLoginEasily = new JTextArea();
		txtrWannaLoginEasily.setEditable(false);
		txtrWannaLoginEasily.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		txtrWannaLoginEasily.setBackground(SystemColor.activeCaption);
		txtrWannaLoginEasily.setText("Wanna login easily next time?");
		txtrWannaLoginEasily.setBounds(20, 199, 198, 22);
		panel.add(txtrWannaLoginEasily);

		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				dispose();

				try {

					if (username.getText() == "admin" && pass1.getText() == "admin") {

						dispose();

						AdminCP acp = new AdminCP();
						acp.setVisible(true);

					} else {

						dispose();

						JOptionPane.showMessageDialog(null, "You're very nigga", "FATAL ERROR",
								JOptionPane.WARNING_MESSAGE);
						Login l = new Login();
						l.setVisible(true);
					}
				} catch (HeadlessException e1) {

					e1.printStackTrace();
				}

			}

		});
		btnAdminLogin.setBackground(SystemColor.activeCaption);
		btnAdminLogin.setBounds(10, 11, 141, 23);
		panel.add(btnAdminLogin);
		
		

	}
}