package Controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.security.auth.UnixNumericUserPrincipal;

import Entidad.Alumno;
import Entidad.User;
import Entidad.Usuario;
import ModeloDAO.AlumnoDAO;
import ModeloDAO.UserDAO;
import ModeloDAO.UsuarioDAO;

/**
 * Servlet implementation class ControladorLoguearse
 */
@WebServlet("/ControladorLoguearse")
public class ControladorLoguearse extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String menuAdministrador = "MenuAdm.jsp";
    String menuProfesor = "MenuProf.jsp";
    String menuAlumno = "MenuAlumno.jsp";
    String loguearse ="Login.jsp";
    String menuIndex = "Index.jsp";
    String inicio = "Inicio.jsp";
    
	String mensaje = "";
	String tipoboostrap = "";
	HttpSession sesion;

    User user = new User();
    UserDAO udao = new UserDAO(); 

	Usuario usuario = new Usuario();
	UsuarioDAO usuarioDao = new UsuarioDAO();

	Alumno alumno = new Alumno();
	AlumnoDAO alumnoDao = new AlumnoDAO();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorLoguearse() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acceso ="";
		String action = request.getParameter("accion");
  
		if(action.equalsIgnoreCase("mostrarLoguin")) {
			acceso = loguearse;
		}else if(action.equalsIgnoreCase("loguearse")){
			String username = request.getParameter("username");
			String password =  request.getParameter("password");

			if(!username.equals("") && !password.equals("")) {
			    User us = new User();
			    UserDAO usdao = new UserDAO(); 

			    us=usdao.buscarUserLogueado(username, password);
				String opcion = "";
				opcion = us.getCategoria();
//				opcion = usdao.buscarLogueo(username, password);	

				if(opcion != null) {
					if(!opcion.equals("")) {
						switch(opcion) {
						case "ALUMNO":
							alumno = alumnoDao.buscarAlumnoUser(us.getId());
							String datos = alumno.getApellido() + " "+ alumno.getNombre();
							sesion = request.getSession();
							sesion.setAttribute("user", datos);
							sesion.setAttribute("id", alumno.getId());
							acceso = menuAlumno;	
							break;
						case "DOCENTE":
							usuario = usuarioDao.buscarUsuarioUser(us.getId());
							String name = usuario.getApellido() + " "+usuario.getNombre();
									
							sesion =request.getSession();
							sesion.setAttribute("user", name);
							sesion.setAttribute("id", usuario.getId());
							acceso = menuProfesor;
							break;
						case "ADMINISTRACION":
							usuario =  usuarioDao.buscarUsuarioUser(us.getId());
							String nam = usuario.getApellido() + " "+usuario.getNombre();
							
						    sesion = request.getSession();
							sesion.setAttribute("user", nam);
							sesion.setAttribute("id", usuario.getId());
							acceso = menuIndex;
							break;
						}
					}else {
						
		        		mensaje = "falta ingresar datos";
		        		tipoboostrap = "alert-warning";
		        		
		        	request.setAttribute("mensaje", mensaje);
		        	request.setAttribute("tipo", tipoboostrap);


						acceso = loguearse;
						
					}

					
				}else {
	        		mensaje = "usuario y pass incorrectos";
	        		tipoboostrap = "alert-warning";
	        		
	        	request.setAttribute("mensaje", mensaje);
	        	request.setAttribute("tipo", tipoboostrap);

					acceso = loguearse;
				}
				
			}else {
        		mensaje = "falta ingresar datos";
        		tipoboostrap = "alert-warning";

        	request.setAttribute("mensaje", mensaje);
        	request.setAttribute("tipo", tipoboostrap);

				acceso = loguearse;
			}
 
   		}else if(action.equalsIgnoreCase("CerrarSession")) {
   			
   				sesion.removeAttribute("user");
   			   
   				acceso = inicio;
   				
   			
   		}
		
		
		RequestDispatcher  vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
