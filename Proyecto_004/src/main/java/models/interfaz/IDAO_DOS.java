package models.interfaz;

import java.util.List;

import models.Schedule;

public interface IDAO_DOS {
	
	void create(int id, int id2, int id3,String hora_inicio,String hora_fin,String dia);
	List<Schedule> read(int id );
	void update(int id,String actualizar);
	void delete(int id,int id2);
	

}
