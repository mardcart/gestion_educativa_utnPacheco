package Entidad;

import java.util.ArrayList;

public class Curso {

	private int id;
	private String nombre;
	private Materia materia;
	private String semestre;
	private int anio;
	private Usuario profesor;
	private boolean estado;
	private ArrayList<Alumno> alumno = new ArrayList<>();
	
	public Curso() {
		
	}
	public Curso(int id, String nombre, Materia materia, String semestre, int anio, Usuario profesor, boolean estado,
			ArrayList<Alumno> alumno) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.materia = materia;
		this.semestre = semestre;
		this.anio = anio;
		this.profesor = profesor;
		this.estado = estado;
		this.alumno = alumno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public Usuario getProfesor() {
		return profesor;
	}

	public void setProfesor(Usuario profesor) {
		this.profesor = profesor;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public ArrayList<Alumno> getAlumno() {
		return alumno;
	}

	public void setAlumno(ArrayList<Alumno> alumno) {
		this.alumno = alumno;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", materia=" + materia + ", semestre=" + semestre + ", anio="
				+ anio + ", profesor=" + profesor + ", estado=" + estado + ", alumno=" + alumno + "]";
	}

	
	
}
