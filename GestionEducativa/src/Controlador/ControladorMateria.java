package Controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Alumno;
import Entidad.Curso;
import Entidad.Materia;
import Entidad.User;
import Entidad.Usuario;
import ModeloDAO.AlumnoDAO;
import ModeloDAO.CursoDAO;
import ModeloDAO.MateriaDAO;
import ModeloDAO.UserDAO;

/**
 * Servlet implementation class ControladorMateria
 */
@WebServlet("/ControladorMateria")
public class ControladorMateria extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	String InsertMateria = "MateriaRegistrar.jsp";
	String InsertCurso = "CursosRegistrar.jsp";
	String UpdateMateria = "MateriaUpdate.jsp";
	String ListMateria   =  "MateriaBuscar.jsp";
    String ListCursos = "CursosBuscar.jsp";
    String UpdateCurso = "CursosUpdate.jsp";
    
	Materia materia = new Materia();
	MateriaDAO  dao =  new MateriaDAO();
	Curso curso = new Curso();
	CursoDAO cursodao = new CursoDAO();
	Usuario user = new Usuario();

	String mensaje = "";
	String tipoboostrap = "";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorMateria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acceso ="";
		String action = request.getParameter("accion");
		
		//FIGARSE SI SE CAMBIA EL STRING\
		if(action.equalsIgnoreCase("MostrarAdd")) {
			acceso = InsertMateria;
		}else if(action.equalsIgnoreCase("btnGuardar")) {
			String nombre = request.getParameter("txtNombre");
			
			if(!nombre.equals("") ) {
				materia.setNombre(nombre);
				materia.setEstado(true);
				
				mensaje = dao.registrarMateria(materia);
				
				tipoboostrap = "alert-success";
				
			}else {
				mensaje = "Falta ingresar datos";
				tipoboostrap = "alert-warning";
			}
        	request.setAttribute("mensaje", mensaje);
        	request.setAttribute("tipo", tipoboostrap);
        	
        	acceso=InsertMateria;

		}else if(action.equalsIgnoreCase("MostrarCursos")) {
			acceso = InsertCurso;
		}else if(action.equalsIgnoreCase("btnRegistrarCurso")) {
			String descripcion = request.getParameter("txtDescripcion");
			String area = request.getParameter("cbxMateria");
			String semestre = request.getParameter("rdSemestre");
			String profesor = request.getParameter("cbxProfesor");
			
			
			if(!descripcion.equals("")) {
				curso.setNombre(descripcion);
				materia.setId(Integer.parseInt(area));
				curso.setMateria(materia);
				curso.setSemestre(semestre);
				curso.setAnio(2020);
				user.setId(Integer.parseInt(profesor));
				curso.setProfesor(user);
				curso.setEstado(true);
				
				mensaje = cursodao.registrarCurso(curso);
				tipoboostrap = "alert-success";
			}else {
				mensaje="falta ingresar datos";
				tipoboostrap = "alert-danger";
			}
        	request.setAttribute("mensaje", mensaje);
        	request.setAttribute("tipo", tipoboostrap);
            acceso = InsertCurso;
		}else if(action.equalsIgnoreCase("listarCursos")) {
			acceso = ListCursos;
		}else if(action.equalsIgnoreCase("editarCurso")) {
			request.setAttribute("idCurso", request.getParameter("id"));
			acceso = UpdateCurso;
		}else if(action.equalsIgnoreCase("btnUpdateCurso")) {
			String idCurso = request.getParameter("txtId");
			String descripcion = request.getParameter("txtDescripcion");
			String area = request.getParameter("cbxMateria");
			String semestre = request.getParameter("rdSemestre");
			String profesor = request.getParameter("cbxProfesor");
			
			
			if(!descripcion.equals("")) {
				curso.setId(Integer.parseInt(idCurso));
				curso.setNombre(descripcion);
				materia.setId(Integer.parseInt(area));
				curso.setMateria(materia);
				curso.setSemestre(semestre);
				curso.setAnio(2020);
				user.setId(Integer.parseInt(profesor));
				curso.setProfesor(user);
				curso.setEstado(true);
				
				mensaje = cursodao.updateCurso(curso);
				tipoboostrap = "alert-success";
			}else {
				mensaje="falta ingresar datos";
				tipoboostrap = "alert-danger";
			}
        	request.setAttribute("mensaje", mensaje);
        	request.setAttribute("tipo", tipoboostrap);
            acceso = ListCursos;
			
		}else if(action.equalsIgnoreCase("eliminarCurso")) {
			int id = Integer.parseInt((String)request.getParameter("id"));
			
			curso.setEstado(false);
			curso.setId(id);
			
			mensaje = cursodao.deldeteCurso(curso);
			tipoboostrap = "alert-danger";
			
        	request.setAttribute("mensaje", mensaje);
        	request.setAttribute("tipo", tipoboostrap);
            acceso = ListCursos;
			
			
		}

		RequestDispatcher  vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}








