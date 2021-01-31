package ModeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Config.Conexion;
import Entidad.Curso;
import Entidad.Materia;
import Entidad.Usuario;
import Interfaces.CRUD_CURSOS;

public class CursoDAO implements CRUD_CURSOS {

	private PreparedStatement pst=null;
	private ResultSet rs =null;
	private String mensaje="";
	
	Conexion conexion = new Conexion();
	
	Curso curso = new Curso();
	
	@Override
	public List listadoCursos() {
		ArrayList<Curso> lst = new ArrayList<>();
		try {
			rs = conexion.ConsultaRS("SELECT * FROM CURSO WHERE ESTADO='1'");
			while(rs.next()) {
				Curso c = new Curso();
				Materia m = new Materia();
				Usuario u = new Usuario();
				
				c.setId(rs.getInt(1));
				c.setNombre(rs.getString(2));
				m.setId(rs.getInt(3));
				c.setMateria(m);
				c.setSemestre(rs.getString(4));
				c.setAnio(rs.getInt(5));
				u.setId(rs.getInt(6));
				c.setProfesor(u);
				c.setEstado(rs.getBoolean(7));
				lst.add(c);
			}
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lst;
	}

	public List listadoCursosProfesor(int id) {
		ArrayList<Curso> lst = new ArrayList<>();
		try {
			rs = conexion.ConsultaRS("SELECT * FROM CURSO WHERE ESTADO='1' AND IDPROFESOR='"+id+"'");
			while(rs.next()) {
				Curso c = new Curso();
				Materia m = new Materia();
				Usuario u = new Usuario();
				
				c.setId(rs.getInt(1));
				c.setNombre(rs.getString(2));
				m.setId(rs.getInt(3));
				c.setMateria(m);
				c.setSemestre(rs.getString(4));
				c.setAnio(rs.getInt(5));
				u.setId(rs.getInt(6));
				c.setProfesor(u);
				c.setEstado(rs.getBoolean(7));
				lst.add(c);
			}
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lst;
	}
	public int cantidadCursosProfesor(int id) {
		int cantFilas=0;
		rs = conexion.ConsultaRS("SELECT count(*) as total FROM CURSO WHERE ESTADO='1' AND IDPROFESOR='"+id+"'");
		try {
			if(rs.next()) {
				cantFilas = Integer.parseInt(rs.getString("total"));
			}else {
				cantFilas = 0;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cantFilas;
	}

	@Override
	public Curso buscarCurso(int id) {
		try {
			rs = conexion.ConsultaRS("SELECT * FROM CURSO WHERE IDCURSO="+id);
			rs.next();
				Materia m = new Materia();
				Usuario u = new Usuario();
				
				curso.setId(rs.getInt(1));
				curso.setNombre(rs.getString(2));
				m.setId(rs.getInt(3));
				curso.setMateria(m);
				curso.setSemestre(rs.getString(4));
				curso.setAnio(rs.getInt(5));
				u.setId(rs.getInt(6));
				curso.setProfesor(u);
				curso.setEstado(rs.getBoolean(7));
			rs.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return curso;
	}

	public Curso buscarCursoNombre(String nombre) {
		try {
			rs = conexion.ConsultaRS("SELECT * FROM CURSO WHERE nombre='"+nombre+"'");
			rs.next();
				Materia m = new Materia();
				Usuario u = new Usuario();
				
				curso.setId(rs.getInt(1));
				curso.setNombre(rs.getString(2));
				m.setId(rs.getInt(3));
				curso.setMateria(m);
				curso.setSemestre(rs.getString(4));
				curso.setAnio(rs.getInt(5));
				u.setId(rs.getInt(6));
				curso.setProfesor(u);
				curso.setEstado(rs.getBoolean(7));
			rs.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return curso;
	}
	
	@Override
	public String registrarCurso(Curso curso) {
		
		String consulta="INSERT INTO CURSO (NOMBRE,IDMATERIA,SEMESTRE,ANIO,IDPROFESOR,ESTADO) VALUES (?,?,?,?,?,?)";
		try {
			pst = conexion.ConsultaPST(consulta);
			pst.setString(1, curso.getNombre());
			pst.setInt(2, curso.getMateria().getId());
			pst.setString(3, curso.getSemestre());
			pst.setInt(4, curso.getAnio());
			pst.setInt(5, curso.getProfesor().getId());
			pst.setBoolean(6, curso.isEstado());
			pst.execute();
			mensaje = "SE REGISTRO CON EXITO";
			pst.close();
		} catch (Exception e) {
			mensaje = "ERROR AL REGISTRAR "+ e.getMessage();
		}
		return mensaje;
	}

	@Override
	public String updateCurso(Curso curso) {
		String consulta="UPDATE CURSO SET NOMBRE=?,IDMATERIA=?,SEMESTRE=?,ANIO=?,IDPROFESOR=?,ESTADO=? WHERE IDCURSO=?";
		try {
			pst = conexion.ConsultaPST(consulta);
			pst.setString(1, curso.getNombre());
			pst.setInt(2, curso.getMateria().getId());
			pst.setString(3, curso.getSemestre());
			pst.setInt(4, curso.getAnio());
			pst.setInt(5, curso.getProfesor().getId());
			pst.setBoolean(6, curso.isEstado());
			pst.setInt(7, curso.getId());
			pst.execute();
			mensaje = "SE ACTUALIZO CON EXITO";
			pst.close();
		} catch (Exception e) {
			mensaje = "ERROR AL ACTUALIZAR "+ e.getMessage();
		}
		return mensaje;
	}

	@Override
	public String deldeteCurso(Curso curso) {
		String consulta="UPDATE CURSO SET ESTADO=? WHERE IDCURSO=?";
		try {
			pst = conexion.ConsultaPST(consulta);
			pst.setBoolean(1, curso.isEstado());
			pst.setInt(2, curso.getId());
			pst.execute();
			mensaje = "SE ELIMINO CON EXITO";
			pst.close();
		} catch (Exception e) {
			mensaje = "ERROR AL ELIMINAR "+ e.getMessage();
		}
		return mensaje;
	}

}
