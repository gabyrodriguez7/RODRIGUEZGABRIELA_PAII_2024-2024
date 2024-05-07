package Package.Interfaz;

import Package.modelo.ClassIns;

public interface IDAOschedule {

	void create(int id_materia, int id_Al, int id_profe, String horaInicio, String horafinal, String dia);

	void read(ClassIns person,int id_horario);

	void update(ClassIns ins, int id, String name);

	void delete(int id);

}
