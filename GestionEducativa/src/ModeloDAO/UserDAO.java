package ModeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import Config.Conexion;
import Entidad.User;
import Interfaces.CRUD_USER;

public class UserDAO implements CRUD_USER {
	private PreparedStatement pst =null;
	private ResultSet rs = null;

	User user = new User();

	Conexion conexion = new Conexion();
	String mensaje = "";


	@Override
	public List listadoUser() {
		// TODO Auto-generated method stub
		return null;
	}
	//SELECT  * FROM USER WHERE LEGAJO='12121212' AND PASSWORD='12121212' 
	
	public 	String buscarLogueo(String username,String password) {
		String respuesta = "";
		String consulta = "SELECT  * FROM USER WHERE LEGAJO='"+ username+"' AND PASSWORD='"+password+"'";
		try {
			rs = conexion.ConsultaRS(consulta);
			rs.next();
			user.setId(rs.getInt(1));
			user.setLegajo(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setCategoria(rs.getString(4));
			user.setEstado(rs.getBoolean(5));
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		respuesta = user.getCategoria();
		
		return respuesta;
	}
	
	

	public 	User buscarUserLogueado(String username,String password) {
		String consulta = "SELECT  * FROM USER WHERE LEGAJO='"+ username+"' AND PASSWORD='"+password+"'";
		try {
			rs = conexion.ConsultaRS(consulta);
			rs.next();
			user.setId(rs.getInt(1));
			user.setLegajo(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setCategoria(rs.getString(4));
			user.setEstado(rs.getBoolean(5));
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return user;
	}

	
	@Override
	public User buscarUser(int id) {
		String consulta = "SELECT  * FROM USER WHERE IDUSER='"+id+"'";
		try {
			rs = conexion.ConsultaRS(consulta);
			rs.next();
			user.setId(rs.getInt(1));
			user.setLegajo(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setCategoria(rs.getString(4));
			user.setEstado(rs.getBoolean(5));
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return user;
	}

	@Override
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		String consulta="INSERT INTO USER (LEGAJO,PASSWORD,CATEGORIA,ESTADO ) VALUES (?,?,?,?)";
		try {
		  pst = conexion.ConsultaPST(consulta);
		  pst.setString(1, user.getLegajo());
		  pst.setString(2, user.getPassword());
		  pst.setString(3, user.getCategoria());
		  pst.setBoolean(4, user.isEstado());
		  pst.execute();
		  pst.close();
		  return true; 
		  
		} catch (Exception e) {
		 return false;		}		
		
	}

	public int buscarIdUltimo() {
		
		String consulta = "select count(*) from user";
		int numero=0;
		String valor ="";
		try {
			rs = conexion.ConsultaRS(consulta);
			if(rs.next()) {
				valor = rs.getString(1);
			}
			numero = Integer.parseInt(valor);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return numero;
	}
	@Override
	public String updateUser(User user) {
		String consulta="UPDATE USER SET PASSWORD=? WHERE IDUSER=?";
		try {
		  pst = conexion.ConsultaPST(consulta);
	
		  pst.setString(1, user.getPassword());
		  pst.setInt(2, user.getId());
		  pst.execute();
		  mensaje = "SE ACTUALIZO CON EXITO";
		  pst.close();
		  
		  
		} catch (Exception e) {
			mensaje = "ERROR AL ACTUALIZAR : "+ e.getMessage();
		}
	return mensaje;

	}


	@Override
	public String deleteUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
