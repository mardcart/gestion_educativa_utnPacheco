package Entidad;

import java.sql.Date;

public class Usuario extends Persona {
	
	private String profesion;
	private Date  fechaAlta;
	private String area;
	
	public Usuario() {
		
	}

	

	public Usuario(int id, String nombre, String apellido, String dni, Localidad localidad, Date fechaNac, String email,
			String telefono, String direccion, String sexo, User user, Boolean estado,String profesion,Date fechaAlta,String area) {
		super(id, nombre, apellido, dni, localidad, fechaNac, email, telefono, direccion, sexo, user, estado);
		this.profesion = profesion;
		this.fechaAlta = fechaAlta;
		this.area = area;
	}



	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}



	@Override
	public String toString() {
		return "Usuario "+ super.toString()+"[profesion=" + profesion + ", fechaAlta=" + fechaAlta + ", area=" + area + "]";
	}

	
	
	
}
