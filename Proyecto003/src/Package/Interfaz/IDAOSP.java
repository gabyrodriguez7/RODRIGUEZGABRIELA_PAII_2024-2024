package Package.Interfaz;

import Package.modelo.ClassIns;

public interface IDAOSP {
	
	
	void create(ClassIns ins,int id, String nombre,String last_name,int age);
	void read(ClassIns ins,int id );
	void update(ClassIns ins,int id,String name );
	void delete(int id );
	

	

}
