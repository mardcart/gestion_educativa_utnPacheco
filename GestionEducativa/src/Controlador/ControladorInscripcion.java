package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Alumno;
import Entidad.AlumnoCurso;
import Entidad.Curso;
import ModeloDAO.CursoDAO;
import ModeloDAO.AlumnoCursoDAO;
import ModeloDAO.AlumnoDAO;

/**
 * Servlet implementation class ControladorInscripcion
 */
@WebServlet("/ControladorInscripcion")
public class ControladorInscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String pantallaInscripcion = "modeloInscripcion.jsp";
	String consultaInscripcion = "alumnosCurso.jsp";
	String evaluarListado = "EvaluarAlumno.jsp";
	String pantallaNota1 = "vista1.jsp";
	String pantallaNota2 = "vista2.jsp";
	String pantallaRec1 = "vista3.jsp";
	String pantallaRec2 = "vista4.jsp";
	String misCursosProfesor ="MisCursosProfesor.jsp";
	String estadoAcademico = "EstadoAcademico.jsp";
	
	String mensaje = "";
	String tipobootstrap = "";
	
	AlumnoCurso ac = new AlumnoCurso();
    AlumnoCursoDAO dao = new AlumnoCursoDAO();
	
    public ControladorInscripcion() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String acceso = "";
	String action = request.getParameter("accion");
	
	if(action.equalsIgnoreCase("mostrarInscripcion")) {
		acceso = pantallaInscripcion;
	}else if(action.equalsIgnoreCase("btnInscripcionCurso")) {
		int idCurso = Integer.parseInt(request.getParameter("idCurso"));
		
		String[] alumnos = request.getParameterValues("idAlumno");
		//hacer otro string de prueba e ir copiando a la clase hacer otro for para cargar
		
		if(alumnos != null) {
			for(String id: alumnos) {

				if(dao.validarInscripcion(idCurso, Integer.parseInt(id))==false) {
				
				Alumno alumno = new Alumno();
				alumno.setId(Integer.parseInt(id));
				Curso curso = new Curso();
				curso.setId(idCurso);

				ac.setAlumno(alumno);
				ac.setCurso(curso);
				ac.setNota1(0);
				ac.setNota2(0);
				ac.setNota3(0);
				ac.setNota4(0);
				ac.setEstado(true);
				
			    dao.insertInscripcion(ac);

				}
//				int numero = dao.buscarAlumnoRegistrado(Integer.parseInt(id));
//			
//				///busco alumno y curso no registradod
//					if(numero == 0) {
//						ac.setAlumno(alumno);
//						ac.setCurso(curso);
//						ac.setNota1(0);
//						ac.setNota2(0);
//						ac.setNota3(0);
//						ac.setNota4(0);
//						ac.setEstado(true);
//						
//					    dao.insertInscripcion(ac);
//						
//					}
					
				//falta la prueba de validacion si esta registrado si no esntra
					//directo al sistema
				
				
				
				
			}
		}
		acceso=pantallaInscripcion;
		
	}else if(action.equalsIgnoreCase("consultaInscripcion")) {
		acceso = consultaInscripcion;
	}else if(action.equalsIgnoreCase("buscarAlumnos")) {
		request.setAttribute("idCursosAlumnos", request.getParameter("idListado"));
		acceso = evaluarListado;
	}else if(action.equalsIgnoreCase("btnCalificar")) {
		
		String opcion = request.getParameter("opcionEvaluar");
		Curso curso = new Curso();
		switch(opcion) {
		case "A":
			request.setAttribute("idcurso", request.getParameter("txtCurso"));
			acceso = pantallaNota1;
			break;
		case "B":
			request.setAttribute("idcurso", request.getParameter("txtCurso"));
			acceso = pantallaNota2;
			break;
		case "C":
			request.setAttribute("idcurso", request.getParameter("txtCurso"));
			acceso = pantallaRec1;
			break;
		case "D":
			request.setAttribute("idcurso", request.getParameter("txtCurso"));
			acceso = pantallaRec2;
			break;
		}
		
		
		///buscar id curso comparar en el if 
		///dependiendo la opcion mostrar diferentes pantallas para cargar la notacorrecta
		//al momento de cargar hacer el mismo paso que se hixo para inscripcionn
	}else if(action.equalsIgnoreCase("btnCargarNota1")) {
	    String[] idAlumnoCurso = request.getParameterValues("txtId");
	    String[] notaAlumnos = request.getParameterValues("nota1");	    
	    if(idAlumnoCurso != null) {
			if(notaAlumnos != null) {
				AlumnoCurso acurso = new AlumnoCurso();
				int A=1;
				for(String id:idAlumnoCurso) {
						A++;
						int B=1;
					for(String nota:notaAlumnos) {
						B++;		
						if(A==B) {
						acurso.setId(Integer.parseInt(id));
						acurso.setNota1(Integer.parseInt(nota));
						dao.CargarNota1(acurso);
						}
					}
				}
				mensaje = "Se cargaron las notas con exito";
				tipobootstrap="alert-success";
			}
		}
    	request.setAttribute("mensaje", mensaje);
    	request.setAttribute("tipo", tipobootstrap);

		acceso = misCursosProfesor;
	}else if(action.equalsIgnoreCase("btnCargarSegunda")) {
	    String[] idAlumno = request.getParameterValues("txtId2");
	    String[] notaAl = request.getParameterValues("nota2");	    
	    if(idAlumno != null) {
			if(notaAl != null) {
				AlumnoCurso acurso = new AlumnoCurso();
				int A=1;
				for(String id:idAlumno) {
						A++;
						int B=1;
					for(String nota:notaAl) {
						B++;		
						if(A==B) {
						acurso.setId(Integer.parseInt(id));
						acurso.setNota2(Integer.parseInt(nota));
						dao.CargarNota2(acurso);
						}
					}
				}
				mensaje = "Se cargaron con exito";
				tipobootstrap="alert-success";
			}
		}
    	request.setAttribute("mensaje", mensaje);
    	request.setAttribute("tipo", tipobootstrap);

		acceso = misCursosProfesor;
	}else if(action.equalsIgnoreCase("btnCargarRec1")) {
	    String[] idAlumnoCurso = request.getParameterValues("txtId3");
	    String[] notaAlumnos = request.getParameterValues("nota3");	    
	    if(idAlumnoCurso != null) {
			if(notaAlumnos != null) {
				AlumnoCurso acurso = new AlumnoCurso();
				int A=1;
				for(String id:idAlumnoCurso) {
						A++;
						int B=1;
					for(String nota:notaAlumnos) {
						B++;		
						if(A==B) {
						acurso.setId(Integer.parseInt(id));
						acurso.setNota3(Integer.parseInt(nota));
						dao.CargarRec1(acurso);
						}
					}
				}
				mensaje = "Se cargaron con exito";
				tipobootstrap="alert-success";
			}
		}
    	request.setAttribute("mensaje", mensaje);
    	request.setAttribute("tipo", tipobootstrap);

		acceso = misCursosProfesor;
	}else if(action.equalsIgnoreCase("btnCargarRec2")) {
	    String[] idAlumnoCurso = request.getParameterValues("txtId");
	    String[] notaAlumnos = request.getParameterValues("nota1");	    
	    if(idAlumnoCurso != null) {
			if(notaAlumnos != null) {
				AlumnoCurso acurso = new AlumnoCurso();
				int A=1;
				for(String id:idAlumnoCurso) {
						A++;
						int B=1;
					for(String nota:notaAlumnos) {
						B++;		
						if(A==B) {
						acurso.setId(Integer.parseInt(id));
						acurso.setNota4(Integer.parseInt(nota));;
						dao.CargarRecu2(acurso);
						}
					}
				}
				mensaje = "Se cargaron las notas con exito";
				tipobootstrap="alert-success";
			}
		}
    	request.setAttribute("mensaje", mensaje);
    	request.setAttribute("tipo", tipobootstrap);

		acceso = misCursosProfesor;
	}else if(action.equalsIgnoreCase("misCursos")) {
		acceso = misCursosProfesor;
	}else if(action.equalsIgnoreCase("EstadoAcademico")) {
		request.setAttribute("idEstadoAcademico", request.getParameter("id"));
		acceso = estadoAcademico;
	}



	
	RequestDispatcher  vista = request.getRequestDispatcher(acceso);
	vista.forward(request, response);

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=iso-88599-1");
		PrintWriter out = response.getWriter();
		
		String idcurso = request.getParameter("id");
		AlumnoCursoDAO acdao = new AlumnoCursoDAO();
		if(!idcurso.equals("")) {
			List<AlumnoCurso> lt = acdao.filtradoCurso(Integer.parseInt(idcurso));
			out.println("<table>");

			out.println("<tr>");
			out.println("<td> NRO </td>");
			out.println("<td> LEGAJO </td>");
			out.println("<td>NOMBRE APELLIDO</td>");
			out.println("<td>EMAIL</td>");
			out.println("<td>TELEFONO</td>");
			out.println("<td>FECHA INSCRIPCION </td>");
			out.println("</tr>");
			
			int cont =0;
		 			
			for(int i=0;i<lt.size();i++) {
				cont=cont+1;
				AlumnoCurso ac = lt.get(i);
				Alumno al = new Alumno();
				AlumnoDAO adao =new AlumnoDAO();
				al = adao.buscarAlumno(ac.getAlumno().getId());
				out.println("<tr>");
				out.println("<td>" + cont + "</td>");
				out.println("<td>" + al.getLegajo() + "</td>");
				out.println("<td>" + al.getNombre() +"  "+ al.getApellido()+ "</td>");
				out.println("<td>" + al.getEmail() + "</td>");
				out.println("<td>" + al.getTelefono() + "</td>");
				out.println("<td>" + al.getFechaInscripcion() + "</td>");
				out.println("</tr>");
			}
			out.println("<tr>");
			out.println("<tr>");
			out.println("<td> NRO </td>");

			out.println("<td> LEGAJO </td>");
			out.println("<td>NOMBRE APELLIDO</td>");
			out.println("<td>EMAIL</td>");
			out.println("<td>TELEFONO</td>");
			out.println("<td>FECHA INSCRIPCION </td>");
			out.println("</tr>");
			out.println("</tr>");

			out.println("</table>");
		   	
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
