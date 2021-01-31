package ModeloDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Config.Conexion;
import Entidad.Localidad;
import Entidad.Provincia;
import Interfaces.CRUD_PROVINCIAS;

public  class ProvinciaDAO implements CRUD_PROVINCIAS{

	private ResultSet rs = null;
	
	Provincia provincia = new Provincia();
	Conexion conexion = new Conexion();
	
	@Override
	public List ListadoProvincias() {
		ArrayList<Provincia> lst = new ArrayList<>();
		try {
			rs = conexion.ConsultaRS("SELECT * FROM PROVINCIA");
			while(rs.next()) {
				Provincia p = new Provincia();
				p.setId(rs.getInt(1));
				p.setNombre(rs.getString(2));
				lst.add(p);
			}
			rs.close();
		} catch (Exception e) {
			
		}
		return lst;
	}

	@Override
	public Provincia buscarProvincia(int id) {
		try {
			rs = conexion.ConsultaRS("SELECT * FROM PROVINCIA WHERE ID="+id);
			rs.next();
			provincia.setId(rs.getInt(1));
			provincia.setNombre(rs.getString(2));
			rs.close();
		} catch (Exception e) {
		}
		return provincia;
	}


}
