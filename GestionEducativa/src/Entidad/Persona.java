package Entidad;

import java.sql.Date;

public class Persona {
	private int id;
	private String nombre;
	private String apellido;
	private String dni;
	private Localidad localidad;
	private  Date fechaNac;
	private String email;
	private String telefono;
	private String direccion;
	private String sexo;
	private User user;
	private Boolean estado;
	
	public Persona() {
		
	}

	public Persona(int id, String nombre, String apellido, String dni, Localidad localidad, Date fechaNac, String email,
			String telefono, String direccion, String sexo, User user, Boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.localidad = localidad;
		this.fechaNac = fechaNac;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		this.sexo = sexo;
		this.user = user;
		this.estado = estado;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", localidad="
				+ localidad + ", fechaNac=" + fechaNac + ", email=" + email + ", telefono=" + telefono + ", direccion="
				+ direccion + ", sexo=" + sexo + ", user=" + user + ", estado=" + estado + "]";
	}

	
		
}
