package Package.controlador;

import Package.modelo.Professor;
import Package.modelo.Schedule;
import Package.modelo.Student;
import Package.modelo.Subject;

public class Container {

	Student student = new Student();
	Professor profe = new Professor();
	Subject materia = new Subject();
	Schedule horario = new Schedule();

	public Container() {

	}

	public void createStudent(int id, String name, String lastName, int age) {
		student.create(student, id, name, lastName, age);
		// profe.create(profe,3, "Dayanna", "Cevallos", 27);
		// materia.create(1, "Matematicas Avanzada", "Derivadas e INTEGRALES", 4);
		// materia.create(materia, 6, "Dibujo", "Paisaje", 1);
		// horario.create(2, 1, 1, "9 am", "11 am", "Martes");

	}

	public void createProfessor(int id, String name, String lastName, int age) {
		profe.create(profe, id, name, lastName, age);
	}

	public void createMateria(int id_materia, String name_materia, String descripcion_materia, int level) {

		materia.create(materia, id_materia, name_materia, descripcion_materia, level);
	}

	public void createHorario(int id_materia, int id_Al, int id_profe, String horaInicio, String horafinal,
			String dia) {
		horario.create(id_materia, id_Al, id_profe, horaInicio, horafinal, dia);

	}

	public void readStudent(int id) {
		student.read(student, id);

	}

	public void readProfessor(int id) {
		profe.read(profe, 1);

	}

	public void readMateria(int id) {
		materia.read(materia, id);

	}

	public void readHorario(int id_horario) {
		horario.read(horario, id_horario);

	}

	public void updateStudent(int id, String name) {
		student.update(student, id, name);

	}

	public void updateProfessor(int id, String name) {
		profe.update(profe, id, name);

	}

	public void updateMateria(int id, String name) {
		materia.update(materia, id, name);

	}

	public void updateHorario(int id, String name) {
		horario.update(horario, id, name);

	}

	public void deleteStudent(int id) {
		student.delete(id);

	}

	public void deleteProfessor(int id) {
		profe.delete(id);

	}
	
	public void deleteMateria(int id) {
		materia.delete(id);

	}
	public void deleteHorario(int id) {
		horario.delete(id);

	}

}
