package Entidad;

public class Prueba {
	private int id;
	private String nombre;
	private String apellido;
	private boolean estado;
	
	public Prueba(int id, String nombre, String apellido, boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.estado = estado;
	}
	
	public Prueba() {
		
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Prueba [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", estado=" + estado + "]";
	}

}
