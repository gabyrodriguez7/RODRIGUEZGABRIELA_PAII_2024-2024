package Package.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Package.Interfaz.IDAOSP;
import Package.Interfaz.IDAOschedule;

public class Subject extends ClassIns implements IDAOSP {

	int id_materia;
	String name_materia;
	String descripcion_materia;

	public Subject() {
		try {
			connection = obtenerConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getId_materia() {
		return id_materia;
	}

	public void setId_materia(int id_materia) {
		this.id_materia = id_materia;
	}

	public String getName_materia() {
		return name_materia;
	}

	public void setName_materia(String name_materia) {
		this.name_materia = name_materia;
	}

	public String getDescripcion_materia() {
		return descripcion_materia;
	}

	public void setDescripcion_materia(String descripcion_materia) {
		this.descripcion_materia = descripcion_materia;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	int level;

	Connection connection;
	PreparedStatement sentencia;

	@Override
	public void create(ClassIns ins, int id_materia, String name_materia, String descripcion_materia, int level) {
		PreparedStatement sentencia;
		ins.setId(id_materia);
		ins.setName(name_materia);
		try {

			String sql = "INSERT INTO materia(id_materia, name_materia, descripcion_materia,level_materia) values (?, ?, ?, ?)";
			sentencia = connection.prepareStatement(sql);
			ins.setId(id_materia);
			sentencia.setInt(1, ins.getId());
			sentencia.setString(2, ins.getName());
			sentencia.setString(3, descripcion_materia);
			sentencia.setInt(4, level);

			int filasAfectadas = sentencia.executeUpdate();
			if (filasAfectadas > 0) {
				System.out.println("Los datos se han cargado exitosamente.");
			} else {
				System.out.println("No se han cargado los datos.");
			}
		} catch (SQLException e) {
			System.out.println("Ya cargaraste esta Clave primaria");
			System.out.println("Ingresa nuevos Datos si quieres ingesar una nueva Materia");
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
	public void read(ClassIns ins, int id) {
		ResultSet resultSet = null;

		try {

			String sql = "SELECT * FROM materia WHERE id_materia = ?";
			sentencia = connection.prepareStatement(sql);
			sentencia.setInt(1, id);

			resultSet = sentencia.executeQuery();

			if (resultSet.next()) {

				System.out.println("Se encontraron resultados en la consulta.");
				System.out.println("*** Materia***");

				ins.setId(resultSet.getInt("id_materia"));
				System.out.println("Nombre: " + ins.getId());

				ins.setName(resultSet.getString("name_materia"));
				System.out.println("Nombre: " + ins.getName());

				setDescripcion_materia(resultSet.getString("descripcion_materia"));
				System.out.println("Descripcion: " + resultSet.getString("descripcion_materia"));

				setLevel(resultSet.getInt("level_materia"));
				System.out.println("Level: " + resultSet.getInt("level_materia"));
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
			sql = "UPDATE materia SET name_materia = ? WHERE id_materia = ?";
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
			sql = "DELETE from materia WHERE id_materia = ?";
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
