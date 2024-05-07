package Package.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import Package.Interfaz.IDAOSP;

public class Student extends ClassIns implements IDAOSP {

	int id_Al;
	String name_Al;
	String lastname_Al;
	int age;
	String sql = null;
	Connection connection;
	PreparedStatement sentencia;
	public Student() {
		try {
			connection = obtenerConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId_Al() {
		return id_Al;
	}

	public void setId_Al(int id_Al) {
		this.id_Al = id_Al;
	}

	public String getName_Al() {
		return name_Al;
	}

	public void setName_Al(String name_Al) {
		this.name_Al = name_Al;
	}

	public String getLastname_Al() {
		return lastname_Al;
	}

	public void setLastname_Al(String lastname_Al) {
		this.lastname_Al = lastname_Al;
	}

	@Override
	public void create(ClassIns ins, int id_Al, String name_Al, String last_name, int age) {

		ins.setId(id_Al);
		ins.setName(name_Al);
		try {
			
			String sql = "INSERT INTO alumno(id_Al, name_Al, lastname_Al,age_Al) values (?, ?, ?, ?)";
			sentencia = connection.prepareStatement(sql);
			sentencia.setInt(1, ins.getId());
			sentencia.setString(2, ins.getName());
			sentencia.setString(3, last_name);
			sentencia.setInt(4, age);

			int filasAfectadas = sentencia.executeUpdate();
			if (filasAfectadas > 0) {
				System.out.println("Los datos se han cargado exitosamente.");
			} else {
				System.out.println("No se han cargado los datos.");
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("Error al intentar cargar los datos.");
		} finally {
			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void read(ClassIns ins, int id_Al) {
		ResultSet resultSet = null;

		try {
			
			String sql = "SELECT * FROM alumno WHERE id_Al = ?";
			sentencia = connection.prepareStatement(sql);
			sentencia.setInt(1, id_Al);

			resultSet = sentencia.executeQuery();

			if (resultSet.next()) {

				System.out.println("Se encontraron resultados en la consulta.");
				System.out.println("*** Alumno***");
				ins.setId(resultSet.getInt("id_Al"));
				System.out.println("ID: " + ins.getId());

				ins.setName(resultSet.getString("name_Al"));
				System.out.println("Nombre: " + ins.getName());

				setLastname_Al(resultSet.getString("lastname_Al"));
				System.out.println("Apellido: " + resultSet.getString("lastname_Al"));

				setAge(resultSet.getInt("age_Al"));
				System.out.println("Edad: " + resultSet.getInt("age_Al"));
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
			sql = "UPDATE alumno SET name_Al = ? WHERE id_Al = ?";
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
			sql = "DELETE from alumno WHERE id_Al = ?";
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
