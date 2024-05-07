package Package.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Package.Interfaz.IDAOSP;

public class Professor extends ClassIns implements IDAOSP{

	int id_profe;
	String name_profe;
	String lastname_profe;
	int age;
	Connection connection;
	PreparedStatement sentencia;
	public int getId_profe() {
		return id_profe;
	}

	public void setId_profe(int id_profe) {
		this.id_profe = id_profe;
	}

	public String getName_profe() {
		return name_profe;
	}

	public void setName_profe(String name_profe) {
		this.name_profe = name_profe;
	}

	public String getLastname_profe() {
		return lastname_profe;
	}

	public void setLastname_profe(String lastname_profe) {
		this.lastname_profe = lastname_profe;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	
	public Professor() {
		super();
		try {
			connection = obtenerConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void create(ClassIns ins,int id_profe, String name_profe, String last_name, int age) {
		
		ins.setId(id_profe);
		ins.setName(name_profe);
		try {
	       
	        String sql = "INSERT INTO profesor(id_profe, name_profe, lastname_profe,age_profe) values (?, ?, ?, ?)";
	        sentencia = connection.prepareStatement(sql);
	        sentencia.setInt(1, ins.getId());
	        sentencia.setString(2, ins.getName()); // Corregido el parámetro name
	        sentencia.setString(3, last_name);
	        sentencia.setInt(4, age);
	        
	        int filasAfectadas = sentencia.executeUpdate();
	        if (filasAfectadas > 0) {
	            System.out.println("Los datos se han cargado exitosamente.");
	        } else {
	            System.out.println("No se han cargado los datos.");
	        }
	    } catch (SQLException e) {
	    	System.out.println("Ya cargaraste esta Clave primaria");
			System.out.println("Ingresa nuevos Datos si quieres ingesar una nuevo Profesor");
	    } finally {
	        // Asegúrate de cerrar la conexión cuando ya no sea necesaria
	        try {
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	    }
		
	}

	@Override
	public void read(ClassIns ins,int id_profe) {
		  ResultSet resultSet = null;
		    try {
		    	
		    	String sql  = "SELECT * FROM profesor WHERE id_profe = ?";
		        sentencia = connection.prepareStatement(sql);
		        sentencia.setInt(1, id_profe);
		        
		        resultSet = sentencia.executeQuery();
		        
		        if (resultSet.next()) {
		          
		        	  System.out.println("Se encontraron resultados en la consulta.");
		        	  
		        	  System.out.println("***Profesor***");
		        	    ins.setId(resultSet.getInt("id_profe")); 
		        	    System.out.println("ID: " + ins.getId());
		        	    
		        	    ins.setName(resultSet.getString("name_profe"));
		        	   System.out.println("Nombre: " + ins.getName()); 
		        	   
		        	    setLastname_profe(resultSet.getString("lastname_profe"));
		        	    System.out.println("Apellido: " + resultSet.getString("lastname_profe")); 
		        	    
		        	    setAge(resultSet.getInt("age_profe")); 
		        	  System.out.println("Edad: " + resultSet.getInt("age_profe")); 
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        try {
		   
		            if (resultSet != null) {
		                resultSet.close();
		            }
		            if (sentencia != null) {
		                sentencia.close();
		            }
		   
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
	
		
	}

	@Override
	public void update(ClassIns ins,int id, String name) {
		ins.setName(name);
		String sql;

		try {
			
			connection.setAutoCommit(false);
			sql = "UPDATE profesor SET name_profe = ? WHERE id_profe = ?";
			sentencia = connection.prepareStatement(sql);

			sentencia.setString(1, ins.getName()); // Establecer el nuevo nombre
			sentencia.setInt(2, id); // Establecer el ID del estudiante

			sentencia.executeUpdate();
			connection.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sentencia != null) {
					sentencia.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
	}

	@Override
	public void delete(int id) {
		String sql;
		try {
			
			connection.setAutoCommit(false);
			sql = "DELETE from profesor WHERE id_profe = ?";
			sentencia = connection.prepareStatement(sql);
			sentencia.setInt(1, id);
			sentencia.executeUpdate();
			connection.commit();

		} catch (SQLException e) {

			
			e.printStackTrace();

		} finally {

			try {
				
				connection.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			

		}
		
	}
	private Connection obtenerConexion() throws SQLException {
		return ConnectionSQL.getConexion();
	}


}
