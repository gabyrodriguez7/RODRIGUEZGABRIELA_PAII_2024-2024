package controller;

import java.util.List;

import javax.swing.JOptionPane;

import models.Professor;
import models.Schedule;
import models.Student;
import models.Subject;

public class Container {

	Student estudiante = new Student();
	Professor profesor = new Professor();
	Subject materia = new Subject();
	Schedule horario = new Schedule();

	// STUDENT
	public void createStudent(int id, String name, String lastName, int age) {
		estudiante.create(estudiante, id, name, lastName, age);
	}

	public void readStudent(int id) {
		Student student = (Student) estudiante.read(estudiante, id);

	    if (student != null) {
	        String info = "ID: " + student.getId() + "\n" +
	                      "Nombre: " + student.getName() + "\n" +
	                      "Apellido: " + student.getLastname() + "\n" +
	                      "Edad: " + student.getAge();

	        JOptionPane.showMessageDialog(null, info, "Información del Estudiante", JOptionPane.INFORMATION_MESSAGE);
	    } else {
	        JOptionPane.showMessageDialog(null, "No se encontró ningún estudiante con el ID proporcionado.", "Error",
	                JOptionPane.ERROR_MESSAGE);
	    }

	}

	public void updateStudent(int id, String actualizar) {
		estudiante.update(estudiante, id, actualizar);

	}

	public void deleteStudent(int id) {
		estudiante.delete(estudiante, id);

	}
	// PROFESSOR

	public void createProfessor(int id, String name, String lastName, int age) {
		profesor.create(profesor, id, name, lastName, age);
	}

	public void readProfessor(int id) {
		Professor professor = (Professor) profesor.read(profesor, id);

		if (professor != null) {
			
			String info = "ID: " + professor.getId() + "\n" + "Nombre: " + professor.getName() + "\n" + "Apellido: "
					+ professor.getLastname() + "\n" + "Edad: " + professor.getAge();

			JOptionPane.showMessageDialog(null, info, "Información del Profesor", JOptionPane.INFORMATION_MESSAGE);
		} else {

			String error = "No se encontró ningún profesor con el ID proporcionado.";
			JOptionPane.showMessageDialog(null, error, "ERROR.!",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void updateProfessor(int id, String actualizar) {
		profesor.update(profesor, id, actualizar);

	}

	public void deleteProfessor(int id) {
		profesor.delete(profesor, id);

	}
	// SUBJECT

	public void createSubject(int id, String name, String lastName, int age) {
		materia.create(materia, id, name, lastName, age);
	}

	public void readSubject(int id) {
		 Subject subject = (Subject) materia.read(materia, id);

		    if (subject != null) {
		        String info = "ID: " + subject.getId() + "\n" +
		                      "Nombre: " + subject.getName() + "\n" +
		                      "Descripción: " + subject.getDescripcion() + "\n" +
		                      "Nivel: " + subject.getLevel();

		        JOptionPane.showMessageDialog(null, info, "Información de la Materia", JOptionPane.INFORMATION_MESSAGE);
		    } else {
		        JOptionPane.showMessageDialog(null, "No se encontró ninguna materia con el ID proporcionado.", "Error",
		                JOptionPane.ERROR_MESSAGE);
		    }

	}

	public void updateSubject(int id, String actualizar) {
		materia.update(materia, id, actualizar);

	}

	public void deleteSubject(int id) {
		materia.delete(materia, id);

	}
	// SCHEDULE

	public void createSchedule(int id, int id2, int id3, String hora_inicio, String hora_fin, String dia) {
		horario.create(id, id2, id3, hora_inicio, hora_fin, dia);
	}

	public void readSchedule(int id) {
		List<Schedule> horarios = horario.read(id);

	    if (horarios != null && !horarios.isEmpty()) {
	        for (Schedule horario : horarios) {
	            String info = "ID Materia: " + horario.getId_materia() + "\n" +
	                          "ID Alumno: " + horario.getId_Al() + "\n" +
	                          "ID Profesor: " + horario.getId_profe() + "\n" +
	                          "Hora de inicio: " + horario.getHora_inicio() + "\n" +
	                          "Hora de fin: " + horario.getHora_final() + "\n" +
	                          "Día: " + horario.getDia();

	            JOptionPane.showMessageDialog(null, info, "Información del Horario", JOptionPane.INFORMATION_MESSAGE);
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "No se encontraron registros de horario para el ID proporcionado.", "Error",
	                JOptionPane.ERROR_MESSAGE);
	    }

	}

	public void updateSchedule(int id, String actualizar) {
		horario.update(id, actualizar);

	}

	public void deleteSchedule(int id, int id2) {
		horario.delete(id, id2);

	}

}
