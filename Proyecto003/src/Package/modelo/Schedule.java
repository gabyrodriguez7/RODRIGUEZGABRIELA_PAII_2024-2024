package Package.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Package.Interfaz.IDAOschedule;

public class Schedule extends ClassIns implements IDAOschedule {

    
	String hora_inicio;
	String hora_final;
	String dia;

	Connection connection;
	PreparedStatement sentencia;

	public Schedule() {
		super();
		try {
			connection = obtenerConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void create(int id_materia, int id_Al, int id_profe, String horaInicio, String horafinal,
			String dia) {
		
		
        try {
           
            String sql = "INSERT INTO horario(id_materia, id_Al, id_profe, hora_inicio, hora_fin, dia) VALUES (?, ?, ?, ?, ?, ?)";
            sentencia = connection.prepareStatement(sql);
            sentencia.setInt(1, id_materia);
            sentencia.setInt(2, id_Al);
            sentencia.setInt(3, id_profe);
            sentencia.setString(4, horaInicio);
            sentencia.setString(5, horafinal);
            sentencia.setString(6, dia);

            int filasAfectadas = sentencia.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Los datos se han cargado exitosamente.");
            } else {
                System.out.println("No se han cargado los datos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al intentar cargar los datos.");
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
	public void read(ClassIns ins,int id_materia) {
		ResultSet resultSet = null;
	    try {
	    	
	    	String sql  = "SELECT * FROM horario WHERE id_materia = ?";
	        sentencia = connection.prepareStatement(sql);
	        sentencia.setInt(1, id_materia);
	        
	        resultSet = sentencia.executeQuery();
	        
	        if (resultSet.next()) {
	          
	        	  System.out.println("Se encontraron resultados en la consulta.");
	        	  
	        	  System.out.println("***Horario***");
	        	  setId(resultSet.getInt("id_materia"));
	        	    System.out.println("ID MATERIA: " + resultSet.getInt("id_materia"));
	        	    
	        	    setId(resultSet.getInt("id_Al")); 
	        	    System.out.println("ID ALUMNO: " + resultSet.getInt("id_Al"));
	        	    
	        	    setId(resultSet.getInt("id_profe")); 
	        	    System.out.println("ID PROFESOR: " + resultSet.getInt("id_profe"));
	        	    
	        	    setHora_inicio(resultSet.getString("hora_inicio"));
	        	    System.out.println("HORA INICIO: " + resultSet.getString("hora_inicio"));
	        	    
	        	    setHora_final(resultSet.getString("hora_fin"));
	        	    System.out.println("HORA FINAL: " + resultSet.getString("hora_fin"));
	        	    
	        	    
	        	    setDia(resultSet.getString("dia"));
	        	    System.out.println("DIA: " + resultSet.getString("dia"));
	        	    
	        	    
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
	public void update(ClassIns ins, int id, String name) {
		ins.setName(name);
		String sql;

		try {
			
			connection.setAutoCommit(false);
			sql = "UPDATE horario SET dia = ? WHERE id_materia = ?";
			sentencia = connection.prepareStatement(sql);

			sentencia.setString(1, ins.getName()); 
			sentencia.setInt(2, id); 

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
			sql = "DELETE from horario WHERE id_materia = ?";
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
	public String getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public String getHora_final() {
		return hora_final;
	}

	public void setHora_final(String hora_final) {
		this.hora_final = hora_final;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	private Connection obtenerConexion() throws SQLException {
		return ConnectionSQL.getConexion();
	}
}
