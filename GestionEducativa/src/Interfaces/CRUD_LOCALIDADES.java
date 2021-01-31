package Interfaces;

import java.util.List;

import Entidad.Localidad;

public interface CRUD_LOCALIDADES {
	public List listadoLocalidades();
	public Localidad buscarLocalidad(int id);
	public List listadoLocPedido(int idProvincia);
}
