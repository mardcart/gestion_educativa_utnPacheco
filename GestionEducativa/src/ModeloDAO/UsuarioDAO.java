package ModeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Config.Conexion;
import Entidad.Localidad;
import Entidad.User;
import Entidad.Usuario;
import Interfaces.CRUD_USUARIO;

public class UsuarioDAO implements CRUD_USUARIO {
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private String mensaje ="";
	
	Conexion conexion = new Conexion();
	Usuario user = new Usuario();
	Localidad loc = new Localidad();
	User u = new User();
	
	@Override
	public List listadoUsuarioAdm() {
		ArrayList<Usuario> lst = new ArrayList<>();
		try {
			rs = conexion.ConsultaRS("SELECT * FROM USUARIO WHERE ESTADO='1'");
			while(rs.next()) {
				Usuario us = new Usuario();
				Localidad l = new Localidad();
				User use = new User();

				us.setId(rs.getInt(1));
				us.setNombre(rs.getString(2));
				us.setApellido(rs.getString(3));
				us.setDni(rs.getString(4));
				l.setId(rs.getInt(5));
				us.setLocalidad(l);
				us.setFechaNac(rs.getDate(6));
				us.setEmail(rs.getString(7));
				us.setTelefono(rs.getString(8));
				us.setDireccion(rs.getString(9));
				us.setSexo(rs.getString(10));
				use.setId(rs.getInt(11));
				us.setUser(use);
				us.setEstado(rs.getBoolean(12));
				us.setProfesion(rs.getString(13));
				us.setFechaAlta(rs.getDate(14));
				us.setArea(rs.getString(15));
				lst.add(us);
				}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lst;
	}

	public List listadoProfesores() {
		ArrayList<Usuario> lst = new ArrayList<>();
		try {
			rs = conexion.ConsultaRS("SELECT * FROM USUARIO WHERE ESTADO='1' and area='DOCENTE'");
			while(rs.next()) {
				Usuario us = new Usuario();
				Localidad l = new Localidad();
				User use = new User();

				us.setId(rs.getInt(1));
				us.setNombre(rs.getString(2));
				us.setApellido(rs.getString(3));
				us.setDni(rs.getString(4));
				l.setId(rs.getInt(5));
				us.setLocalidad(l);
				us.setFechaNac(rs.getDate(6));
				us.setEmail(rs.getString(7));
				us.setTelefono(rs.getString(8));
				us.setDireccion(rs.getString(9));
				us.setSexo(rs.getString(10));
				use.setId(rs.getInt(11));
				us.setUser(use);
				us.setEstado(rs.getBoolean(12));
				us.setProfesion(rs.getString(13));
				us.setFechaAlta(rs.getDate(14));
				us.setArea(rs.getString(15));
				lst.add(us);
				}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lst;
	}

	@Override
	public Usuario buscarUsuarioAdm(int id) {
		try {
			rs = conexion.ConsultaRS("SELECT * FROM USUARIO WHERE IDUSUARIO="+id);
			rs.next();
			user.setId(rs.getInt(1));
			user.setNombre(rs.getString(2));
			user.setApellido(rs.getString(3));
			user.setDni(rs.getString(4));
			loc.setId(rs.getInt(5));
			user.setLocalidad(loc);
			user.setFechaNac(rs.getDate(6));
			user.setEmail(rs.getString(7));
			user.setTelefono(rs.getString(8));
			user.setDireccion(rs.getString(9));
			user.setSexo(rs.getString(10));
			u.setId(rs.getInt(11));
			user.setUser(u);
			user.setEstado(rs.getBoolean(12));
			user.setProfesion(rs.getString(13));
			user.setFechaAlta(rs.getDate(14));
			user.setArea(rs.getString(15));
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return user;
	}
	public Usuario buscarUsuarioUser(int id) {
		try {
			rs = conexion.ConsultaRS("SELECT * FROM USUARIO WHERE IDUSER="+id);
			rs.next();
			user.setId(rs.getInt(1));
			user.setNombre(rs.getString(2));
			user.setApellido(rs.getString(3));
			user.setDni(rs.getString(4));
			loc.setId(rs.getInt(5));
			user.setLocalidad(loc);
			user.setFechaNac(rs.getDate(6));
			user.setEmail(rs.getString(7));
			user.setTelefono(rs.getString(8));
			user.setDireccion(rs.getString(9));
			user.setSexo(rs.getString(10));
			u.setId(rs.getInt(11));
			user.setUser(u);
			user.setEstado(rs.getBoolean(12));
			user.setProfesion(rs.getString(13));
			user.setFechaAlta(rs.getDate(14));
			user.setArea(rs.getString(15));
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return user;
	}

	@Override
	public String registrarUsuarioAdm(Usuario user) {
		
		String consulta = "INSERT INTO USUARIO (NOMBRE,APELLIDO,DNI,IDLOCALIDAD,FECHANAC,EMAIL,TELEFONO," + 
           "DIRECCION,SEXO,IDUSER,ESTADO,PROFESION,FECHAALTA,AREA) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pst = conexion.ConsultaPST(consulta);
			  pst.setString(1, user.getNombre());
			  pst.setString(2, user.getApellido());
			  pst.setString(3, user.getDni());
			  pst.setInt(4, user.getLocalidad().getId());
			  pst.setDate(5, user.getFechaNac());
			  pst.setString(6, user.getEmail());
			  pst.setString(7, user.getTelefono());
			  pst.setString(8, user.getDireccion());
			  pst.setString(9, user.getSexo());
			  pst.setInt(10, user.getUser().getId());
			  pst.setBoolean(11, user.getEstado());
			  pst.setString(12, user.getProfesion());
			  pst.setDate(13, user.getFechaAlta());
			  pst.setString(14, user.getArea());
			  pst.execute();
			  mensaje = "SE REGISTRO CON EXITO";
			  pst.close();
			  
		} catch (Exception e) {
			 mensaje = "ERROR AL REGISTRAR :"+e.getMessage();
		}
		
		return mensaje;
	}

	@Override
	public String updateUsuarioAdm(Usuario user) {
		String consulta = "UPDATE USUARIO SET NOMBRE=?,APELLIDO=?,IDLOCALIDAD=?,FECHANAC=?,EMAIL=?,TELEFONO=?," + 
		           "DIRECCION=?,SEXO=?,PROFESION=?,AREA=? WHERE IDUSUARIO=?";
				try {
					pst = conexion.ConsultaPST(consulta);
					  pst.setString(1, user.getNombre());
					  pst.setString(2, user.getApellido());
					  
					  pst.setInt(3, user.getLocalidad().getId());
					  pst.setDate(4, user.getFechaNac());
					  pst.setString(5, user.getEmail());
					  pst.setString(6, user.getTelefono());
					  pst.setString(7, user.getDireccion());
					  pst.setString(8, user.getSexo());
					  pst.setString(9, user.getProfesion());
					  pst.setString(10, user.getArea());
					  pst.setInt(11, user.getId());
					  pst.execute();
					  mensaje = "SE ACTUALIZO  CON EXITO";
					  pst.close();
					  
				} catch (Exception e) {
					 mensaje = "ERROR AL ACTUALIZAR :"+e.getMessage();
				}
				
				return mensaje;
	}

	@Override
	public String deleteUsuarioAdm(Usuario user) {
		String consulta = "UPDATE USUARIO SET ESTADO=? WHERE IDUSUARIO=?";
				try {
					pst = conexion.ConsultaPST(consulta);
					  pst.setBoolean(1, user.getEstado());
					  pst.setInt(2, user.getId());
					  pst.execute();
					  mensaje = "SE ELIMINO  CON EXITO";
					  pst.close();
					  
				} catch (Exception e) {
					 mensaje = "ERROR AL ELIMINAR :"+e.getMessage();
				}
				
				return mensaje;
	}

	
}
