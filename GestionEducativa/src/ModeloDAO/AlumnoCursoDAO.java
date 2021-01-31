package ModeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Config.Conexion;
import Entidad.Alumno;
import Entidad.AlumnoCurso;
import Entidad.Curso;
import Interfaces.CRUD_ALUMNOCURSO;

public class AlumnoCursoDAO implements CRUD_ALUMNOCURSO {
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	Conexion conexion= new Conexion();
	AlumnoCurso ca = new AlumnoCurso();
	@Override
	public List listadoAlCurso() {
		ArrayList<AlumnoCurso> lst = new ArrayList<>();
		try {
			rs = conexion.ConsultaRS("SELECT * FROM ALUMNOCURSO WHERE ESTADO='1'");
			while(rs.next()) {
				AlumnoCurso ac = new AlumnoCurso();
				Alumno a = new Alumno();
				Curso c = new Curso();
				
				ac.setId(rs.getInt(1));
				a.setId(rs.getInt(2));
				ac.setAlumno(a);
				c.setId(rs.getInt(3));
				ac.setCurso(c);
				ac.setNota1(rs.getInt(4));
				ac.setNota2(rs.getInt(5));
				ac.setNota3(rs.getInt(6));
				ac.setNota4(rs.getInt(7));
				ac.setEstado(rs.getBoolean(8));
				lst.add(ac);
				
				
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lst;
	}

	public List filtradoCurso(int id) {
		ArrayList<AlumnoCurso> lst = new ArrayList<>();
		try {
			rs = conexion.ConsultaRS("SELECT * FROM ALUMNOCURSO WHERE ESTADO='1' and idcurso='"+id+"'");
			while(rs.next()) {
				AlumnoCurso ac = new AlumnoCurso();
				Alumno a = new Alumno();
				Curso c = new Curso();
				
				ac.setId(rs.getInt(1));
				a.setId(rs.getInt(2));
				ac.setAlumno(a);
				c.setId(rs.getInt(3));
				ac.setCurso(c);
				ac.setNota1(rs.getInt(4));
				ac.setNota2(rs.getInt(5));
				ac.setNota3(rs.getInt(6));
				ac.setNota4(rs.getInt(7));
				ac.setEstado(rs.getBoolean(8));
				lst.add(ac);
				
				
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lst;
	}


	public List listaCursosDelAlumno(int idalumno) {
		ArrayList<AlumnoCurso> lst = new ArrayList<>();
		try {
			rs = conexion.ConsultaRS("SELECT * FROM ALUMNOCURSO WHERE ESTADO='1' and idalumno='"+idalumno+"'");
			while(rs.next()) {
				AlumnoCurso ac = new AlumnoCurso();
				Alumno a = new Alumno();
				Curso c = new Curso();
				
				ac.setId(rs.getInt(1));
				a.setId(rs.getInt(2));
				ac.setAlumno(a);
				c.setId(rs.getInt(3));
				ac.setCurso(c);
				ac.setNota1(rs.getInt(4));
				ac.setNota2(rs.getInt(5));
				ac.setNota3(rs.getInt(6));
				ac.setNota4(rs.getInt(7));
				ac.setEstado(rs.getBoolean(8));
				lst.add(ac);
				
				
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lst;
	}

	
	@Override
	public AlumnoCurso buscarAlumnoCurso(int id) {
		try {
			rs = conexion.ConsultaRS("SELECT * FROM ALUMNOCURSO WHERE IDAC="+id);
			rs.next();
				
				Alumno a = new Alumno();
				Curso c = new Curso();
				
				ca.setId(rs.getInt(1));
				a.setId(rs.getInt(2));
				ca.setAlumno(a);
				c.setId(rs.getInt(3));
				ca.setCurso(c);
				ca.setNota1(rs.getInt(4));
				ca.setNota2(rs.getInt(5));
				ca.setNota3(rs.getInt(6));
				ca.setNota4(rs.getInt(7));
				ca.setEstado(rs.getBoolean(8));
			
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ca;
	}

	public int buscarCursoRegistrado(int id) {
		int cantFilas=0;
		rs = conexion.ConsultaRS("SELECT count(*) as total FROM ALUMNOCURSO WHERE ESTADO='1' AND IDCURSO='"+id+"'");
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
	public int cantidadAlumnos(int idCurso) {
		int cantFilas=0;
		rs = conexion.ConsultaRS("SELECT count(*) as total FROM ALUMNOCURSO WHERE ESTADO='1' AND IDCURSO='"+idCurso+"'");
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
	public boolean insertInscripcion(AlumnoCurso ac) {
		String consulta="INSERT INTO ALUMNOCURSO (IDALUMNO,IDCURSO,NOTA1,NOTA2,NOTA3,NOTA4,ESTADO)VALUES (?,?,?,?,?,?,?)";
		Alumno a = new Alumno();
		Curso c = new Curso();

		try {
			pst = conexion.ConsultaPST(consulta);
			pst.setInt(1, ac.getAlumno().getId());
			pst.setInt(2, ac.getCurso().getId());
			pst.setInt(3, ac.getNota1());
			pst.setInt(4, ac.getNota2());
			pst.setInt(5, ac.getNota3());
			pst.setInt(6, ac.getNota4());
			pst.setBoolean(7, ac.isEstado());
			pst.execute();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	public boolean validarInscripcion(int curso , int alumno) {
		String consulta = "select * from alumnocurso where idalumno='"+alumno+"' and idcurso='"+curso+"'";
		boolean estado=true;
		rs = conexion.ConsultaRS(consulta);
		try {
			if(rs != null && rs.next()) {
				estado = true;
			}else {
				estado=false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return estado;
	}

	@Override
	public boolean updateInscripcion(AlumnoCurso ac) {
		String consulta="UPDATE ALUMNOCURSO  SET NOTA1=?,NOTA2=?,NOTA3=?,NOTA4=? WHERE IDAC=?";
		

		try {
			pst = conexion.ConsultaPST(consulta);
			pst.setInt(1, ac.getNota1());
			pst.setInt(2, ac.getNota2());
			pst.setInt(3, ac.getNota3());
			pst.setInt(4, ac.getNota4());
			pst.setInt(5, ac.getId());
			pst.execute();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public boolean CargarNota1(AlumnoCurso ac) {
		String consulta="UPDATE ALUMNOCURSO  SET NOTA1=? WHERE IDAC=?";
		

		try {
			pst = conexion.ConsultaPST(consulta);
			pst.setInt(1, ac.getNota1());
			pst.setInt(2, ac.getId());
			pst.execute();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public boolean CargarNota2(AlumnoCurso ac) {
		String consulta="UPDATE ALUMNOCURSO  SET NOTA2=? WHERE IDAC=?";
		

		try {
			pst = conexion.ConsultaPST(consulta);
			pst.setInt(1, ac.getNota2());
			pst.setInt(2, ac.getId());
			pst.execute();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	public boolean CargarRec1(AlumnoCurso ac) {
		String consulta="UPDATE ALUMNOCURSO  SET NOTA3=? WHERE IDAC=?";
		

		try {
			pst = conexion.ConsultaPST(consulta);
			pst.setInt(1, ac.getNota3());
			pst.setInt(2, ac.getId());
			pst.execute();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	public boolean CargarRecu2(AlumnoCurso ac) {
		String consulta="UPDATE ALUMNOCURSO  SET NOTA4=? WHERE IDAC=?";
		

		try {
			pst = conexion.ConsultaPST(consulta);
			pst.setInt(1, ac.getNota4());
			pst.setInt(2, ac.getId());
			pst.execute();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean deleteInscripcion(AlumnoCurso ac) {
		String consulta="UPDATE ALUMNOCURSO  SET ESTADO=? WHERE IDAC=?";
		

		try {
			pst = conexion.ConsultaPST(consulta);
			pst.setBoolean(1, ac.isEstado());
			pst.setInt(2, ac.getId());
			pst.execute();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
