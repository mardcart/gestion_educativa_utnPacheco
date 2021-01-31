package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import Entidad.Localidad;
import Entidad.Provincia;
import ModeloDAO.LocalidadDAO;
import ModeloDAO.ProvinciaDAO;
import Entidad.Alumno;
import ModeloDAO.AlumnoDAO;
import Entidad.User;
import ModeloDAO.UserDAO;

@WebServlet("/ControladorAlumno")
public class ControladorAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String InsertAlumno = "AlumnoRegistrar.jsp";
	String UpdateAlumno = "AlumnoUpdate.jsp";
	String ListAlumno   =  "AlumnoBuscar.jsp";
    String cambiarClave = "AlumnoClave.jsp";
	
	Alumno alumno = new Alumno();
	AlumnoDAO dao = new AlumnoDAO();
	User user =  new User();
	UserDAO udao = new UserDAO();
	String mensaje = "";
	String tipoboostrap = "";
	
    public ControladorAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acceso ="";
		String action = request.getParameter("accion");
		
		//FIGARSE SI SE CAMBIA EL STRING\
		if(action.equalsIgnoreCase("listar")) {
			acceso = ListAlumno;
		}else if(action.equalsIgnoreCase("mostrarAdd")) {
			acceso=InsertAlumno;
		}else if(action.equalsIgnoreCase("btnRegistrar")) {

			
										
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
        	String carrera = request.getParameter("cbxCarrera");
	        
        	if(!nombre.equals("") && !apellido.equals("") && !dni.equals("") && !idLocal.equals("") 
        		&&!edad.equals("")	&& !email.equals("") && !telefono.equals("") && !direccion.equals("")) {
        	Date fechaNac=Date.valueOf(edad);
        	int idLocalidad = Integer.parseInt(idLocal);
        		
	        	user.setLegajo("AL/"+dni);
	        	user.setPassword(dni);
	        	user.setCategoria("ALUMNO");
	        	user.setEstado(true);

	        	if(udao.registerUser(user) == true) {

	        		int ultimo  = udao.buscarIdUltimo();
	        		
	        		if(ultimo > 0) {
	        			
	        		
	            	alumno.setDni(dni);
	            	alumno.setNombre(nombre);
	            	alumno.setApellido(apellido);
	            	Localidad l = new Localidad();
	            	l.setId(idLocalidad);
	            	alumno.setLocalidad(l);
	            	alumno.setFechaNac(fechaNac);
	            	alumno.setFechaInscripcion(hoy);
	            	alumno.setEmail(email);
	            	alumno.setTelefono(telefono);
	            	alumno.setDireccion(direccion);
	            	alumno.setSexo(sexo);
	            	User u = new User();
	            	u.setId(ultimo);
	            	alumno.setUser(u);
	            	alumno.setEstado(true);
	            	alumno.setCarrera(carrera);
	            	alumno.setLegajo("AL/"+dni);
	            	
	            	mensaje = dao.registerAlumno(alumno);
	            	
	            	tipoboostrap = "alert-success";
	        		}
	        	}else {
	        		mensaje = "no se pudo registrar el usuario";
	        		tipoboostrap = "alert-danger";
	        	}

        	}else {
        		mensaje = "falta ingresar datos";
        		tipoboostrap = "alert-warning";
        	}
        		
        	request.setAttribute("mensaje", mensaje);
        	request.setAttribute("tipo", tipoboostrap);
        	
        	acceso=InsertAlumno;
        
        }else if(action.equalsIgnoreCase("editar")) {
        	request.setAttribute("idAlumno", request.getParameter("id"));
        	acceso=UpdateAlumno;
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
        	String carrera = request.getParameter("cbxCarrera");
	        
        	
        	if(!nombre.equals("") && !apellido.equals("") && !dni.equals("") && !idLocal.equals("") 
        		&&!edad.equals("")	&& !email.equals("") && !telefono.equals("") && !direccion.equals("")) {
        	Date fechaNac=Date.valueOf(edad);
        	int idLocalidad = Integer.parseInt(idLocal);
        	
	        		alumno.setId(Integer.parseInt(idUpdate));
//	            	alumno.setDni(dni);
	            	alumno.setNombre(nombre);
	            	alumno.setApellido(apellido);
	            	Localidad l = new Localidad();
	            	l.setId(idLocalidad);
	            	alumno.setLocalidad(l);
	            	alumno.setFechaNac(fechaNac);
//	            	alumno.setFechaInscripcion(hoy);
	            	alumno.setEmail(email);
	            	alumno.setTelefono(telefono);
	            	alumno.setDireccion(direccion);
	            	alumno.setSexo(sexo);
//	            	alumno.setEstado(true);
	            	alumno.setCarrera(carrera);
//	            	alumno.setLegajo(dni);
	            	
	            	mensaje = dao.updateAlumno(alumno);            	
	            	tipoboostrap = "alert-success";

	            	
        	}else {
        		mensaje = "falta ingresar datos";
        		tipoboostrap = "alert-danger";
        	}
        		
        	request.setAttribute("mensaje", mensaje);
        	request.setAttribute("tipo", tipoboostrap);
        	
        	acceso=ListAlumno;

        }else if(action.equalsIgnoreCase("eliminar")) {
        	int idEliminar = Integer.parseInt(request.getParameter("id"));
        	alumno.setId(idEliminar);
        	alumno.setEstado(false);
        	
        	mensaje = dao.deleteAlumno(alumno);
        	tipoboostrap = "alert-success";

        	request.setAttribute("mensaje", mensaje);
        	request.setAttribute("tipo", tipoboostrap);

        	acceso=ListAlumno;
        }else if(action.equalsIgnoreCase("cambiarClave")) {
        	acceso = cambiarClave;
        }else if(action.equalsIgnoreCase("confirmar")) {
        	int idalumno = Integer.parseInt(request.getParameter("idAl"));
        	String pwd = request.getParameter("pwd");
        	String pwd2 = request.getParameter("pwd2");
        	
        	if(!pwd.equals("") && !pwd2.equals("")) {
        		if(pwd.equals(pwd2)) {
        			alumno = dao.buscarAlumno(idalumno);
        		   
        			user = udao.buscarUser(alumno.getUser().getId());
        			
        			User us = new User();
        			us.setId(user.getId());
        			us.setPassword(pwd);
        		
        			mensaje = udao.updateUser(us);
        			tipoboostrap = "alert-success";
        			
        		}else {
        			mensaje = "no coincide los password";
            		tipoboostrap = "alert-danger";
        		}
        	}else {
        		mensaje = "falta ingresar datos";
        		tipoboostrap = "alert-danger";
        	}
        	request.setAttribute("mensaje", mensaje);
        	request.setAttribute("tipo", tipoboostrap);
        	
        	acceso=cambiarClave;

        }
		
		RequestDispatcher  vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
