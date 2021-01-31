package Entidad;

public class User {

	private int id;
	private String legajo;
	private String password;
	private String categoria;
	private boolean estado;
	
	public User() {
		
	}

	public User(int id, String legajo, String password, String categoria, boolean estado) {
		super();
		this.id = id;
		this.legajo = legajo;
		this.password = password;
		this.categoria = categoria;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", legajo=" + legajo + ", password=" + password + ", categoria=" + categoria
				+ ", estado=" + estado + "]";
	}
	
	
	
}
