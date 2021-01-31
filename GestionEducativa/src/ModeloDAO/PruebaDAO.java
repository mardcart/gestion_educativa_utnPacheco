package ModeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import Config.Conexion;
import Entidad.Prueba;
import Interfaces.CRUD_PRUEBA;

public class PruebaDAO implements CRUD_PRUEBA {
	
	private PreparedStatement pst =null;
	private ResultSet rs = null;
	private String mensaje ="";
	
	Conexion conexion = new Conexion();
	

	@Override
	public List listadoPrueba() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String registrar(Prueba p) {
		String consulta="INSERT INTO PRUEBA (NOMBRE,APELLIDO,ESTADO) VALUES (?,?,?)";
		try {
		  pst = conexion.ConsultaPST(consulta);
		  pst.setString(1, p.getNombre());
		  pst.setString(2, p.getApellido());
		  pst.setBoolean(3, p.isEstado());
		  pst.execute();
		  mensaje = "SE REGISTRO CON EXITO";
		  pst.close();
		  
		  
		} catch (Exception e) {
			mensaje = "ERROR AL REGISTRAR: "+ e.getMessage();
		}
	return mensaje;	}

	@Override
	public String update(Prueba p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Prueba p) {
		// TODO Auto-generated method stub
		return null;
	}

}
