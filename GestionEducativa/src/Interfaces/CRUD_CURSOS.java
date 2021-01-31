package Interfaces;

import java.util.List;

import Entidad.Curso;

public interface CRUD_CURSOS {
	public List listadoCursos();
	public Curso buscarCurso(int id);
	public String registrarCurso(Curso curso);
	public String updateCurso(Curso curso);
	public String deldeteCurso(Curso curso);
}
