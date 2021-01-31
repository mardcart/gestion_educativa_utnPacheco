package Interfaces;

import java.util.List;

import Entidad.User;


public interface CRUD_USER {
	public List listadoUser();
	public User buscarUser(int id);
	public boolean registerUser(User user);
	public String updateUser(User user);
	public String deleteUser(User user);


}
