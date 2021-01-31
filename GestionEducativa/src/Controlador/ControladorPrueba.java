package Controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Prueba;
import ModeloDAO.PruebaDAO;

/**
 * Servlet implementation class ControladorPrueba
 */
@WebServlet("/ControladorPrueba")
public class ControladorPrueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Prueba p = new Prueba();
	PruebaDAO dao = new PruebaDAO();
	
	String add = "prueba.jsp";
	
	public ControladorPrueba() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acceso = "";
		String action = request.getParameter("accion");
		
		if(action.equalsIgnoreCase("mostrar")) {
			acceso = add;
		}else if(action.equalsIgnoreCase("btnAgregar")) {
			String nombre = request.getParameter("txtNombre");
			String apellido = request.getParameter("txtApellido");
			p.setNombre(nombre);
			p.setApellido(apellido);
			p.setEstado(true);
			String mensaje =  dao.registrar(p);
			
			request.setAttribute("mensaje", mensaje);
			
			
			acceso = add;
		}

		RequestDispatcher  vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
