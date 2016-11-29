package cafes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class CafesDB {

	ConexionDB cndb = new ConexionDB();
	
	public String NuevoCafe(Cafes cafenuevo){
		
		Statement stmt = cndb.Conexion();
		String error = "Cafe Añadido";
		try {
			stmt.executeUpdate( "INSERT INTO CAFES " + "VALUES ('"+cafenuevo.getCafe_nombre()+"',"+cafenuevo.getProv_id()+","+cafenuevo.getPrecio()+","+cafenuevo.getVentas()+","+cafenuevo.getTotal()+")");
		} catch (SQLException e) {
			error = e + " No se ha podido añadir el cafe";
		}
		return error;	
	}
	
	public String BorrarCafe(String dlcafe){
	
		Statement stmt = cndb.Conexion();
		String error = "Cafe borrado";
		try {
			stmt.executeUpdate("delete from CAFES where (CAFE_NOMBRE = '"+dlcafe+"')");
		} catch (SQLException e) {
			error = e + " El cafe no se ha podido borrar";
		}
		return error;
	}
	
	public Cafes MostrarCafe(String nombre) throws SQLException{ 
		
		 Statement stmt = cndb.Conexion();
		 String query = "SELECT * FROM CAFES where CAFE_NOMBRE = '"+nombre+"'";
		 Cafes cafe = new Cafes();	
		 
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				cafe.setCafe_nombre(rs.getString("CAFE_NOMBRE"));
				cafe.setPrecio(rs.getFloat("PRECIO"));
				cafe.setProv_id(rs.getInt("PROV_ID"));
				cafe.setVentas(rs.getInt("VENTAS"));
				cafe.setTotal(rs.getInt("TOTAL"));	
			} 
		return cafe; // Devuelve un objeto cafe	
	}
	
	public ArrayList MostrarTodos() throws SQLException{ 
		
		ArrayList listcafe = new ArrayList();	
			
		 Statement stmt = cndb.Conexion();
		 String query = "SELECT * FROM CAFES";
		 ResultSet rs = stmt.executeQuery(query);
		 
			while (rs.next()) {
				Cafes cafe = new Cafes();
				cafe.setCafe_nombre(rs.getString("CAFE_NOMBRE"));
				cafe.setPrecio(rs.getFloat("PRECIO"));
				cafe.setProv_id(rs.getInt("PROV_ID"));
				cafe.setVentas(rs.getInt("VENTAS"));
				cafe.setTotal(rs.getInt("TOTAL"));
				listcafe.add(cafe);
			}
		return listcafe; // Devuelve una lista de objetos cafes
	}
	
	public String ActualizarCafe(String nombre , Double ventas){
		
		Statement stmt = cndb.Conexion();
		String error = "Tabla actualizada";	
		try {
			stmt.executeUpdate("UPDATE CAFES SET VENTAS = "+ventas+" WHERE CAFE_NOMBRE = '"+nombre+"'");
		} catch (SQLException e) {
			error = e + " No se ha actualizado la tabla";
		}
		return error;
	}
}