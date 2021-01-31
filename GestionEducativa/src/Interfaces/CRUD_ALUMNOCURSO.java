package Interfaces;

import java.util.List;

import Entidad.AlumnoCurso;

public interface CRUD_ALUMNOCURSO {
	public List listadoAlCurso();
	public AlumnoCurso buscarAlumnoCurso(int id);
	public boolean insertInscripcion(AlumnoCurso ac);
	public boolean updateInscripcion(AlumnoCurso ac);
	public boolean deleteInscripcion(AlumnoCurso ac);

}
