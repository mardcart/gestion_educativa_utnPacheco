package Interfaces;

import java.util.List;

import Entidad.Materia;

public interface CRUD_MATERIA {
	public List listadoMaterias();
	public Materia buscarMateria(int id);
	public String registrarMateria(Materia materia);
	public String updateMateria(Materia materia);
	public String deleteMateria(Materia materia);
}
