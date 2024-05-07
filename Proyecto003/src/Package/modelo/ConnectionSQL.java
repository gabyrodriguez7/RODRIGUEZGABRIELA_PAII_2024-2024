package Package.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {
	  private static Connection conexion;

	    private ConnectionSQL() {
	        // Constructor privado para evitar instanciación directa
	    }

	    public static Connection getConexion() {
	        if (conexion == null) {
	            String url = "jdbc:mysql://localhost:3306/instituto";
	            String usuario = "root";
	            String contrasenia = "root";
	            
	            try {
	                Class.forName("com.mysql.cj.jdbc.Driver");
	                conexion = DriverManager.getConnection(url, usuario, contrasenia);
	                boolean valida = conexion.isValid(5000);
	                System.out.println(valida ? "Conexion exitosa" : "Conexion fallida");
	            } catch (ClassNotFoundException e) {
	                System.out.println("Existe problemas al registrar el driver");
	            } catch (SQLException ex) {
	                System.out.println("Error: " + ex);
	            }
	        }
	        return conexion;
	    }

}
