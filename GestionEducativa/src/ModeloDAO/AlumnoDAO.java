package ModeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Config.Conexion;
import Entidad.Alumno;
import Entidad.Localidad;
import Entidad.User;
import Entidad.Usuario;
import Interfaces.CRUD_ALUMNO;

public class AlumnoDAO implements CRUD_ALUMNO {
	
	private PreparedStatement pst =null;
	private ResultSet rs = null;
	private String mensaje ="";
	
	Alumno alumno = new Alumno();
	Localidad l = new Localidad();
	User user = new User();

	Conexion conexion = new Conexion();
	
	@Override
	public List listadoAlumno() {
		ArrayList<Alumno> lst = new ArrayList<>();
		try {//cambiar la consulta y traer solo las filas solicitadas 
			//mostrar en html solo las solicitadas
			rs = conexion.ConsultaRS("SELECT * FROM ALUMNO WHERE ESTADO='1'");
			while(rs.next()) {
				Alumno u = new Alumno();
				Localidad loc = new Localidad();
				User us = new User();
				u.setId(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setApellido(rs.getString(3));
				u.setDni(rs.getString(4));
				loc.setId(rs.getInt(5));
			    u.setLocalidad(loc);
				u.setFechaNac(rs.getDate(6));
				u.setEmail(rs.getString(7));
				u.setTelefono(rs.getString(8));
				u.setDireccion(rs.getString(9));
				u.setSexo(rs.getString(10));
				us.setId(rs.getInt(11));
				u.setUser(us);
				u.setEstado(rs.getBoolean(12));
				u.setLegajo(rs.getString(13));
				u.setCarrera(rs.getString(14));
				u.setFechaInscripcion(rs.getDate(15));
				
				lst.add(u);
			}
			rs.close();
		} catch (Exception e) {
			
		}
		return lst;
	}

	@Override
	public Alumno buscarAlumno(int id) {
		try {
			rs = conexion.ConsultaRS("SELECT * FROM ALUMNO WHERE IDALUMNO="+id);
			rs.next();
			alumno.setId(rs.getInt(1));
			alumno.setNombre(rs.getString(2));
			alumno.setApellido(rs.getString(3));
			alumno.setDni(rs.getString(4));
			l.setId(rs.getInt(5));
			alumno.setLocalidad(l);
			alumno.setFechaNac(rs.getDate(6));
			alumno.setEmail(rs.getString(7));
			alumno.setTelefono(rs.getString(8));
			alumno.setDireccion(rs.getString(9));
			alumno.setSexo(rs.getString(10));
			user.setId(rs.getInt(11));
			alumno.setUser(user);
			alumno.setEstado(rs.getBoolean(12));
			alumno.setLegajo(rs.getString(13));
			alumno.setCarrera(rs.getString(14));
			alumno.setFechaInscripcion(rs.getDate(15));
			rs.close();
		} catch (Exception e) {
			
		}
		return alumno;
	}
	public Alumno buscarAlumnoUser(int id) {
		try {
			rs = conexion.ConsultaRS("SELECT * FROM ALUMNO WHERE IDUSER="+id);
			rs.next();
			alumno.setId(rs.getInt(1));
			alumno.setNombre(rs.getString(2));
			alumno.setApellido(rs.getString(3));
			alumno.setDni(rs.getString(4));
			l.setId(rs.getInt(5));
			alumno.setLocalidad(l);
			alumno.setFechaNac(rs.getDate(6));
			alumno.setEmail(rs.getString(7));
			alumno.setTelefono(rs.getString(8));
			alumno.setDireccion(rs.getString(9));
			alumno.setSexo(rs.getString(10));
			user.setId(rs.getInt(11));
			alumno.setUser(user);
			alumno.setEstado(rs.getBoolean(12));
			alumno.setLegajo(rs.getString(13));
			alumno.setCarrera(rs.getString(14));
			alumno.setFechaInscripcion(rs.getDate(15));
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return alumno;
	}

	@Override
	public String registerAlumno(Alumno alumno) {
			String consulta="INSERT INTO ALUMNO (NOMBRE,APELLIDO,DNI,IDLOCALIDAD,FECHANAC,EMAIL,TELEFONO,"
					+ "DIRECCION,SEXO,IDUSER,ESTADO,LEGAJO,CARRERA,FECHAINSCRIPCION) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
			  pst = conexion.ConsultaPST(consulta);
			  
			  pst.setString(1, alumno.getNombre());
			  pst.setString(2, alumno.getApellido());
			  pst.setString(3, alumno.getDni());
			  pst.setInt(4,alumno.getLocalidad().getId());
			  pst.setDate(5, alumno.getFechaNac());
			  pst.setString(6, alumno.getEmail());
			  pst.setString(7, alumno.getTelefono());
			  pst.setString(8, alumno.getDireccion());
			  pst.setString(9, alumno.getSexo());
			  pst.setInt(10, alumno.getUser().getId());
			  pst.setBoolean(11, alumno.getEstado());
			  pst.setString(12, alumno.getLegajo());
			  pst.setString(13, alumno.getCarrera());
			  pst.setDate(14, alumno.getFechaInscripcion());
			  pst.execute();
			  mensaje = "SE REGISTRO CON EXITO";
			  pst.close();
			  
			  
			} catch (Exception e) {
				mensaje = "ERROR AL REGISTRAR: "+ e.getMessage();
			}
		return mensaje;
	}

	@Override
	public String updateAlumno(Alumno alumno) {
		String consulta="UPDATE ALUMNO SET NOMBRE=?,APELLIDO=?,IDLOCALIDAD=?,FECHANAC=?,EMAIL=?,TELEFONO=?, DIRECCION=?,SEXO=?,CARRERA=? WHERE IDALUMNO=?";
		try {
		  pst = conexion.ConsultaPST(consulta);
	
		  pst.setString(1, alumno.getNombre());
		  pst.setString(2, alumno.getApellido());
//		  pst.setString(3, alumno.getDni());
		  pst.setInt(3,alumno.getLocalidad().getId());
		  pst.setDate(4, alumno.getFechaNac());
		  pst.setString(5, alumno.getEmail());
		  pst.setString(6, alumno.getTelefono());
		  pst.setString(7, alumno.getDireccion());
		  pst.setString(8, alumno.getSexo());
//		  pst.setInt(10, alumno.getUser().getId());
//		  pst.setBoolean(11, alumno.getEstado());
//		  pst.setString(12, alumno.getLegajo());
		  pst.setString(9, alumno.getCarrera());
//		  pst.setDate(14, alumno.getFechaInscripcion());
		  pst.setInt(10, alumno.getId());
		  pst.execute();
		  mensaje = "SE ACTUALIZO CON EXITO";
		  pst.close();
		  
		  
		} catch (Exception e) {
			mensaje = "ERROR AL ACTUALIZAR : "+ e.getMessage();
		}
	return mensaje;

	}

	@Override
	public String deleteAlumno(Alumno alumno) {
		String consulta="UPDATE ALUMNO SET ESTADO=? WHERE IDALUMNO=?";
			try {
			  pst = conexion.ConsultaPST(consulta);
			  pst.setBoolean(1, alumno.getEstado());
			  pst.setInt(2, alumno.getId());
			  pst.execute();
			  mensaje = "SE ELIMINO CON EXITO";
			  pst.close();
			  
			  
			} catch (Exception e) {
				mensaje = "ERROR AL ELIMINAR : "+ e.getMessage();
			}
		return mensaje;
	}

}
