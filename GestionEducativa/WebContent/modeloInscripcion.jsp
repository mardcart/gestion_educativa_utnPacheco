<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Entidad.Alumno" %>
<%@ page import="ModeloDAO.AlumnoDAO" %>
<%@ page import="Entidad.Curso" %>
<%@ page import="ModeloDAO.CursoDAO" %>

<%@ page import="java.util.List" %>    

<body>
<!-- MENU HEADER -->
<%@include file="header.jsp" %>
<!-- FIN MENU HEADER -->

<!-- CONTENIDO CENTRAL -->

	<div id="content">
	<!--HOME-->
		<div id="content-header">
			<div id="breadcrumb"> <a href="Index.jsp" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
		</div>
	<!--FIN HOME-->
	
	<!--ACTION BOXES-->
		<div class="container-fluid">
		<form>
		<!-- id="tablax" este id cambia el modelo en la tabla -->
		   	<table  class="table table-warning  text-center" >
		        <thead>
		        	<th>Seleccionar</th>
		        	<th>id</th>
		            <th>legajo</th>
		            <th>Nombre</th>
		            <th>Apellido </th>
		            <th>email</th>
		            <th>Telefono</th>
		        </thead>
		        <tbody>
				    <%
				    AlumnoDAO dao = new AlumnoDAO();
				   List<Alumno> lst = dao.listadoAlumno();
				   for(Alumno alumno:lst){
				    %>
		
		            <tr>
		            	<td><input type="checkbox" name="idAlumno"  value="<%=alumno.getId()%>"/></td>
		       			<td><%=alumno.getId()%></td>
		                <td><%=alumno.getLegajo() %></td>
		                <td><%=alumno.getNombre() %></td>
		                <td><%=alumno.getApellido() %></td>
		                <td><%=alumno.getEmail() %></td>
		                <td><%=alumno.getTelefono() %></td>
		            </tr>
		            <%} %>
		        </tbody>
		    </table>
        <div class="widget-box">
        <div class="widget-content sm">
          <div  class="form-horizontal">
            <div class="control-group">
              <label class="control-label">Seleccionar curso : </label>
              <div class="controls">
                <select name="idCurso"  class="form-control ">
                <%
                CursoDAO cdao = new CursoDAO();
                List<Curso> lt = cdao.listadoCursos();
                for(Curso curso: lt){
                %>
                  <option value="<%=curso.getId()%>"><%=curso.getNombre() %></option>
                  <%} %>
                </select>
              </div>
            </div>
            <div class="form-actions">
	              <button type="submit" class="btn btn-info btn-block btn-sm" value="btnInscripcionCurso" name="accion">CONFIRMAR INSCRIPCION</button>
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