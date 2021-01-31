package Entidad;

public class Provincia {
	private int id;
	private String nombre;
	
	public Provincia() {
		
	}
	public Provincia(int id, String nombre) {
	
		this.id = id;
		this.nombre = nombre;
		
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
	@Override
	public String toString() {
		return "Provincia [id=" + id + ", nombre=" + nombre +"]";
	}
	
	
}
