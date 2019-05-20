package proyecto;

import java.sql.*;

import javax.swing.JOptionPane;

/**
 * @version 1.0
 * @author Carlos Martínez Aldayturriaga
 *
 */
public class ConexionBD {

	static String dbName = "stock";
	static String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static String url = "jdbc:mysql://localhost:3306/" + dbName + timeZone;
	static String user = "root";
	static String pass = "manolo";
	static String driver = "com.mysql.cj.jdbc.Driver";

	static Connection conexion;
	static Statement consulta;
	static ResultSet resultado;

	public static void Conectar() {

		try {

			conexion = DriverManager.getConnection(url, user, pass);
			consulta = conexion.createStatement();
			System.out.println("Connection Established");

		} catch (SQLException e) {
			System.out.println("Connection Error");
			e.printStackTrace();
		}
	}

	public static ResultSet EjecutarSentencia(String Sentencia) {

		try {

			resultado = consulta.executeQuery(Sentencia);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "HOW ABOUT YOU LEARN HOW TO MAKE A QUERY? ", " FATAL ERROR! ",
					JOptionPane.WARNING_MESSAGE);
		}

		return resultado;
	}

	public static void EjecutarUpdate(String Sentencia) throws SQLException {

		try {

			consulta.executeUpdate(Sentencia);
			System.out.println("Connection Terminated");

		} catch (SQLException e) {

			throw new SQLException("");

		}
	}

	public static void CerrarConexion() {
		try {
			consulta.close();
		} catch (Exception e) {
		}
	}

}