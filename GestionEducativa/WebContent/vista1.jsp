<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Entidad.Alumno" %>
<%@ page import="ModeloDAO.AlumnoDAO" %>
<%@ page import="Entidad.Curso" %>
<%@ page import="ModeloDAO.CursoDAO" %>
<%@ page import="Entidad.AlumnoCurso" %>
<%@ page import="ModeloDAO.AlumnoCursoDAO" %>

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
		
				<script>
 			$(document).ready(function() {
 		       // show the alert
 		       setTimeout(function() {
 		           $(".alert").alert('close');
 		       }, 2000);
 		});

		</script>
 
			 <% 
			 if(request.getAttribute("mensaje")!=null){
			 %>
			 	<div class="alert <%=request.getAttribute("tipo") %>"  id="success-alert" >
			 	 <strong>Mensaje !  </strong> <%=request.getAttribute("mensaje") %>
				</div>
			<%} %> 
		
		<form>
			<%
		    AlumnoCursoDAO acdao = new AlumnoCursoDAO();
	        CursoDAO cdao = new CursoDAO();

		    String  nombre =(String)request.getAttribute("idcurso");
	        Curso curso = (Curso)cdao.buscarCursoNombre(nombre);
	        
			
			%>

		<!-- id="tablax" este id cambia el modelo en la tabla -->
		   	<table  class="table table-success  text-center" >
		        <thead>
		        	
		        	<th>ID</th>
		            <th>NOMBRE Y APELLIDO</th>
		            <th>NOTA 1</th>
		        </thead>
		        <tbody>
				    <%				    
			        List<AlumnoCurso> lst =  acdao.filtradoCurso(curso.getId());
			        			        
				   for(AlumnoCurso ac:lst){
					AlumnoDAO adao = new AlumnoDAO();
					Alumno alumno = adao.buscarAlumno(ac.getAlumno().getId());
					   %>
		
		            <tr>
		            	<td class="text-center"	><input type="text" name="txtId" class="span1 m-wrap text-center" readonly value="<%=ac.getId() %>"  /></td>
		            	<td ><%=alumno.getNombre() + " " +alumno.getApellido() %></td>
<!-- 		            	<td class="text-center"><input type="text" name="txtNotaAlumno" class="span1 m-wrap text-center" value="0"  /></td> -->		       			
		                 <td class="text-center">
   		                  	<div class="form-group">
							  <select class="form-control-sm" name="nota1" >

							    <option value="0" >0</option>
							    <option value="1" >1</option>
							    <option value="2">2</option>
							    <option value="3">3</option>
							    <option value="4">4</option>
							    <option value="5">5</option>
							    <option value="6">6</option>
							    <option value="7">7</option>
							    <option value="8">8</option>
							    <option value="9">9</option>
							    <option value="10">10</option>

							  </select>
    						</div> 
		                 </td>
		            </tr>
		            <%} %>
		        </tbody>
		    </table>
        <div class="widget-box">
        <div class="widget-content sm">
          <div  class="form-horizontal">
            <div class="form-actions">
	              <button type="submit" class="btn btn-info btn-block btn-sm" value="btnCargarNota1" name="accion">CONFIRMAR PRIMERA EVALUACION</button>
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