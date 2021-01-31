package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Localidad;
import Entidad.Provincia;
import ModeloDAO.LocalidadDAO;
import ModeloDAO.ProvinciaDAO;

/**
 * Servlet implementation class ControladorCargarLocalidad
 */
@WebServlet("/ControladorCargarLocalidad")
public class ControladorCargarLocalidad extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Localidad> lst =new  ArrayList<>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorCargarLocalidad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=iso-8859-1");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		
		if(!id.equals("")) {
			LocalidadDAO dao =new LocalidadDAO();
			lst = dao.listadoLocPedido(Integer.parseInt(id));

		}
			
		for(int i=0;i<lst.size();i++) {  
			Localidad l = lst.get(i);
			out.println("<option value="+l.getId()+">"+l.getNombre()+"</option>");
		}
	}

}
