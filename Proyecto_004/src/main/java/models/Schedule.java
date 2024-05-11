package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import models.interfaz.IDAO_DOS;

@Entity
@Table(name = "horario")
public class Schedule implements IDAO_DOS{
	
	@Id
	private int id_materia;
	
	@Column(name = "id_Al")
	private int id_Al;
	
	@Column(name = "id_profe")
	private int id_profe;

	@Column(name = "hora_inicio")
	String hora_inicio;
	
	@Column(name = "hora_fin")
	String hora_final;
	
	@Column(name = "dia")
	String dia;
	
	public Schedule() {
		
	}

	public int getId_materia() {
		return id_materia;
	}

	public void setId_materia(int id_materia) {
		this.id_materia = id_materia;
	}

	public int getId_Al() {
		return id_Al;
	}

	public void setId_Al(int id_Al) {
		this.id_Al = id_Al;
	}

	public int getId_profe() {
		return id_profe;
	}

	public void setId_profe(int id_profe) {
		this.id_profe = id_profe;
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
	private SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Schedule.class);
        return configuration.buildSessionFactory();
    }
	@Override
	public void create(int id, int id2, int id3, String hora_inicio, String hora_fin, String dia) {
		
		try (SessionFactory sessionFactory = getSessionFactory()) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            setId_materia(id);
            setId_Al(id2);
            setId_profe(id3);
            setHora_inicio(hora_inicio);
            setHora_final(hora_fin);
            setDia(dia);
            session.save(this);
            session.getTransaction().commit();
        }
	}

	@Override
	public List<Schedule> read(int id) {
		  try (SessionFactory sessionFactory = getSessionFactory()) {
		        Session session = sessionFactory.openSession();
		        session.beginTransaction();
		        
		        System.out.println("ID proporcionado: " + id);
		        
		        Query<Schedule> query = session.createQuery("SELECT s FROM Schedule s WHERE s.id_materia = :id", Schedule.class);
		        query.setParameter("id", id);
		        
		        List<Schedule> horarios = query.getResultList();
		        
		        System.out.println("Número de registros recuperados: " + horarios.size());
		        
		        for (Schedule horario : horarios) {
		            System.out.println("ID de la materia: " + horario.getId_materia());
		            System.out.println("ID de alumno: " + horario.getId_Al());
		            System.out.println("ID de profesor: " + horario.getId_profe());
		            System.out.println("Hora de inicio: " + horario.getHora_inicio());
		            System.out.println("Hora de fin: " + horario.getHora_final());
		            System.out.println("Dia: " + horario.getDia());
		        }
		        
		        session.getTransaction().commit();
		        return horarios;
		    } catch (Exception e) {
		        
		        e.printStackTrace();
		        return null;
		    }
	
	}

	@Override
	public void update(int id, String actualizar) {
		  try (SessionFactory sessionFactory = getSessionFactory()) {
	            Session session = sessionFactory.openSession();
	            session.beginTransaction();
	            Schedule horario = session.find(Schedule.class, id);
	            horario.setDia(actualizar);
	            session.update(horario);
	            session.getTransaction().commit();
	        }
		
	}

	@Override
	public void delete(int id,int id2) {
		 try (SessionFactory sessionFactory = getSessionFactory()) {
		        Session session = sessionFactory.openSession();
		        session.beginTransaction();
		        
		        // Construye la consulta para eliminar el registro basado en ambos IDs
		        Query query = session.createQuery("DELETE FROM Schedule s WHERE s.id_materia = :idMateria AND s.id_Al = :idAlumno");
		        query.setParameter("idMateria", id);
		        query.setParameter("idAlumno", id2);
		        
		        // Ejecuta la consulta de eliminación
		        int rowsAffected = query.executeUpdate();
		        
		        // Comprueba si se eliminó algún registro
		        if (rowsAffected > 0) {
		            System.out.println("Se eliminaron " + rowsAffected + " registros de horario.");
		        } else {
		            System.out.println("No se encontraron registros de horario para eliminar.");
		        }
		        
		        session.getTransaction().commit();
		    } catch (Exception e) {
		        // Manejo de excepciones si es necesario
		        e.printStackTrace();
		    }
		
	}
	
}
