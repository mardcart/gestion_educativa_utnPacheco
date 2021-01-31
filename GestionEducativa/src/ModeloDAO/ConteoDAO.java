package ModeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Config.Conexion;
import Entidad.AlumnoCurso;

public class ConteoDAO {
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	Conexion conexion= new Conexion();
	AlumnoCurso ca = new AlumnoCurso();


	public int ConteoAlumnos() {
		int cantFilas=0;
		rs = conexion.ConsultaRS("SELECT count(*) as total FROM ALUMNO ");
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
	public int ConteoAlumnosActivos() {
		int cantFilas=0;
		rs = conexion.ConsultaRS("SELECT count(*) as total FROM ALUMNO WHERE ESTADO='1'");
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

	public int ConteoAlumnosInactivos() {
		int cantFilas=0;
		rs = conexion.ConsultaRS("SELECT count(*) as total FROM ALUMNO WHERE ESTADO='0'");
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

	public int ConteoProfesores() {
		int cantFilas=0;
		rs = conexion.ConsultaRS("SELECT count(*) as total FROM USUARIO WHERE ESTADO='1' AND AREA='DOCENTE'");
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

	public int ConteoAdministracion() {
		int cantFilas=0;
		rs = conexion.ConsultaRS("SELECT count(*) as total FROM USUARIO WHERE ESTADO='1' AND AREA='ADMINISTRACION'");
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

	public int ConteoMaterias() {
		int cantFilas=0;
		rs = conexion.ConsultaRS("SELECT count(*) as total FROM MATERIA WHERE ESTADO='1'");
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
	public int ConteoMateriasPrimer() {
		int cantFilas=0;
		rs = conexion.ConsultaRS("SELECT count(*) as total FROM CURSO WHERE ESTADO='1'and SEMESTRE='PRIMERO'");
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

	
	public int ConteoCursos() {
		int cantFilas=0;
		rs = conexion.ConsultaRS("SELECT count(*) as total FROM CURSO WHERE ESTADO='1'");
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
	public int ConteoInscriptos() {
		int cantFilas=0;
		rs = conexion.ConsultaRS("SELECT count(*) as total FROM ALUMNOCURSO WHERE ESTADO='1'");
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
	public int ConteoMasculinosAdm() {
		int cantFilas=0;
		rs = conexion.ConsultaRS("SELECT count(*) as total FROM usuario WHERE ESTADO='1' and sexo='masculino'");
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
	public int ConteoFemeninoAdm() {
		int cantFilas=0;
		rs = conexion.ConsultaRS("SELECT count(*) as total FROM usuario WHERE ESTADO='1' and sexo='femenino'");
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
	public int ConteoMasculinosAlm() {
		int cantFilas=0;
		rs = conexion.ConsultaRS("SELECT count(*) as total FROM ALUMNO WHERE sexo='masculino'");
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
	public int ConteoFemeninoAlm() {
		int cantFilas=0;
		rs = conexion.ConsultaRS("SELECT count(*) as total FROM ALUMNO WHERE  sexo='femenino'");
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

	public int buscarAlumnoRegistrado(int id) {
		int cantFilas=0;
		rs = conexion.ConsultaRS("SELECT count(*) as total FROM ALUMNOCURSO WHERE ESTADO='1' AND IDALUMNO='"+id+"'");
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

}
