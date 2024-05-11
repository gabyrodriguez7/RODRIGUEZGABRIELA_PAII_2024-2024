package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.interfaz.IDAO_UNO;

@Entity
@Table(name = "materia")
public class Subject extends ClassIns implements IDAO_UNO{
	
	@Id
	int id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "descripcion")
	String descripcion;
	
	@Column(name = "level")
	int level;
	
	public Subject() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void create(ClassIns ins,int id, String nombre, String segundo, int valor) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Subject.class);

		try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			setId(id);
			setName(nombre);
			setDescripcion(segundo);
			setLevel(valor);
			session.save(this);
			session.getTransaction().commit();
		}

	}

	@Override
	public ClassIns read(ClassIns ins,int id) {
		Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");
	    configuration.addAnnotatedClass(Subject.class);
	    
	    try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
	        Session session = sessionFactory.openSession();
	        session.beginTransaction();

	        Subject materia = session.find(Subject.class, id);
	        
	        if (materia != null) {
	            System.out.println("ID: " + materia.getId());
	            System.out.println("Nombre: " + materia.getName());
	            System.out.println("Descripcion: " + materia.getDescripcion());
	            System.out.println("Level: " + materia.getLevel());
	        } else {
	            System.out.println("No se encontró ninguna materia con el ID proporcionado.");
	        }
	        
	        session.getTransaction().commit();
	        
	        return materia;
	    } catch (HibernateException e) {
	        // Manejo de excepciones
	        e.printStackTrace();
	        return null;
	    }

		
		
		
	}

	@Override
	public void update(ClassIns ins,int id, String actualizar) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Subject.class);

		try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			ins = session.find(Subject.class, id);
			ins.setName(actualizar);
			session.update(ins);
			session.getTransaction().commit();
		}
	}

	@Override
	public void delete(ClassIns ins,int id) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Subject.class);

		try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			ins = session.find(Subject.class, id);
			session.delete(ins);
			session.getTransaction().commit();
		}

	}
	
}
