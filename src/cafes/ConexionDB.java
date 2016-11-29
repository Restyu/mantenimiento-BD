package cafes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDB {

	private Statement stmt;
	private Connection conn;

	public Statement Conexion(){

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conn = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe","****", "****"); // cambiar asteriscos por : (nombre y passwork)
			Statement stmt = conn.createStatement();

			return stmt;

		 } catch(SQLException | ClassNotFoundException ex) {

		 }
		return stmt;
	}

	public void desconexion() throws SQLException{
		conn.close();
		stmt.close();
	}
}
