package Interfaces;

import java.util.List;

import Entidad.Prueba;

public interface CRUD_PRUEBA {
	public List listadoPrueba();
	public String registrar(Prueba p);
	public String update(Prueba p);
	public String delete(Prueba p);
}
