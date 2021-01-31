package Interfaces;

import java.util.List;

import Entidad.Alumno;

public interface CRUD_ALUMNO {
	public List listadoAlumno();
	public Alumno buscarAlumno(int id);
	public String registerAlumno(Alumno alumno);
	public String updateAlumno(Alumno alumno);
	public String deleteAlumno(Alumno alumno);
}
