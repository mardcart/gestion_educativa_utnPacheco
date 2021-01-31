package Controlador;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Localidad;
import Entidad.User;
import Entidad.Usuario;
import ModeloDAO.UserDAO;
import ModeloDAO.UsuarioDAO;

/**
 * Servlet implementation class ControladorAdmin
 */
@WebServlet("/ControladorAdmin")
public class ControladorAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String RegistrarAdmin = "AdminRegistrar.jsp";
    String listAdmin = "AdminBuscar.jsp";
    String UpdateAdmin = "AdminUpdate.jsp";
    
    Usuario adm =  new Usuario();
    User user = new User();
    UsuarioDAO dao = new UsuarioDAO();
    UserDAO udao = new UserDAO();
    
    String mensaje = "";
    String bootstrap = "";

	public ControladorAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acceso = "";
		String action = request.getParameter("accion");
		if(action.equalsIgnoreCase("listar")) {
			acceso = listAdmin;
		}else if(action.equalsIgnoreCase("mostrarAdd")) {
			acceso = RegistrarAdmin;
		}else if(action.equalsIgnoreCase("btnRegistrarAdm")) {
			
			String nombre = request.getParameter("txtNombre");
        	String apellido = request.getParameter("txtApellido");
        	String dni = request.getParameter("txtDni");
        	String idLocal = request.getParameter("localidad");
        	String edad = request.getParameter("datFechaNac");
        	//int idLocalidad = Integer.parseInt(request.getParameter("localidad"));
        	//Date fechaNac=Date.valueOf(request.getParameter("datFechaNac").toString());
        	LocalDate fecha = LocalDate.now();
        	Date hoy = Date.valueOf(fecha);
        	String email = request.getParameter("txtEmail");
        	String telefono = request.getParameter("txtTelefono");
        	String direccion= request.getParameter("txtDireccion");
        	String sexo = request.getParameter("rbtSexo");
        	String area = request.getParameter("cbxArea");
	        String profesion = request.getParameter("cbxProfesion");
        	if(!nombre.equals("") && !apellido.equals("") && !dni.equals("") && !idLocal.equals("") 
        		&&!edad.equals("")	&& !email.equals("") && !telefono.equals("") && !direccion.equals("")) {
        	Date fechaNac=Date.valueOf(edad);
        	int idLocalidad = Integer.parseInt(idLocal);
        	
        	user.setLegajo("AD/"+dni);
        	user.setPassword(dni);
        	user.setCategoria(area);
        	user.setEstado(true);

        	if(udao.registerUser(user) == true) {

        		int ultimo  = udao.buscarIdUltimo();
        		
        		if(ultimo > 0) {
        			
        		
            	adm.setDni(dni);
            	adm.setNombre(nombre);
            	adm.setApellido(apellido);
            	Localidad l = new Localidad();
            	l.setId(idLocalidad);
            	adm.setLocalidad(l);
            	adm.setFechaNac(fechaNac);
            	adm.setFechaAlta(hoy);
            	adm.setEmail(email);
            	adm.setTelefono(telefono);
            	adm.setDireccion(direccion);
            	adm.setSexo(sexo);
            	User u = new User();
            	u.setId(ultimo);
            	adm.setUser(u);
            	adm.setEstado(true);
            	adm.setArea(area);
             	adm.setProfesion(profesion);
            	
            	mensaje = dao.registrarUsuarioAdm(adm);
            	
            	bootstrap = "alert-success";
        		}
        	}else {
        		mensaje = "no se pudo registrar el usuario";
        		bootstrap = "alert-danger";
        	}

	    	}else {
	    		mensaje = "falta ingresar datos";
	    		bootstrap = "alert-warning";
	    	}
	    		
	    	request.setAttribute("mensaje", mensaje);
	    	request.setAttribute("tipo", bootstrap);
	    	
	    	acceso=RegistrarAdmin;

        	
       	}else if(action.equalsIgnoreCase("editar")) {
       		request.setAttribute("idUpdate", request.getParameter("id"));
       		acceso = UpdateAdmin ;
       	}else if(action.equalsIgnoreCase("btnUpdate")) {
        	String idUpdate = request.getParameter("txtIdUpdate");
			String nombre = request.getParameter("txtNombre");
        	String apellido = request.getParameter("txtApellido");
        	String dni = request.getParameter("txtDni");
        	String idLocal = request.getParameter("localidad");
        	String edad = request.getParameter("datFechaNac");
        	//int idLocalidad = Integer.parseInt(request.getParameter("localidad"));
        	//Date fechaNac=Date.valueOf(request.getParameter("datFechaNac").toString());
        	LocalDate fecha = LocalDate.now();
        	Date hoy = Date.valueOf(fecha);
        	String email = request.getParameter("txtEmail");
        	String telefono = request.getParameter("txtTelefono");
        	String direccion= request.getParameter("txtDireccion");
        	String sexo = request.getParameter("rbtSexo");
        	String profesion = request.getParameter("cbxProfesion");
        	String area =  request.getParameter("cbxArea");
        	
        	if(!nombre.equals("") && !apellido.equals("") && !dni.equals("") && !idLocal.equals("") 
        		&&!edad.equals("")	&& !email.equals("") && !telefono.equals("") && !direccion.equals("")) {
        	Date fechaNac=Date.valueOf(edad);
        	int idLocalidad = Integer.parseInt(idLocal);
        	
	        		adm.setId(Integer.parseInt(idUpdate));
//	            	alumno.setDni(dni);
	            	adm.setNombre(nombre);
	            	adm.setApellido(apellido);
	            	Localidad l = new Localidad();
	            	l.setId(idLocalidad);
	            	adm.setLocalidad(l);
	            	adm.setFechaNac(fechaNac);
//	            	alumno.setFechaInscripcion(hoy);
	            	adm.setEmail(email);
	            	adm.setTelefono(telefono);
	            	adm.setDireccion(direccion);
	            	adm.setSexo(sexo);
//	            	alumno.setEstado(true);
	            	adm.setProfesion(profesion);
	            	adm.setArea(area);
//	            	alumno.setLegajo(dni);
	            	
	            	mensaje = dao.updateUsuarioAdm(adm);   	
	            	bootstrap = "alert-success";

	            	
        	}else {
        		mensaje = "falta ingresar datos";
        		bootstrap = "alert-danger";
        	}
        		
        	request.setAttribute("mensaje", mensaje);
        	request.setAttribute("tipo", bootstrap);
        	
        	acceso=listAdmin;


       	}else if(action.equalsIgnoreCase("eliminar")) {
       		int idEliminar = Integer.parseInt(request.getParameter("id"));
       		adm.setEstado(false);
       		adm.setId(idEliminar);
       		
       		mensaje = dao.deleteUsuarioAdm(adm);
       		bootstrap = "alert-success";
       		
       		request.setAttribute("mensaje", mensaje);
       		request.setAttribute("tipo", bootstrap);
       		acceso = listAdmin;
       	}
		
		
		
		
		RequestDispatcher  vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
