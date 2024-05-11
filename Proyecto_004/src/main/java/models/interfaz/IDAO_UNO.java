package models.interfaz;

import models.ClassIns;

public interface IDAO_UNO {
	
	void create(ClassIns ins,int id, String nombre,String segundo,int valor);
	ClassIns read(ClassIns ins,int id );
	void update(ClassIns ins,int id,String actualizar);
	void delete(ClassIns ins,int id );
	

}
