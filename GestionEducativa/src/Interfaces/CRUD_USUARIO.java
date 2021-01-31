package Interfaces;

import java.util.List;

import Entidad.Usuario;

public interface CRUD_USUARIO {
	public List listadoUsuarioAdm();
	public Usuario buscarUsuarioAdm(int id);
	public String registrarUsuarioAdm(Usuario user);
	public String updateUsuarioAdm(Usuario user);
	public String deleteUsuarioAdm(Usuario user);
	
}
