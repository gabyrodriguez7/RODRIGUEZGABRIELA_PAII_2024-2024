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
@Table(name = "alumno")
public class Student extends ClassIns implements IDAO_UNO {

	@Id
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "age")
	private int age;
	
	public Student() {
		super();
	
		
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void create(ClassIns ins,int id, String nombre, String segundo, int valor) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Student.class);

		try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			setId(id);
			setName(nombre);
			setLastname(segundo);
			setAge(valor);
			session.save(this);
			session.getTransaction().commit();
		}

	}

	@Override
	public ClassIns read(ClassIns ins, int id) {
		
		 Configuration configuration = new Configuration();
		    configuration.configure("hibernate.cfg.xml");
		    configuration.addAnnotatedClass(Student.class);
		    
		    try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
		        Session session = sessionFactory.openSession();
		        session.beginTransaction();

		        Student student = session.find(Student.class, id);
		        session.getTransaction().commit();
		        
		        if (student != null) {
		            System.out.println("ID: " + student.getId());
		            System.out.println("Nombre: " + student.getName());
		            System.out.println("Apellido: " + student.getLastname());
		            System.out.println("Edad: " + student.getAge());
		        } else {
		            System.out.println("No se encontró ningún estudiante con el ID proporcionado.");
		        }

		        return student;
		    } catch (HibernateException e) {
		        // Manejo de excepciones
		        e.printStackTrace();
		        return null;
		    }
	}

	@Override
	public void update(ClassIns ins, int id, String actualizar) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Student.class);

		try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			ins = session.find(Student.class, id);
			ins.setName(actualizar);
			session.update(ins);
			session.getTransaction().commit();
		}
	}

	@Override
	public void delete(ClassIns ins, int id) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Student.class);

		try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			ins = session.find(Student.class, id);
			session.delete(ins);
			session.getTransaction().commit();
		}

	}

}
