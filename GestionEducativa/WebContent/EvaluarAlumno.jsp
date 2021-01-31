<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Entidad.Alumno" %>
<%@ page import="ModeloDAO.AlumnoDAO" %>
<%@ page import="Entidad.AlumnoCurso" %>
<%@ page import="ModeloDAO.AlumnoCursoDAO" %>
<%@ page import="Entidad.Curso" %>
<%@ page import="ModeloDAO.CursoDAO" %>

<%@ page import="java.util.List" %>    

<body>
<!-- MENU HEADER -->
<%@include file="headerProf.jsp" %>
<!-- FIN MENU HEADER -->

<!-- CONTENIDO CENTRAL -->

	<div id="content">
	<!--HOME-->
		<div id="content-header">
			<div id="breadcrumb"> <a href="MenuProf.jsp" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
		</div>
	<!--FIN HOME-->
	
	<!--ACTION BOXES-->
		<div class="container-fluid">
		<form>

		<!-- id="tablax" este id cambia el modelo en la tabla -->
        <div class="widget-box">
        <div class="widget-content sm">
          <div  class="form-horizontal">
          <%
		    CursoDAO dao = new CursoDAO();
	        int id = Integer.parseInt((String)request.getAttribute("idCursosAlumnos"));
            Curso curso = dao.buscarCurso(id);
            
          %>
            <div class="form-actions">
 			 <input type="text" class="form-control text-center" name="txtCurso" readonly value="<%=curso.getNombre()%>" >
		   	</div>
		   	<div class="form-actions">
		   	<div class="form-group">
				  <label for="sel1">SELECCIONAR OPCION:</label>
				  <select class="form-control" name="opcionEvaluar">
				    <option value="A">NOTA 1</option>
				    <option value="B">NOTA 2</option>
				    <option value="C">RECUPERATORIO 1</option>
				    <option value="D">RECUPERATORIO 2</option>
				  </select>
			</div>
		   	
		   	</div>		                
		  </div>
		</div>		
		</div>

        <div class="widget-box">
        <div class="widget-content sm">
          <div  class="form-horizontal">
            <div class="form-actions">
	              <button type="submit" class="btn btn-info btn-block btn-sm" value="btnCalificar" name="accion">CALIFICAR ALUMNOS</button>
	        </div>			                
		  </div>
		</div>		
		</div>
	    </form>
		</div>
	<!--FIN ACTION BOXES-->    
	</div>

<!-- FIN CONTENIDO CENTRAL -->

<!-- MENU FOOTER -->
<%@include file="footer.jsp" %>
<!-- FIN MENU FOOTER -->

</body>