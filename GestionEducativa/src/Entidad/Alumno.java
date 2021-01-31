package Entidad;

import java.sql.Date;

public class Alumno extends Persona {
	

	private String legajo;
	private String carrera;
	private Date fechaInscripcion;
	
	public Alumno() {
		
	}




	public Alumno(int id, String nombre, String apellido, String dni, Localidad localidad, Date fechaNac, String email,
			String telefono, String direccion, String sexo, User user, Boolean estado,String legajo,String carrera,Date fechaInscripcion) {
		super(id, nombre, apellido, dni, localidad, fechaNac, email, telefono, direccion, sexo, user, estado);
		this.legajo = legajo;
		this.carrera = carrera;
		this.fechaInscripcion=fechaInscripcion;
	}




	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(Date i) {
		this.fechaInscripcion = i;
	}

	@Override
	public String toString() {
		return "Alumno "+super.toString()+" [legajo=" + legajo + ", carrera=" + carrera + ", fechaInscripcion=" + fechaInscripcion + "]";
	}

	
	
	

	
	
	
}
