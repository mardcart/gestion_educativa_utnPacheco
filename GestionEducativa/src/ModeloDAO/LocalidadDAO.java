package ModeloDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Config.Conexion;
import Entidad.Localidad;
import Entidad.Provincia;
import Interfaces.CRUD_LOCALIDADES;

public class LocalidadDAO implements CRUD_LOCALIDADES{

	private ResultSet rs = null;
	
	Conexion conexion = new Conexion();
	
	Localidad loc = new Localidad();
	
	
	@Override
	public List listadoLocalidades() {
		ArrayList<Localidad> lst = new ArrayList<>();
		try {
			rs = conexion.ConsultaRS("SELECT * FROM LOCALIDADES");
			while(rs.next()) {
					Localidad l = new Localidad();
					Provincia p = new Provincia();
					l.setId(rs.getInt(1));
					p.setId(rs.getInt(2));
					l.setIdProvincia(p);
					l.setNombre(rs.getString(3));
					lst.add(l);
					
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lst;
	}

	@Override
	public Localidad buscarLocalidad(int id) {
		try {
			rs = conexion.ConsultaRS("SELECT * FROM LOCALIDADES WHERE ID="+id);
			rs.next();
			Provincia p = new Provincia();
			loc.setId(rs.getInt(1));
			p.setId(rs.getInt(2));
			loc.setIdProvincia(p);
			loc.setNombre(rs.getString(3));
			
			
			rs.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return loc;
	}

	@Override
	public List listadoLocPedido(int idProvincia) {
		ArrayList<Localidad> lst = new ArrayList<>();
		try {
			rs = conexion.ConsultaRS("SELECT * FROM LOCALIDADES WHERE IDPROVINCIA="+idProvincia);
			while(rs.next()) {
					Localidad l = new Localidad();
					Provincia p = new Provincia();
					l.setId(rs.getInt(1));
					p.setId(rs.getInt(2));
					l.setIdProvincia(p);
					l.setNombre(rs.getString(3));
					lst.add(l);
					
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lst;
	}

}
