import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.*;

import Entidad.Alumno;
import Entidad.AlumnoCurso;
import Entidad.Curso;
import Entidad.Localidad;
import Entidad.Materia;
import Entidad.Provincia;
import Entidad.Prueba;
import Entidad.User;
import Entidad.Usuario;
import ModeloDAO.AlumnoCursoDAO;
import ModeloDAO.AlumnoDAO;
import ModeloDAO.CursoDAO;
import ModeloDAO.LocalidadDAO;
import ModeloDAO.MateriaDAO;
import ModeloDAO.ProvinciaDAO;
import ModeloDAO.PruebaDAO;
import ModeloDAO.UserDAO;
import ModeloDAO.UsuarioDAO;

public class Principal {

	public static void main(String[] args) {

		
//		CursoDAO cdao = new CursoDAO();
//		int f = cdao.cantidadCursosProfesor(2);
//		AlumnoCurso ac = new AlumnoCurso();
		AlumnoCursoDAO  acDAO = new AlumnoCursoDAO();
//		
		boolean estado = acDAO.validarInscripcion(1, 2);
		System.out.println(estado);
		
		
//		User u = new User();
//		UserDAO dao = new UserDAO();
//	
//		String respuesta = "";
//		respuesta = dao.buscarLogueo("AL-12121212", "1211212");
//		
//		System.out.println(numero);
		
//		int i = dao.buscarIdUltimo();
		
//		System.out.println("el ultimo es : " + i);
//		Prueba p = new Prueba();
//		PruebaDAO dao = new PruebaDAO();

		
//		p.setNombre("marco");
//		p.setApellido("cardenas");
//		p.setEstado(true);
//		
//		String mensaje = dao.registrar(p);
//		
//		System.out.println(mensaje);
	
//		Alumno al = new Alumno();
//		
//		AlumnoDAO dao = new AlumnoDAO();
//		
//		Date fecha = new Date(2020, 12, 12);
//		Localidad l = new Localidad();
//		User u = new User();
//		
//		al.setDni("94068971");
//		al.setNombre("marco");
//		al.setApellido("cardenas");
//		al.setTelefono("11246351187");
//		al.setEmail("mardcart.9@gmail.com");
//		al.setDireccion("miguel cane 3259");
//		al.setFechaInscripcion(fecha);
//		al.setFechaNac(fecha);
//		al.setCarrera("tsp");
//		al.setEstado(true);
//		l.setId(1);
//		al.setLocalidad(l);
//		al.setLegajo("al-94068971");
//		u.setId(1);
//		al.setUser(u);
//		al.setSexo("masculino");
//	  
//		String mensaje = dao.registerAlumno(al);
//		
//		System.out.println(mensaje);
//		
		
	}

}
