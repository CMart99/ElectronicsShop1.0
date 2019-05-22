package proyecto;

import javax.swing.*;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.sql.SQLException;
import java.awt.*;

/**
 * @version 1.0
 * @author Carlos Martínez Aldayturriaga
 *
 */
public class Register extends JFrame {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usuario;
	private JButton enviar;
	private JTextPane txtpnFormularioDeRegistro;
	private JTextPane repetir;
	private JPasswordField pass2;
	private JTextPane pass;
	private JPasswordField pass1;
	private JTextArea txtrYourEmail;
	private JTextField email;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Register() {
		setResizable(false);
		
		new ConexionBD();
		ConexionBD.Conectar();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtpnFormularioDeRegistro = new JTextPane();
		txtpnFormularioDeRegistro.setBackground(SystemColor.activeCaption);
		txtpnFormularioDeRegistro.setEditable(false);
		txtpnFormularioDeRegistro.setFont(new Font("Source Sans Pro Black", Font.BOLD, 18));
		txtpnFormularioDeRegistro.setText("REGISTER FORM");
		txtpnFormularioDeRegistro.setBounds(138, 11, 156, 29);
		contentPane.add(txtpnFormularioDeRegistro);

		JTextArea txtrNombreDeUsuario = new JTextArea();
		txtrNombreDeUsuario.setBackground(SystemColor.activeCaption);
		txtrNombreDeUsuario.setEditable(false);
		txtrNombreDeUsuario.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		txtrNombreDeUsuario.setText("Username:");
		txtrNombreDeUsuario.setBounds(120, 65, 78, 22);
		contentPane.add(txtrNombreDeUsuario);

		usuario = new JTextField();
		usuario.setBounds(212, 66, 145, 20);
		contentPane.add(usuario);
		usuario.setColumns(10);

		enviar = new JButton("Register");
		enviar.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		enviar.setBackground(SystemColor.activeCaption);
		enviar.addActionListener(new ActionListener() {
			@SuppressWarnings({ "deprecation" })
			public void actionPerformed(ActionEvent e) {

				dispose();
				Login login = new Login();
				login.setVisible(true);

				if (pass1.getText().equals(pass2.getText()) && usuario.getText().length() > 1 && pass1.getText().length() > 1) {
					
					
					try {
						
						ConexionBD.EjecutarUpdate("INSERT INTO usuarios(Nombre, Password, Email) VALUES (\""
								+ usuario.getText() + "\", \"" + pass1.getText() + "\", \"" + email.getText()
								+ "\");");
						
						JOptionPane.showMessageDialog(null, "Register successful", "Success", JOptionPane.INFORMATION_MESSAGE);
					}catch (SQLException e1){
						
						
						JOptionPane.showMessageDialog(null, "User already registered", "Error", JOptionPane.ERROR_MESSAGE);
						
						e1.printStackTrace();
					}
				} else {

					System.out.println("");
				}
			}
		});
		enviar.setBounds(103, 188, 95, 23);
		contentPane.add(enviar);

		repetir = new JTextPane();
		repetir.setBackground(new Color(153, 180, 209));
		repetir.setEditable(false);
		repetir.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		repetir.setText("Repeat password:");
		repetir.setBounds(76, 125, 122, 22);
		contentPane.add(repetir);

		pass = new JTextPane();
		pass.setBackground(SystemColor.activeCaption);
		pass.setEditable(false);
		pass.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		pass.setText("Password:");
		pass.setBounds(120, 94, 72, 20);
		contentPane.add(pass);

		pass1 = new JPasswordField();
		pass1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pass1.setBounds(212, 96, 145, 20);
		contentPane.add(pass1);

		pass2 = new JPasswordField();
		pass2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pass2.setBounds(212, 127, 145, 20);
		contentPane.add(pass2);

		JButton volver = new JButton("Back");
		volver.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		volver.setBackground(SystemColor.activeCaption);
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Login login = new Login();
				login.setVisible(true);

			}
		});
		volver.setBounds(258, 188, 99, 23);
		contentPane.add(volver);
		
		txtrYourEmail = new JTextArea();
		txtrYourEmail.setFont(new Font("Maiandra GD", Font.BOLD, 13));
		txtrYourEmail.setBackground(SystemColor.activeCaption);
		txtrYourEmail.setText("Your email:");
		txtrYourEmail.setBounds(120, 158, 78, 22);
		contentPane.add(txtrYourEmail);
		
		email = new JTextField();
		email.setBounds(212, 157, 145, 20);
		contentPane.add(email);
		email.setColumns(10);
	}
}