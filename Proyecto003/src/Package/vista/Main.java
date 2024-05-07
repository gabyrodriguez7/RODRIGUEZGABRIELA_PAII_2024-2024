package Package.vista;


import java.sql.SQLException;
import Package.controlador.Container;


public class Main {
	public static void main(String[] args) throws SQLException {
		
		Container cont = new Container();
		//cont.createStudent(2, "GA", "Rodriguez", 24);
		//cont.createProfessor(4, "Lin", "Yun", 45);
		//cont.createMateria(7, "Musica", "Pasillos", 1);
		//cont.createHorario(5, 3, 4, "7 am", "9 am", "Lunes");
		//cont.readStudent(2);
		//cont.readMateria(1);
		//cont.readProfessor(2);
		//cont.readHorario(2);
		//cont.updateStudent(2,"Lucho");
		//cont.readStudent(2);
		//cont.deleteStudent(2);
		//cont.readStudent(2);
		//cont.deleteProfessor(1);
		//cont.updateMateria(2, "EPU");
		//cont.updateHorario(1, "Viernes");
		//cont.deleteMateria(4);
		//cont.deleteHorario(2);
		//cont.updateMateria(0, "EDO");
		cont.updateProfessor(3, "Daya");
		
		
	}
}
