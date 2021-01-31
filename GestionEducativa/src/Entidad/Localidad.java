package Entidad;

public class Localidad {
	private int id;
	private Provincia idProvincia;
	private String nombre;
	
	
	public Localidad() {
		
	}
	public Localidad(int id, Provincia idProvincia, String nombre) {
		
		this.id = id;
		this.idProvincia = idProvincia;
		this.nombre = nombre;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Provincia getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Provincia idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Localidad [id=" + id + ", idProvincia=" + idProvincia + ", nombre=" + nombre + "]";
	}	
	

}
