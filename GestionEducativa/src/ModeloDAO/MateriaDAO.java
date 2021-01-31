package ModeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Config.Conexion;
import Entidad.Materia;
import Interfaces.CRUD_MATERIA;

public class MateriaDAO implements CRUD_MATERIA {

	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private String mensaje ="";
	
	Conexion conexion = new Conexion();
	
	Materia materia = new Materia();
	
	@Override
	public List listadoMaterias() {
		ArrayList<Materia> lst = new ArrayList<>();
		try {
			rs = conexion.ConsultaRS("SELECT * FROM MATERIA WHERE ESTADO='1'");
			while(rs.next()) {
				Materia m = new Materia();
				m.setId(rs.getInt(1));
				m.setNombre(rs.getString(2));
				m.setEstado(rs.getBoolean(3));
				lst.add(m);
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lst;
	}

	@Override
	public Materia buscarMateria(int id) {
		try {
			rs = conexion.ConsultaRS("SELECT * FROM MATERIA WHERE IDMATERIA="+id);
			rs.next();
			materia.setId(rs.getInt(1));
			materia.setNombre(rs.getString(2));
			materia.setEstado(rs.getBoolean(3));
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return materia;
	}

	@Override
	public String registrarMateria(Materia materia) {
		
		String consulta = "INSERT INTO MATERIA (NOMBRE,ESTADO) VALUES (?,?)";
		try {
			pst = conexion.ConsultaPST(consulta);
			pst.setString(1, materia.getNombre());
			pst.setBoolean(2, materia.isEstado());
			pst.execute();
			mensaje = "SE REGISTRO CON EXITO";
			pst.close();
		} catch (Exception e) {
			mensaje = "ERROR AL REGISTRAR "+ e.getMessage();
		}
		
		
		return mensaje;
	}

	@Override
	public String updateMateria(Materia materia) {
		String consulta = "UPDATE MATERIA SET NOMBRE=?,ESTADO=?";
		try {
			pst = conexion.ConsultaPST(consulta);
			pst.setString(1, materia.getNombre());
			pst.setBoolean(2, materia.isEstado());
			pst.setInt(3, materia.getId());
			pst.execute();
			mensaje = "SE ACTUALIZO CON EXITO";
			pst.close();
		} catch (Exception e) {
			mensaje = "ERROR AL ACTUALIZAR: "+ e.getMessage();
		}
		
		
		return mensaje;
	}

	@Override
	public String deleteMateria(Materia materia) {
		String consulta = "UPDATE MATERIA SET ESTADO=? WHERE IDMATERIA=?";
		try {
			pst = conexion.ConsultaPST(consulta);
			
			pst.setBoolean(1, materia.isEstado());
			pst.setInt(2, materia.getId());
			pst.execute();
			mensaje = "SE ELIMINO CON EXITO";
			pst.close();
		} catch (Exception e) {
			mensaje = "ERROR AL ELIMINAR: "+ e.getMessage();
		}
		
		
		return mensaje;
	}

}
