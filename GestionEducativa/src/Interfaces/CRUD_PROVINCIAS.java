package Interfaces;

import java.util.List;

import Entidad.Provincia;

public interface CRUD_PROVINCIAS {
	public List ListadoProvincias();
	public Provincia buscarProvincia(int id);

}
